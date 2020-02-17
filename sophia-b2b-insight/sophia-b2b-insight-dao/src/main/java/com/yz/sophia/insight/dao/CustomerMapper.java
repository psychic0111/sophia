package com.yz.sophia.insight.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yz.sophia.insight.model.po.Customer;
import com.yz.sophia.insight.model.po.CustomerExample;
import com.yz.sophia.insight.model.qo.CustomerQo;
import com.yz.sophia.insight.model.vo.CustomerInfoVo;

public interface CustomerMapper {
    int countByExample(CustomerExample example);

    int deleteByExample(CustomerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Customer record);

    int insertSelective(Customer record);

    List<Customer> selectByExampleWithBLOBs(CustomerExample example);

    List<Customer> selectByExample(CustomerExample example);

    Customer selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByExampleWithBLOBs(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKeyWithBLOBs(Customer record);

    int updateByPrimaryKey(Customer record);
    
    
    int selectCountByCustomerName(@Param("customerName") String customerName, @Param("customerId") Long customerId);

    /**
     * 查询客户信息列表
     *
     * @param qo
     * @return
     */
    List<CustomerInfoVo> selectCustomerInfoList(CustomerQo qo);
}