package com.yz.sophia.insight.service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.yz.sophia.business.api.exception.BusinessException;
import com.yz.sophia.business.core.util.BeanUtils;
import com.yz.sophia.business.core.util.DateUtils;
import com.yz.sophia.insight.dao.CustomerMapper;
import com.yz.sophia.insight.model.enums.CooperationModeEnum;
import com.yz.sophia.insight.model.po.Customer;
import com.yz.sophia.insight.model.qo.CustomerQo;
import com.yz.sophia.insight.model.request.CustomerAddReq;
import com.yz.sophia.insight.model.vo.CustomerInfoVo;
import com.yz.sophia.insight.model.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class LzSearchService {


}
