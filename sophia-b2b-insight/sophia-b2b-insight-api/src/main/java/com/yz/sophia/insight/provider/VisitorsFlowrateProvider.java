package com.yz.sophia.insight.provider;

import com.yz.sophia.business.api.entity.CommonResponse;
import com.yz.sophia.insight.model.po.RestaurantRank;
import com.yz.sophia.insight.model.po.VisitorsFlowrate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;


/**
 * FeignClient命名规则说明:
 * name 为提供服务的${spring.application.name}名称,不能写错,否则使用api的客户端在注册中心无法找到对应的服务。
 * 		比如sophia-b2b-stargaze-provider 为sophia-b2b-stargaze项目provider模块提供的服务
 * path 为api的相对路径,格式:${server.servlet.context-path|/相对路径
 * 		比如/api/customer
 */
@Api("旅游数据洞察相关接口")
@FeignClient(name = "sophia-b2b-insight-provider",path = "/api/travel")
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/travel")
public interface VisitorsFlowrateProvider {

	@GetMapping("/")
	@ApiOperation("根据开始时间结束时间与地点搜索旅游数据")
	CommonResponse<List<VisitorsFlowrate>> getVisitorsFlowrateByDateAndSpot(@ApiParam(name = "spot", value = "地点名称", defaultValue = "", required = true) String spot,
																			@ApiParam(name = "startDate", value = "开始时间", defaultValue = "", required = true) String startDate,
																			@ApiParam(name = "endDate", value = "结束时间", defaultValue = "", required = true) String endDate);

}
