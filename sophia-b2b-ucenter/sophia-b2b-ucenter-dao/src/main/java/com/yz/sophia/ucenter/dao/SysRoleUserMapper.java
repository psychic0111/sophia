package com.yz.sophia.ucenter.dao;

import com.yz.sophia.ucenter.model.SysRoleUserExample;
import com.yz.sophia.ucenter.model.SysRoleUserKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRoleUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_user
     *
     * @mbggenerated
     */
    int countByExample(SysRoleUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_user
     *
     * @mbggenerated
     */
    int deleteByExample(SysRoleUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_user
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(SysRoleUserKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_user
     *
     * @mbggenerated
     */
    int insert(SysRoleUserKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_user
     *
     * @mbggenerated
     */
    int insertSelective(SysRoleUserKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_user
     *
     * @mbggenerated
     */
    List<SysRoleUserKey> selectByExample(SysRoleUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_user
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SysRoleUserKey record, @Param("example") SysRoleUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_user
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SysRoleUserKey record, @Param("example") SysRoleUserExample example);
}