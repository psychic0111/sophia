package com.yz.sophia.insight.provider;

import com.yz.sophia.business.api.entity.CommonResponse;
import com.yz.sophia.business.api.entity.Page;
import com.yz.sophia.insight.model.po.ProductInsight;
import com.yz.sophia.insight.model.vo.LineChartDataVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * FeignClient命名规则说明:
 * name 为提供服务的${spring.application.name}名称,不能写错,否则使用api的客户端在注册中心无法找到对应的服务。
 * 		比如sophia-b2b-stargaze-provider 为sophia-b2b-stargaze项目provider模块提供的服务
 * path 为api的相对路径,格式:${server.servlet.context-path|/相对路径
 * 		比如/api/customer
 */
@Api("品牌检索服务")
@FeignClient(name = "sophia-b2b-insight-provider",path = "/api/product")
@RequestMapping("/product")
public interface ProductInsightProvider {

	@RequestMapping(
			value = {"/queryPlateForm"},
			method = {RequestMethod.GET},
			produces = {"application/json;charset=UTF-8"}
	)
	@ApiOperation(
			value = "查询所有平台",
			notes = "查询所有平台"
	)
	@ResponseBody
	CommonResponse<List<String>> queryPlateForm();

	@RequestMapping(
            value = {"/queryStore"},
            method = {RequestMethod.GET},
            produces = {"application/json;charset=UTF-8"}
    )
    @ApiOperation(
            value = "查询平台下的店铺",
            notes = "查询平台下的店铺"
    )
    @ResponseBody
    CommonResponse<List<String>> queryStoreByPlateForm(@ApiParam(name = "platForm", value = "平台", defaultValue = "苏宁", required = true) @RequestParam(name = "platForm", required = true) String platForm);

    @GetMapping("/listProductInsight")
	@ApiOperation("检索品牌数据")
	CommonResponse<Page<ProductInsight>> listProductInsight(@ApiParam(name = "productCategory", value = "品类", defaultValue = "手机", required = false) String productCategory,
                                                            @ApiParam(name = "productBrand", value = "品牌", defaultValue = "华为", required = false) String productBrand,
                                                            @ApiParam(name = "platForm", value = "平台", defaultValue = "苏宁", required = false) String platForm,
                                                            @ApiParam(name = "store", value = "店铺", defaultValue = "荣耀苏宁自营旗舰店", required = false) String store,
                                                            @ApiParam(name = "productModel", value = "系列", defaultValue = "荣耀20 PRO", required = false) String productModel,
                                                            @ApiParam(name = "evaluateType", value = "评论情感值：0-中性 1-正面 2-负面", defaultValue = "", required = false) Integer evaluateType,
                                                            @ApiParam(name = "evaluateCategory", value = "评论类型：产品 运营 物流 其他", defaultValue = "", required = false) String evaluateCategory,
                                                            @ApiParam(name = "beginDate", value = "评论时间-起始时间", defaultValue = "", required = false) String beginDate,
                                                            @ApiParam(name = "endDate", value = "评论时间-截止时间", defaultValue = "", required = false) String endDate,
                                                            @ApiParam(name = "orderField", value = "排序字段, 例如：评论时间=evaluate_time", defaultValue = "evaluate_time", required = false) String orderField,
                                                            @ApiParam(name = "orderType", value = "排序类型, 例如：升序=asc, 降序=desc", defaultValue = "desc", required = false) String orderType,
                                                            Integer pageIndex, Integer pageSize);

	@GetMapping("/lineChart")
	@ApiOperation("品牌数据曲线图数据")
	CommonResponse<List<LineChartDataVo>> productInsightLineChart(@ApiParam(name = "productCategory", value = "品类", defaultValue = "手机", required = false) String productCategory,
																  @ApiParam(name = "productBrand", value = "品牌", defaultValue = "华为", required = false) String productBrand,
																  @ApiParam(name = "platForm", value = "平台", defaultValue = "苏宁", required = false) String platForm,
																  @ApiParam(name = "store", value = "店铺", defaultValue = "荣耀苏宁自营旗舰店", required = false) String store,
																  @ApiParam(name = "productModel", value = "系列", defaultValue = "荣耀20 PRO", required = false) String productModel,
																  @ApiParam(name = "evaluateType", value = "评论情感值：0-中性 1-正面 2-负面", defaultValue = "", required = false) Integer evaluateType,
																  @ApiParam(name = "evaluateCategory", value = "评论类型：产品 运营 物流 其他", defaultValue = "", required = false) String evaluateCategory,
																  @ApiParam(name = "beginDate", value = "评论时间-起始时间", defaultValue = "", required = false) String beginDate,
																  @ApiParam(name = "endDate", value = "评论时间-截止时间", defaultValue = "", required = false) String endDate);
}
