package com.yz.sophia.insight.controller;

import com.alibaba.fastjson.JSON;
import com.yz.sophia.business.api.entity.CommonResponse;
import com.yz.sophia.business.core.util.BeanUtils;
import com.yz.sophia.insight.model.enums.CooperationModeEnum;
import com.yz.sophia.insight.model.enums.CustomerStatusEnum;
import com.yz.sophia.insight.model.po.Customer;
import com.yz.sophia.insight.model.request.CustomerAddReq;
import com.yz.sophia.insight.model.response.CustomerDetailsResp;
import com.yz.sophia.insight.model.vo.UploadFile;
import com.yz.sophia.insight.model.vo.User;
import com.yz.sophia.insight.provider.CustomerProvider;
import com.yz.sophia.insight.provider.LzSearchProvider;
import com.yz.sophia.insight.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * eureka api contoller 服务注册的例子
 * 参考文档:
 */
@Slf4j
@RestController
public class LzSearchController extends BaseController implements LzSearchProvider {

	@Override
	public CommonResponse<CustomerDetailsResp> searchArticlesByKeyword(Long customerId) {
		return null;
	}

	@Override
	public CommonResponse searchArticlesByWebsite(Long customerId, Boolean enable) {
		return null;
	}

	@Override
	public CommonResponse searchArticlesBySource(CustomerAddReq req) {
		return null;
	}
}