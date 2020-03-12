package com.yz.sophia.ai.provider;

import com.yz.sophia.business.api.entity.CommonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.yz.sophia.ai.model.request.CustomerAddReq;
import com.yz.sophia.ai.model.response.CustomerDetailsResp;


/**
 * FeignClient命名规则说明:
 * name 为提供服务的${spring.application.name}名称,不能写错,否则使用api的客户端在注册中心无法找到对应的服务。
 * 		比如sophia-b2b-ai-provider 为sophia-b2b-ai项目provider模块提供的服务
 * path 为api的相对路径,格式:${server.servlet.context-path|/相对路径
 * 		比如/api/customer
 */
@Api("客户管理服务")
@FeignClient(name = "sophia-b2b-ai-provider",path = "/api/customer")
@RequestMapping("/customer")
public interface CustomerProvider {

	// 服务中方法的映射路径,确保参数一致
	@GetMapping("/get")
	@ApiOperation("获取客户信息")
	CommonResponse<CustomerDetailsResp> getCustomer(@RequestParam("customerId") Long customerId);

	@PostMapping("/enable")
	@ApiOperation("禁用/启用")
	CommonResponse enable(@RequestParam("customerId") Long customerId, @RequestParam("enable") Boolean enable);

	@PostMapping("/add")
	@ApiOperation("新增客户(保存草稿)")
	CommonResponse addCustomer(@RequestBody CustomerAddReq req);
}
