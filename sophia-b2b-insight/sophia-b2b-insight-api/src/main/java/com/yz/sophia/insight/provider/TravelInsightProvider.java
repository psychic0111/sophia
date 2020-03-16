package com.yz.sophia.insight.provider;

import com.yz.sophia.business.api.entity.CommonResponse;
import com.yz.sophia.insight.model.po.TravelInsight;
import com.yz.sophia.insight.model.po.VisitorsFlowrate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


/**
 * FeignClient命名规则说明:
 * name 为提供服务的${spring.application.name}名称,不能写错,否则使用api的客户端在注册中心无法找到对应的服务。
 * 		比如sophia-b2b-stargaze-provider 为sophia-b2b-stargaze项目provider模块提供的服务
 * path 为api的相对路径,格式:${server.servlet.context-path|/相对路径
 * 		比如/api/customer
 */
@Api("旅游实时查询火车数据-洞察相关接口")
@FeignClient(name = "sophia-b2b-insight-provider",path = "/api/travelInsight")
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/travelInsight")
public interface TravelInsightProvider {

	@GetMapping("/")
	@ApiOperation("实时查询旅游火车数据")
	CommonResponse<TravelInsight> getTravelInsight();

}
