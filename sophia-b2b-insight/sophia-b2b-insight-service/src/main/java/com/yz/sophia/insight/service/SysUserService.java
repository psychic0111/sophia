package com.yz.sophia.insight.service;

import com.yz.sophia.bsf.utils.SnowflakeIdWorker;
import com.yz.sophia.insight.dao.SysUserMapper;
import com.yz.sophia.insight.model.po.SysUser;
import com.yz.sophia.insight.model.po.SysUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SysUserService {

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;

    public int addUser(SysUser user){
        user.setId(Long.toHexString(snowflakeIdWorker.nextId()));
        user.setCreateTime(new Date());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        int k = userMapper.insertSelective(user);
        return k;
    }

    public int updateUser(SysUser user){
        user.setUpdateTime(new Date());
        return userMapper.updateByPrimaryKey(user);
    }

    public SysUser queryByUserName(String userName){
        SysUserExample example = new SysUserExample();
        example.createCriteria().andUsernameEqualTo(userName);
        List<SysUser> sysUserList = userMapper.selectByExample(example);
        if(sysUserList != null && !sysUserList.isEmpty()){
            return sysUserList.get(0);
        }else {
            return null;
        }
    }
    public SysUser queryByMobile(String mobile){
        SysUserExample example = new SysUserExample();
        example.createCriteria().andMobileEqualTo(mobile);
        List<SysUser> sysUserList = userMapper.selectByExample(example);
        if(sysUserList != null && !sysUserList.isEmpty()){
            return sysUserList.get(0);
        }else {
            return null;
        }
    }
}
