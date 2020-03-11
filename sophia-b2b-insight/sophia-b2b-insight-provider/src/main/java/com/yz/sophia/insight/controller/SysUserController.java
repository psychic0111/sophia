package com.yz.sophia.insight.controller;

import com.yz.sophia.business.api.entity.CommonResponse;
import com.yz.sophia.insight.model.po.SysUser;
import com.yz.sophia.insight.provider.SysUserProvider;
import com.yz.sophia.insight.service.SysUserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 用户接口
 */
@Slf4j
@CrossOrigin(origins = "*",maxAge = 3600)
@RestController("/user")
public class SysUserController extends BaseController implements SysUserProvider {


    @Autowired
    private SysUserService sysUserService;

    @Override
    public CommonResponse<Integer> addUser(String username, String password, String nickname, String headImgUrl, String mobile, String sex, String enabled, String type, String company) {
        return null;
    }

    @Override
    @ResponseBody
    @RequestMapping(value="/register",method = RequestMethod.POST)
    @ApiOperation("用户注册")
    public CommonResponse<SysUser> addUserModel(@ModelAttribute SysUser user) {
        return super.visit(() -> {
            sysUserService.addUser(user);
            user.setPassword(null);
            return user;
        });
    }

    @Override
    @ResponseBody
    @RequestMapping(value="/login",method = RequestMethod.POST)
    @ApiOperation("用户登录")
    public CommonResponse<SysUser> userLogin(@ApiParam(name = "username", value = "用户名, 测试账号: admin,user,guest,test", defaultValue = "", required = true) @RequestParam(name = "username", required = true) String username,
                                             @ApiParam(name = "password", value = "密码, 测试账号密码和用户名一样", defaultValue = "", required = true) @RequestParam(name = "password", required = true) String password) {

        CommonResponse<SysUser> resp = null;
        resp = super.visit(() -> {
            SysUser user = sysUserService.queryByUserName(username);
            return user;
        });
        if(resp.getData() == null) {
            resp = CommonResponse.error("用户不存在");
        }else {
            if(!resp.getData().getPassword().equals(password)){
                resp = CommonResponse.error("密码错误");
            }
        }
        return resp;
    }

}
