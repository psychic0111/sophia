package com.yz.sophia.insight.provider;

import com.yz.sophia.business.api.entity.CommonResponse;
import com.yz.sophia.insight.model.po.SysUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * FeignClient命名规则说明:
 * name 为提供服务的${spring.application.name}名称,不能写错,否则使用api的客户端在注册中心无法找到对应的服务。
 * 		比如sophia-b2b-stargaze-provider 为sophia-b2b-stargaze项目provider模块提供的服务
 * path 为api的相对路径,格式:${server.servlet.context-path|/相对路径
 * 		比如/api/customer
 */
@Api("用户相关接口")
@FeignClient(name = "sophia-b2b-insight-provider",path = "/api/user")
@RequestMapping("/user")
public interface SysUserProvider {

	// 服务中方法的映射路径,确保参数一致
	@PostMapping("/add")
	//@ApiOperation("添加用户")
	CommonResponse<Integer> addUser(@ApiParam(name = "username", value = "用户名", defaultValue = "", required = true) String username,
                                    @ApiParam(name = "password", value = "密码", defaultValue = "", required = true) String password,
                                    @ApiParam(name = "nickname", value = "呢称", defaultValue = "", required = false) String nickname,
                                    @ApiParam(name = "headImgUrl", value = "头像", defaultValue = "", required = false) String headImgUrl,
                                    @ApiParam(name = "mobile", value = "手机", defaultValue = "", required = true) String mobile,
                                    @ApiParam(name = "sex", value = "性别：0-男，1-女", defaultValue = "0", required = true) String sex,
                                    @ApiParam(name = "enabled", value = "是否启用：0-禁用, 1-启用", defaultValue = "1", required = false) String enabled,
                                    @ApiParam(name = "type", value = "用户类型", defaultValue = "web", required = false) String type,
                                    @ApiParam(name = "company", value = "合生科技", defaultValue = "合生科技", required = false) String company);

	@PostMapping("/addUser")
	@ApiOperation("添加用户")
	CommonResponse<SysUser> addUserModel(@ModelAttribute SysUser user);

	@PostMapping("/loginByUsername")
	@ApiOperation("用户登录")
	CommonResponse<SysUser> loginByUsername(@ApiParam(name = "username", value = "用户名", defaultValue = "", required = true) String username,
											@ApiParam(name = "password", value = "密码", defaultValue = "", required = true) String password);

	@PostMapping("/loginByMobile")
	@ApiOperation("用户登录")
	CommonResponse<SysUser> loginByMobile(@ApiParam(name = "mobile", value = "用户名", defaultValue = "", required = true) String mobile,
											@ApiParam(name = "password", value = "密码", defaultValue = "", required = true) String password);
}
