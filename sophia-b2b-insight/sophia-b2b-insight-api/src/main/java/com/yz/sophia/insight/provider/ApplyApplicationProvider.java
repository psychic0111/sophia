package com.yz.sophia.insight.provider;

import com.yz.sophia.business.api.entity.CommonResponse;
import com.yz.sophia.insight.model.po.LegalInstrumentInfo;
import com.yz.sophia.insight.model.po.MultilevelMenu;
import com.yz.sophia.insight.model.request.ApplyApplicationReq;
import com.yz.sophia.insight.model.response.ApplyApplicationRelResp;
import com.yz.sophia.insight.model.response.ApplyApplicationResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api("应用申请接口")
@FeignClient(name = "sophia-b2b-insight-provider",path = "/api/application")
@RequestMapping("/apply")
public interface ApplyApplicationProvider {

	// 服务中方法的映射路径,确保参数一致
	@PostMapping("/applicationService")
	@ApiOperation("录入接口")
	CommonResponse applicationService(@RequestBody ApplyApplicationReq applyApplicationQo);

	@PostMapping("/queryApplicationPage")
	@ApiOperation("审核列表分页接口")
	CommonResponse<ApplyApplicationResp> queryApplicationPage(@RequestParam("userId") String userId,Integer pageIndex, Integer pageSize);

	@PostMapping("/queryApplicationInfo")
	@ApiOperation("回显查询接口")
	CommonResponse<ApplyApplicationRelResp> queryApplicationInfo(@RequestParam("applicationCode") String applicationCode);

//	@PostMapping("/auditApplication")
//	@ApiOperation("审核接口")
//	CommonResponse auditApplication(@RequestParam("auditOperate") Integer auditOperate,@RequestParam("applicationCode") String applicationCode);

	@PostMapping("/auditApplication")
	@ApiOperation("删除接口")
	CommonResponse statusApplication(@RequestParam("applicationCode") String applicationCode);

	@GetMapping("/getMultilevelMenu")
	@ApiOperation("菜单选择查询接口")
	CommonResponse<List<MultilevelMenu>> getMultilevelMenu(@RequestParam("menusRank") Integer menusRank , @RequestParam("parentMenusCode") String parentMenusCode);
}
