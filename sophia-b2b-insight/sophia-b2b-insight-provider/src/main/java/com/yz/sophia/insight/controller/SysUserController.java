package com.yz.sophia.insight.controller;

import com.yz.sophia.business.api.entity.CommonResponse;
import com.yz.sophia.insight.model.po.SysUser;
import com.yz.sophia.insight.provider.SysUserProvider;
import com.yz.sophia.insight.service.SysUserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 观星台驾驶舱数据
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
    public CommonResponse<Integer> addUserModel(@ModelAttribute SysUser user) {
        return super.visit(() -> {
            return sysUserService.addUser(user);
        });
    }

}
