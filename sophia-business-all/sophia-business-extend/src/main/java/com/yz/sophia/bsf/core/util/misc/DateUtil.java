package com.yz.sophia.bsf.core.util.misc;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yanglikai on 2019/5/28.
 */
public final class DateUtil {

  private DateUtil() {
  }

  private static final String FORMAT_YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";

  private static final String FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

  public static final String FORMAT_YYMMDD = "yyyyMMdd";

  /**
   * 把日期格式化为yyyy-MM-dd HH:mm:ss字符串
   */
  public static String formatTime(Date date) {
    SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_YYYYMMDDHHMMSS);
    return sdf.format(date);
  }

  /**
   * 把日期格式化为pattern字符串
   */
  public static String formatTime(Date date, String pattern) {
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    return sdf.format(date);
  }
}
