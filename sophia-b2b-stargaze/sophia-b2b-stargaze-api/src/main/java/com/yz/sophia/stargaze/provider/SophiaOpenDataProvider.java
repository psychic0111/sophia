package com.yz.sophia.stargaze.provider;

import com.yz.sophia.business.api.entity.CommonResponse;
import com.yz.sophia.stargaze.model.response.SophiaOpenDataResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * FeignClient命名规则说明:
 * name 为提供服务的${spring.application.name}名称,不能写错,否则使用api的客户端在注册中心无法找到对应的服务。
 * 		比如sophia-b2b-stargaze-provider 为sophia-b2b-stargaze项目provider模块提供的服务
 * path 为api的相对路径,格式:${server.servlet.context-path|/相对路径
 * 		比如/api/customer
 */
@Api("sophia开放服务检索")
@FeignClient(name = "sophia-b2b-stargaze-provider",path = "/api/stargaza")
@RequestMapping("/sophiaOpenData")
public interface SophiaOpenDataProvider {

	// 服务中方法的映射路径,确保参数一致
	@GetMapping("/listSophiaOpenData")
	@ApiOperation("获取检索服务数据")
	CommonResponse<SophiaOpenDataResp> listSophiaOpenData(@RequestBody String keyword, int pageIndex, int pageSize);
}
