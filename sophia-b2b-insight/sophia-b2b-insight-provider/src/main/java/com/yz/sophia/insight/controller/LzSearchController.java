package com.yz.sophia.insight.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yz.sophia.business.api.entity.CommonResponse;
import com.yz.sophia.business.core.util.BeanUtils;
import com.yz.sophia.insight.core.config.ApiConfig;
import com.yz.sophia.insight.core.config.InsightConfig;
import com.yz.sophia.insight.model.enums.CooperationModeEnum;
import com.yz.sophia.insight.model.enums.CustomerStatusEnum;
import com.yz.sophia.insight.model.po.Customer;
import com.yz.sophia.insight.model.request.CustomerAddReq;
import com.yz.sophia.insight.model.response.CustomerDetailsResp;
import com.yz.sophia.insight.model.response.LzSearchBodyResp;
import com.yz.sophia.insight.model.vo.UploadFile;
import com.yz.sophia.insight.model.vo.User;
import com.yz.sophia.insight.provider.CustomerProvider;
import com.yz.sophia.insight.provider.LzSearchProvider;
import com.yz.sophia.insight.service.CustomerService;
import com.yz.sophia.insight.service.LzSearchService;
import com.yz.sophia.insight.util.ApiSignUtils;
import com.yz.sophia.insight.util.HttpUtils;
import com.yz.sophia.insight.util.RSAUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * eureka api contoller 服务注册的例子
 * 参考文档:
 */
@Slf4j
@RestController
public class LzSearchController extends BaseController implements LzSearchProvider {

	@Autowired
	private LzSearchService searchService;

	@RequestMapping(
			value = {"/searchArticlesByKeyword"},
			method = {RequestMethod.GET},
			produces = {"application/json;charset=UTF-8"}
	)
	@ApiOperation(
			value = "根据关键词查询文章",
			notes = "根据关键词查询文章"
	)
	@ResponseBody
	@Override
	public CommonResponse<LzSearchBodyResp> searchArticlesByKeyword(String keyword, Integer emotion, Integer position, String startTime, String endTime, int pageIndex, int pageRows) {
		CommonResponse<LzSearchBodyResp> resp = null;
		try {
			resp = super.visit(() -> {
				LzSearchBodyResp bodyResp = searchService.searchArticlesByKeyword(keyword, emotion, position, startTime, endTime, pageIndex, pageRows);
				return bodyResp;
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}


	@RequestMapping(
			value = {"/searchArticlesByWebsite"},
			method = {RequestMethod.GET},
			produces = {"application/json;charset=UTF-8"}
	)
	@ApiOperation(
			value = "根据网站查询文章",
			notes = "根据网站查询文章"
	)
	@ResponseBody
	@Override
	public CommonResponse<LzSearchBodyResp> searchArticlesByWebsite(String domain, Integer emotion, String startTime, String endTime, int pageIndex, int pageRows) {
		CommonResponse<LzSearchBodyResp> resp = null;
		try {
			resp = super.visit(() -> {
				LzSearchBodyResp bodyResp = searchService.searchArticlesByWebsite(domain, emotion, startTime, endTime, pageIndex, pageRows);
				return bodyResp;
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}

	@RequestMapping(
			value = {"/searchArticlesByWebsite"},
			method = {RequestMethod.GET},
			produces = {"application/json;charset=UTF-8"}
	)
	@ApiOperation(
			value = "根据来源类型查询文章",
			notes = "根据来源类型查询文章"
	)
	@ResponseBody
	@Override
	public CommonResponse<LzSearchBodyResp> searchArticlesBySource(String sourceType, Integer emotion, String startTime, String endTime, int pageIndex, int pageRows) {
		CommonResponse<LzSearchBodyResp> resp = null;
		try {
			resp = super.visit(() -> {
				LzSearchBodyResp bodyResp = searchService.searchArticlesBySource(sourceType, emotion, startTime, endTime, pageIndex, pageRows);
				return bodyResp;
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}
}