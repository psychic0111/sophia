package com.yz.sophia.ai.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.yz.sophia.business.api.exception.BusinessException;
import com.yz.sophia.business.core.util.BeanUtils;
import com.yz.sophia.business.core.util.DateUtils;
import com.yz.sophia.ai.dao.CustomerMapper;
import com.yz.sophia.ai.model.enums.CooperationModeEnum;
import com.yz.sophia.ai.model.po.Customer;
import com.yz.sophia.ai.model.qo.CustomerQo;
import com.yz.sophia.ai.model.request.CustomerAddReq;
import com.yz.sophia.ai.model.vo.CustomerInfoVo;
import com.yz.sophia.ai.model.vo.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerService {

    //@Autowired
    private CustomerMapper customerMapper;

    /**
     * 获取客户详细信息
     * @param id
     * @return
     */
    public Customer getCustomer(Long id) {
        return customerMapper.selectByPrimaryKey(id);
    }

    
    /**
     * 修改客户信息
     * @param customer
     */
    public void modify(Customer customer) {
        customerMapper.updateByPrimaryKey(customer);
    }

    /**
     * 启用/禁用
     * @param customerId
     * @param enable
     * @return
     */
    public void enable(String user, Long customerId, Boolean enable) {
    	Customer customer = customerMapper.selectByPrimaryKey(customerId);
        customer.setActiveFlag(enable);
        customer.setUpdateBy(user);
        customerMapper.updateByPrimaryKeySelective(customer);
    }

    /**
     * 新增客户(保存草稿)
     * @param req
     */
    public Customer addCustomer(User user, CustomerAddReq req) {
    	Customer customer = BeanUtils.convert(Customer.class, req);
        customer.setChannelSecondCode(req.getFirstCategoryCode());
        
        if (customer.getCooperationMode().equals(CooperationModeEnum.TEMP.getCode())) {
        	customer.setTempCreditLimit(customer.getCreditLimit());
        	customer.setCreditLimit(BigDecimal.ZERO);
        	customer.setTempBeginTime(DateUtils.oneDayBeginTime(customer.getTempBeginTime()));
        	customer.setTempEndTime(DateUtils.oneDayEndTime(customer.getTempEndTime()));
        }
        
        if (StringUtils.isNotBlank(req.getRegionProvinceName()) && StringUtils.isNotBlank(req.getRegionCity()) && StringUtils.isNotBlank(req.getRegionArea())) {
			/*
			 * double[] resolveAddress = null; if (resolveAddress != null) {
			 * customer.setLongitude(BigDecimal.valueOf(resolveAddress[0]));
			 * customer.setLatitude(BigDecimal.valueOf(resolveAddress[1])); }
			 */
        }
        String filePath = "[]";
        if (Objects.nonNull(req.getUploadFileList())) {
            try {
                filePath = JSON.toJSONString(req.getUploadFileList());
            } catch (Exception e) {
                log.error("解析附件时出错", e);
            }
        }
        Customer beforCustomer = null;
        if (Objects.nonNull(req.getId()) && Objects.nonNull(beforCustomer = customerMapper.selectByPrimaryKey(req.getId()))) {
            if (customerMapper.selectCountByCustomerName(req.getCustomerName(), req.getId()) > 0) {
                throw new BusinessException("客户名称已存在");
            }
            org.springframework.beans.BeanUtils.copyProperties(req, beforCustomer);
            if (beforCustomer.getCooperationMode().equals(CooperationModeEnum.TEMP.getCode())) {
            	beforCustomer.setTempCreditLimit(req.getCreditLimit());
            	beforCustomer.setCreditLimit(BigDecimal.ZERO);
            	beforCustomer.setTempBeginTime(DateUtils.oneDayBeginTime(beforCustomer.getTempBeginTime()));
            	beforCustomer.setTempEndTime(DateUtils.oneDayEndTime(beforCustomer.getTempEndTime()));
            }
            beforCustomer.setFilePath(filePath);
            beforCustomer.setUpdateBy(user.getUserName());
            if (log.isDebugEnabled()) {
                log.debug("编辑客户信息" + customer.toString());
            }
            customerMapper.updateByPrimaryKeySelective(beforCustomer);
            return beforCustomer;
        } else {
            if (customerMapper.selectCountByCustomerName(req.getCustomerName(), null) > 0) {
                throw new BusinessException("客户名称已存在");
            }
            this.initCustomer(user, customer);
            customer.setFilePath(filePath);
            if (log.isDebugEnabled()) {
                log.debug("入库客户信息" + customer.toString());
            }
            customerMapper.insertSelective(customer);
            return customer;
        }
    }


    /**
     * 初始化客户默认值
     * @param user
     * @param customer
     */
    private void initCustomer(User user, Customer customer) {
        if (Objects.isNull(customer.getSalesUserId()) || customer.getSalesUserId() == 0) {
            customer.setSalesUserId(user.getUserId());
            customer.setSalesUserName(user.getUserName());
        }
        if (Objects.isNull(customer.getTempBeginTime()) || Objects.isNull(customer.getTempEndTime())) {
            customer.setTempBeginTime(DateUtils.maxDateTime());
            customer.setTempEndTime(DateUtils.maxDateTime());
        }
        customer.setCreateBy(user.getUserName());
        customer.setSaleOrganization(customer.getCompanyCode()+"");//默认公司代码
        customer.setCreditRange(customer.getCompanyCode()+"");//默认公司代码
        customer.setChannelFirstCode("20");
        customer.setDistributionChannel("20");//写死
        customer.setSaleRegion("610000");//写死
    }

    /**
     * 查询客户列表
     *
     * @param qo
     * @return
     */
    public List<CustomerInfoVo> findCustomerInfoList(CustomerQo qo) {
        if (qo.getOrderField() == null) {
            qo.setOrderField(0);
            qo.setSortType(1);
        }
        if (qo.isPageable()) {
            PageHelper.startPage(qo.getPageNum(), qo.getPageSize(), qo.isCount());
        }
        return customerMapper.selectCustomerInfoList(qo);
    }
   
}
