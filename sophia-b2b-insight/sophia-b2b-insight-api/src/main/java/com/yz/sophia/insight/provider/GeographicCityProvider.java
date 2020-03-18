package com.yz.sophia.insight.provider;

import com.yz.sophia.business.api.entity.CommonResponse;
import com.yz.sophia.insight.model.response.GeographicCityResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * FeignClient命名规则说明:
 * name 为提供服务的${spring.application.name}名称,不能写错,否则使用api的客户端在注册中心无法找到对应的服务。
 * 		比如sophia-b2b-stargaze-provider 为sophia-b2b-stargaze项目provider模块提供的服务
 * path 为api的相对路径,格式:${server.servlet.context-path|/相对路径
 * 		比如/api/customer
 */
@Api("地理统计数据服务")
@FeignClient(name = "sophia-b2b-insight-provider",path = "/api/static")
@RequestMapping("/geographic")
public interface GeographicCityProvider {

	// 服务中方法的映射路径,确保参数一致
	@GetMapping("/queryGeographicData")
	@ApiOperation("获取地理统计数据")
	CommonResponse<List<GeographicCityResp>> queryGeographicData(@RequestParam("cityId") String cityId, @RequestParam("cityProvince") String cityProvince);

}
