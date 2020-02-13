package com.yz.sophia.bsf.core.util.excel;

import com.yz.sophia.bsf.core.util.excel.annotation.ExportField;
import com.yz.sophia.bsf.core.util.excel.annotation.ImportField;
import com.yz.sophia.bsf.core.util.excel.annotation.ImportStart;
import com.yz.sophia.bsf.core.util.excel.config.ExcelConfig;
import com.yz.sophia.bsf.core.util.excel.config.ExportConfig;
import com.yz.sophia.bsf.core.util.excel.config.ImportConfig;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.joda.time.DateTime;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by yanglikai on 2019/5/28.
 */
public final class ExcelUtil {

  private ExcelUtil() {
  }

  public static <T> List<T> read(final HttpServletRequest request, final Class target) {
    List<MultipartFile> multipartFiles = getMultipartFile(request);
    if (CollectionUtils.isEmpty(multipartFiles)) {
      throw new IllegalArgumentException("upload file must not be null");
    }

    MultipartFile file = multipartFiles.get(0);
    try (InputStream inputStream = file.getInputStream()) {
      return import0(inputStream, target);
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage(), e);
    }
  }

  public static <T> List<T> read(final String path, final Class target) {
    try (InputStream inputStream = new FileInputStream(path)) {
      return import0(inputStream, target);
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage(), e);
    }
  }

  private static <T> List<T> import0(final InputStream inputStream, final Class target) {
    ImportConfig importConfig = new ImportConfig(target);
    importConfig.config(inputStream);

    ImportStart importStart = (ImportStart) target.getAnnotation(ImportStart.class);
    if (importStart != null) {
      return import0(importConfig, importStart.index());
    }

    return import0(importConfig, 1);
  }

  private static <T> List<T> import0(final ImportConfig config, final int start) {
    ExcelConfig excelConfig =
        ExcelConfig.create()
            .config(config.getTarget())
            .config(config);

    return import0(excelConfig, start);
  }

  private static <T> List<T> import0(final ExcelConfig config, final int start) {
    try (Workbook workbook = WorkbookFactory.create(config.inputStream())) {
      Sheet sheet = workbook.getSheetAt(0);
      if (sheet == null) {
        return new ArrayList<>(0);
      }

      int last = sheet.getLastRowNum();

      List<T> list = new ArrayList<>(last);
      for (int index = start; index <= last; index++) {
        Row row = sheet.getRow(index);
        if (row == null) {
          continue;
        }

        if (isEmptyRow(row)) {
          continue;
        }

        Class target = config.getTarget();
        T obj = (T) target.newInstance();

        Iterator<Cell> iterator = row.cellIterator();
        while (iterator.hasNext()) {
          Cell cell = iterator.next();

          /* 获取导入字段信息 */
          ImportField importField = config.importField(cell.getColumnIndex());
          if (importField == null) {
            continue;
          }

          /* 获取单元格数据 */
          String typeName = importField.type().getSimpleName();
          Object value = obtainCellValue(typeName, cell);

          /* 字段赋值 */
          ReflectUtil.setFieldValue(obj, importField.name(), value);
        }

        list.add(obj);
      }

      return list;
    } catch (Exception ex) {
      throw new IllegalArgumentException("excel import faild");
    }
  }

  private static boolean isEmptyRow(Row row) {
    int firstNbr = row.getFirstCellNum();
    int lastNbr = row.getLastCellNum();

    int emptyNbr = 0;
    for (int index = firstNbr; index < lastNbr; index++) {
      Cell cell = row.getCell(index);

      if (cell == null || cell.getCellTypeEnum() == CellType.BLANK) {
        emptyNbr++;
      }
    }

    if ((lastNbr - firstNbr) == emptyNbr) {
      return true;
    }

    return false;
  }

  public static <T> void write(final HttpServletResponse response, final String fileName,
      final List<T> rows) {
    try {
      if (StringUtils.isEmpty(fileName)) {
        throw new IllegalArgumentException("file name must not be null");
      }

      response.setContentType("application/vnd.ms-excel;charset=UTF-8");
      response.setHeader("Content-Disposition",
          "attachment; filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));

      OutputStream output = response.getOutputStream();

      export0(output, rows);

      output.close();
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage(), e);
    }
  }

  public static <T> void write(final String path, final List<T> rows) {
    try (OutputStream outputStream = new FileOutputStream(path)) {
      export0(outputStream, rows);
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage(), e);
    }
  }

  private static <T> void export0(final OutputStream outputStream, final List<T> rows) {
    if (CollectionUtils.isEmpty(rows)) {
      throw new IllegalArgumentException("rows must be not null");
    }

    Class target = rows.get(0).getClass();

    ExportConfig exportConfig =
        new ExportConfig(target)
            .config(rows)
            .config(outputStream);

    export0(exportConfig);
  }

  private static void export0(final ExportConfig config) {
    ExcelConfig excelConfig =
        ExcelConfig.create()
            .config(config.getTarget())
            .config(config);

    export0(excelConfig);
  }

  private static void export0(final ExcelConfig config) {
    /* 创建workbook */
    try (Workbook book = new SXSSFWorkbook()) {

      /* 创建sheet */
      Sheet sheet = book.createSheet("sheet1");

      /* 打印标题 */
      List<ExportField> exportFields = config.exportFields();

      Row titleRow = sheet.createRow(0);
      for (ExportField title : exportFields) {
        Cell cell = titleRow.createCell(title.index());
        cell.setCellValue(title.title());
      }

      /* 打印数据 */
      int rowIndex = 1;
      List<Object> rows = config.exportRows();
      for (Object row : rows) {
        Row dataRow = sheet.createRow(rowIndex);

        for (ExportField field : exportFields) {
          Cell dataCell = dataRow.createCell(field.index());

          Object value = FieldUtils.readDeclaredField(row, field.name(), true);

          dataCell.setCellValue((String) value);
        }

        rowIndex++;
      }

      /* 输出excel */
      book.write(config.outputStream());
      book.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static List<MultipartFile> getMultipartFile(final HttpServletRequest request) {
    List<MultipartFile> result = new ArrayList<>();
    CommonsMultipartResolver resolver = new CommonsMultipartResolver(
        request.getSession().getServletContext());
    if (resolver.isMultipart(request)) {
      MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
      Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
      while (iterator.hasNext()) {
        String fileName = iterator.next();
        List<MultipartFile> multipartFiles = multipartHttpServletRequest.getFiles(fileName);
        for (MultipartFile multipartFile : multipartFiles) {
          result.add(multipartFile);
        }
      }
    }
    return result;
  }

  private static Object obtainCellValue(String typeName, Cell cell) {
    String value = formatToString(cell);
    if (StringUtils.isBlank(value)) {
      return null;
    }

    if (typeName.equals("Integer")) {
      return Integer.parseInt(value);
    }

    if (typeName.equals("Long")) {
      return Long.parseLong(value);
    }

    if (typeName.equals("BigDecimal")) {
      return BigDecimal.valueOf(Double.parseDouble(value));
    }

    if (typeName.equals("String")) {
      return value;
    }

    if (typeName.equals("Double")) {
      return Double.parseDouble(value);
    }

    if (typeName.equals("Date")) {
      return new DateTime(value).toString("yyyy-MM-dd");
    }

    if (typeName.equals("Boolean")) {
      return Boolean.parseBoolean(value);
    }

    throw new IllegalArgumentException("invalid type");
  }

  private static String formatToString(Cell cell) {
    if (cell.getCellTypeEnum() == CellType.BLANK) {
      return "";
    }

    if (cell.getCellTypeEnum() == CellType.BOOLEAN) {
      return Boolean.toString(cell.getBooleanCellValue());
    }

    if (cell.getCellTypeEnum() == CellType.NUMERIC) {
      String content = null;
      //是否是日期
      if (DateUtil.isCellDateFormatted(cell)) {
        Date date = cell.getDateCellValue();
        content = new DateTime(date).toString("yyyy-MM-dd");
      } else {
        cell.setCellType(CellType.STRING);
        String temp = cell.getStringCellValue();
        // 判断是否包含小数点，如果不含小数点，则以字符串读取，如果含小数点，则转换为Double类型的字符串
        if (temp.indexOf('.') > -1) {
          content = String.valueOf(new Double(temp)).trim();
        } else {
          content = temp.trim();
        }
      }
      return content;
    }

    if (cell.getCellTypeEnum() == CellType.STRING) {
      return cell.getStringCellValue().trim();
    }

    if (cell.getCellTypeEnum() == CellType.ERROR) {
      return "";
    }

    if (cell.getCellTypeEnum() == CellType.FORMULA) {
      cell.setCellType(CellType.STRING);
      String content = cell.getStringCellValue().trim();

      if (content != null) {
        content = content.replaceAll("#N/A", "").trim();
      }
      return content;
    }

    return null;
  }
}
