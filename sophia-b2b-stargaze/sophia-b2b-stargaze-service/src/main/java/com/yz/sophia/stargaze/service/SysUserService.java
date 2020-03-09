package com.yz.sophia.stargaze.service;

import com.yz.sophia.bsf.utils.SnowflakeIdWorker;
import com.yz.sophia.stargaze.dao.SysUserMapper;
import com.yz.sophia.stargaze.model.po.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SysUserService {

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;

    public int addUser(SysUser user){
        user.setId(Long.toHexString(snowflakeIdWorker.nextId()));
        user.setCreateTime(new Date());
        int k = userMapper.insert(user);
        return k;
    }

    public int updateUser(SysUser user){
        user.setUpdateTime(new Date());
        return userMapper.updateByPrimaryKey(user);
    }
}
