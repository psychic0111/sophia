package com.yz.sophia.ucenter.service;

import com.yz.sophia.ucenter.core.utils.SnowflakeIdWorker;
import com.yz.sophia.ucenter.dao.SysRoleUserMapper;
import com.yz.sophia.ucenter.dao.SysUserMapper;
import com.yz.sophia.ucenter.model.SysRoleUserExample;
import com.yz.sophia.ucenter.model.SysRoleUserKey;
import com.yz.sophia.ucenter.model.SysUser;
import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SysRoleUserMapper roleUserMapper;

    @Autowired
    private SnowflakeIdWorker worker;

    public int addUser(SysUser user){
        user.setId(Long.toBinaryString(worker.nextId()));
        user.setCreateTime(new Date());
        return userMapper.insert(user);
    }

    public int updateUser(SysUser user){
        user.setUpdateTime(new Date());
        return userMapper.updateByPrimaryKey(user);
    }

    public int markDeleteUser(String userId){
        return userMapper.deleteByPrimaryKey(userId);
    }

    public SysUser getUser(String userId){
        return userMapper.selectByPrimaryKey(userId);
    }

    /**
     * 禁用用户
     * @param userId 用户ID
     * @return
     */
    public int disableUser(String userId){
        SysUser user = getUser(userId);
        user.setEnabled(false);
        return updateUser(user);
    }

    /**
     * 启用用户
     * @param userId 用户ID
     * @return
     */
    public int enableUser(String userId){
        SysUser user = getUser(userId);
        user.setEnabled(true);
        return updateUser(user);
    }

    /**
     * 用户关联角色
     * @param userId 用户ID
     * @param roleIds 角色ID
     * @return
     */
    public int relateRoles(String userId, int[] roleIds){
        SysRoleUserExample roleUserExample = new SysRoleUserExample();
        roleUserExample.createCriteria().andUserIdEqualTo(userId);
        List<SysRoleUserKey> sysRoleUserKeys = roleUserMapper.selectByExample(roleUserExample);
        if(sysRoleUserKeys != null && !sysRoleUserKeys.isEmpty()){
            roleUserMapper.deleteByExample(roleUserExample);
        }

        int i = 0;
        for(int roleId : roleIds){
            SysRoleUserKey sysRoleUserKey = new SysRoleUserKey();
            sysRoleUserKey.setRoleId(roleId);
            sysRoleUserKey.setUserId(userId);
            roleUserMapper.insert(sysRoleUserKey);
            i++;
        }
        return i;
    }
}
