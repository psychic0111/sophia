package com.yz.sophia.ucenter.service;

import com.yz.sophia.ucenter.dao.SysRoleMapper;
import com.yz.sophia.ucenter.dao.SysRoleMenuMapper;
import com.yz.sophia.ucenter.dao.SysRoleUserMapper;
import com.yz.sophia.ucenter.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private SysRoleMapper roleMapper;

    @Autowired
    private SysRoleMenuMapper roleMenuMapper;

    @Autowired
    private SysRoleUserMapper roleUserMapper;

    public SysRole getRole(int roleId){
        return roleMapper.selectByPrimaryKey(roleId);
    }

    public int addRole(SysRole role){
        return roleMapper.insert(role);
    }

    public int updateRole(SysRole role){
        return roleMapper.updateByPrimaryKey(role);
    }

    public int deleteRole(int roleId){
        // 删除角色前，删除关系表数据
        SysRoleMenuExample roleMenuExample = new SysRoleMenuExample();
        roleMenuExample.createCriteria().andRoleIdEqualTo(roleId);
        roleMenuMapper.deleteByExample(roleMenuExample);

        SysRoleUserExample roleUserExample = new SysRoleUserExample();
        roleUserExample.createCriteria().andRoleIdEqualTo(roleId);
        roleUserMapper.deleteByExample(roleUserExample);

        return roleMapper.deleteByPrimaryKey(roleId);
    }

    public int relatedUsers(int roleId, String[] userIds){
        SysRoleUserExample roleUserExample = new SysRoleUserExample();
        roleUserExample.createCriteria().andRoleIdEqualTo(roleId);
        List<SysRoleUserKey> sysRoleUserKeys = roleUserMapper.selectByExample(roleUserExample);
        if(sysRoleUserKeys != null && !sysRoleUserKeys.isEmpty()){
            roleUserMapper.deleteByExample(roleUserExample);
        }

        int i = 0;
        for(String userId : userIds){
            SysRoleUserKey sysRoleUserKey = new SysRoleUserKey();
            sysRoleUserKey.setRoleId(roleId);
            sysRoleUserKey.setUserId(userId);
            roleUserMapper.insert(sysRoleUserKey);
            i++;
        }
        return i;
    }

    public int relateMenus(int roleId, int[] menuIds){
        SysRoleMenuExample sysRoleMenuExample = new SysRoleMenuExample();
        sysRoleMenuExample.createCriteria().andRoleIdEqualTo(roleId);
        List<SysRoleMenuKey> sysRoleMenuKeys = roleMenuMapper.selectByExample(sysRoleMenuExample);
        if(sysRoleMenuKeys != null && !sysRoleMenuKeys.isEmpty()){
            roleMenuMapper.deleteByExample(sysRoleMenuExample);
        }

        int i = 0;
        for(int menuId : menuIds){
            SysRoleMenuKey sysRoleMenuKey = new SysRoleMenuKey();
            sysRoleMenuKey.setRoleId(roleId);
            sysRoleMenuKey.setMenuId(menuId);
            roleMenuMapper.insert(sysRoleMenuKey);
            i++;
        }
        return i;
    }
}
