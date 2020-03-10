package com.yz.sophia.insight.controller;

import com.yz.sophia.business.api.entity.CommonResponse;
import com.yz.sophia.business.api.entity.Page;
import com.yz.sophia.insight.model.po.ProductInsight;
import com.yz.sophia.insight.model.vo.LineChartDataVo;
import com.yz.sophia.insight.provider.ProductInsightProvider;
import com.yz.sophia.insight.service.ProductInsightService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * 观星台驾驶舱数据
 */
@Slf4j
@CrossOrigin(origins = "*",maxAge = 3600)
@RestController("/product")
public class ProductInsightController extends BaseController implements ProductInsightProvider {


    @Autowired
    private ProductInsightService productInsightService;

    @Override
    @RequestMapping(
            value = {"/listProductInsight"},
            method = {RequestMethod.GET},
            produces = {"application/json;charset=UTF-8"}
    )
    @ApiOperation(
            value = "品牌数据检索",
            notes = "根据条件查询品牌数据"
    )
    @ResponseBody
    public CommonResponse<Page<ProductInsight>> listProductInsight(@ApiParam(name = "productCategory", value = "品类", defaultValue = "手机", required = false) @RequestParam(name = "productCategory", required = false) String productCategory,
                                                                   @ApiParam(name = "productBrand", value = "品牌", defaultValue = "华为", required = false) @RequestParam(name = "productBrand", required = false) String productBrand,
                                                                   @ApiParam(name = "platForm", value = "平台", defaultValue = "苏宁", required = false) @RequestParam(name = "platForm", required = false) String platForm,
                                                                   @ApiParam(name = "store", value = "店铺", defaultValue = "荣耀苏宁自营旗舰店", required = false) @RequestParam(name = "store", required = false) String store,
                                                                   @ApiParam(name = "productModel", value = "系列", defaultValue = "荣耀20 PRO", required = false) @RequestParam(name = "productModel", required = false) String productModel,
                                                                   @ApiParam(name = "evaluateCategory", value = "评论情感值：0-中性 1-正面 2-负面", defaultValue = "", required = false) @RequestParam(name = "evaluateCategory", required = false) Integer evaluateCategory,
                                                                   @ApiParam(name = "evaluateDimension", value = "评论维度：产品 运营 物流 其他", defaultValue = "", required = false) @RequestParam(name = "evaluateDimension", required = false) String evaluateDimension,
                                                                   @ApiParam(name = "beginDate", value = "评论时间-起始时间，格式：2020-03-08 13:00:00", defaultValue = "", required = false) @RequestParam(name = "beginDate", required = false) String beginDate,
                                                                   @ApiParam(name = "endDate", value = "评论时间-截止时间，格式：2020-03-08 23:00:00", defaultValue = "", required = false) @RequestParam(name = "endDate", required = false) String endDate,
                                                                   @ApiParam(name = "orderField", value = "排序字段, 例如：评论时间=evaluate_time", defaultValue = "evaluate_time", required = false) @RequestParam(name = "orderField", required = false) String orderField,
                                                                   @ApiParam(name = "orderType", value = "排序类型, 例如：升序=asc, 降序=desc", defaultValue = "desc", required = false) @RequestParam(name = "orderType", required = false) String orderType,
                                                                   Integer pageIndex, Integer pageSize) {
        CommonResponse<Page<ProductInsight>> respData = new CommonResponse<Page<ProductInsight>>();
        try {
            respData = super.visit(() -> {
                SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date begin = null;
                Date end = null;
                if(!StringUtils.isBlank(beginDate)){
                    begin = fmt.parse(beginDate);
                }
                if(!StringUtils.isBlank(endDate)){
                    end = fmt.parse(endDate);
                }
                Page<ProductInsight> page = productInsightService.listProductInsight(productCategory, productBrand, platForm, productModel, store, evaluateCategory, evaluateDimension, begin, end, orderField, orderType, pageIndex, pageSize);

                return page;
            });
        } catch (Exception e) {
            log.info("查询品牌数据接口异常：e:"+e.getMessage());
            e.printStackTrace();
        }
        return respData;
    }

    @Override
    @RequestMapping(
            value = {"/lineChart"},
            method = {RequestMethod.GET},
            produces = {"application/json;charset=UTF-8"}
    )
    @ApiOperation(
            value = "曲线图数据接口",
            notes = "曲线图数据接口"
    )
    @ResponseBody
    public CommonResponse<List<LineChartDataVo>> productInsightLineChart(@ApiParam(name = "productCategory", value = "品类", defaultValue = "手机", required = false) @RequestParam(name = "productCategory", required = false) String productCategory,
                                                                         @ApiParam(name = "productBrand", value = "品牌", defaultValue = "华为", required = false) @RequestParam(name = "productBrand", required = false) String productBrand,
                                                                         @ApiParam(name = "platForm", value = "平台", defaultValue = "苏宁", required = false) @RequestParam(name = "platForm", required = false) String platForm,
                                                                         @ApiParam(name = "store", value = "店铺", defaultValue = "荣耀苏宁自营旗舰店", required = false) @RequestParam(name = "store", required = false) String store,
                                                                         @ApiParam(name = "productModel", value = "系列", defaultValue = "荣耀20 PRO", required = false) @RequestParam(name = "productModel", required = false) String productModel,
                                                                         @ApiParam(name = "evaluateCategory", value = "评论情感值：0-中性 1-正面 2-负面", defaultValue = "", required = false) @RequestParam(name = "evaluateCategory", required = false) Integer evaluateCategory,
                                                                         @ApiParam(name = "evaluateDimension", value = "评论维度：产品 运营 物流 其他", defaultValue = "", required = false) @RequestParam(name = "evaluateDimension", required = false) String evaluateDimension,
                                                                         @ApiParam(name = "beginDate", value = "评论时间-起始时间，格式：2020-03-08 13:00:00", defaultValue = "", required = false) @RequestParam(name = "beginDate", required = false) String beginDate,
                                                                         @ApiParam(name = "endDate", value = "评论时间-截止时间，格式：2020-03-08 23:00:00", defaultValue = "", required = false) @RequestParam(name = "endDate", required = false) String endDate) {
        CommonResponse<List<LineChartDataVo>> respData = null;
        try {
            respData = super.visit(() -> {
                SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date begin = null;
                Date end = null;
                if(!StringUtils.isBlank(beginDate)){
                    begin = fmt.parse(beginDate);
                }
                if(!StringUtils.isBlank(endDate)){
                    end = fmt.parse(endDate);
                }
                List<LineChartDataVo> dataList = productInsightService.productInsightLineChart(productCategory, productBrand, platForm, productModel, store, evaluateCategory, evaluateDimension, begin, end, TimeUnit.DAYS.name());

                if(dataList != null && dataList.size() == 1){
                    dataList = productInsightService.productInsightLineChart(productCategory, productBrand, platForm, productModel, store, evaluateCategory, evaluateDimension, begin, end, TimeUnit.HOURS.name());
                }

                return dataList;
            });
        } catch (Exception e) {
            log.info("曲线图检索数据接口异常：e:"+e.getMessage());
            e.printStackTrace();
        }
        return respData;
    }
}
