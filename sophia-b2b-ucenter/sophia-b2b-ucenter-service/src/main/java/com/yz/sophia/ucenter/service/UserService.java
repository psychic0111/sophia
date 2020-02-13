package com.yz.sophia.ucenter.service;

import com.yz.sophia.ucenter.dao.SysUserMapper;
import com.yz.sophia.ucenter.model.SysUser;
import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;

public class UserService {

    private SysUserMapper userMapper;

    public int addUser(SysUser user){
        return userMapper.insert(user);
    }
}
