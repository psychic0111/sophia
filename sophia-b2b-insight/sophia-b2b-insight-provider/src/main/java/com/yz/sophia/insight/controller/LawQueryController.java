package com.yz.sophia.insight.controller;

import com.yz.sophia.business.api.entity.CommonResponse;
import com.yz.sophia.insight.model.response.LawResultResp;
import com.yz.sophia.insight.model.response.LzSearchBodyResp;
import com.yz.sophia.insight.provider.LawQueryProvider;
import com.yz.sophia.insight.provider.LzSearchProvider;
import com.yz.sophia.insight.service.LawQueryService;
import com.yz.sophia.insight.service.LzSearchService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 法律接口
 */
@Slf4j
@RestController
public class LawQueryController extends BaseController implements LawQueryProvider {

	@Autowired
	private LawQueryService lawQueryService;

	@Override
	@ResponseBody
	@ApiOperation(value = "律师案由分布")
	@RequestMapping(value="/lawyer_case_distribute",method = RequestMethod.GET)
	public CommonResponse<LawResultResp> lawyerCaseDistribute(HttpServletRequest request) {
		CommonResponse<LawResultResp> lawResp = null;
		try {
			lawResp = super.visit(() -> {
				LawResultResp bodyResp = lawQueryService.lawyerCaseDistribute();
				return bodyResp;
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lawResp;
	}

	@Override
	@ResponseBody
	@ApiOperation(value = "律师案件类型分布")
	@RequestMapping(value="/lawyer_caseType_distribute",method = RequestMethod.GET)
	public CommonResponse<LawResultResp> lawyerCaseTypeDistribute(HttpServletRequest request) {
		CommonResponse<LawResultResp> lawResp = null;
		try {
			lawResp = super.visit(() -> {
				LawResultResp bodyResp = lawQueryService.lawyerCaseTypeDistribute();
				return bodyResp;
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lawResp;
	}

	@Override
	@ResponseBody
	@ApiOperation(value = "律师法院层级分布")
	@RequestMapping(value="/law_courtLevel_distribute",method = RequestMethod.GET)
	public CommonResponse<LawResultResp> lawCourtLevelDistribute(HttpServletRequest request) {
		CommonResponse<LawResultResp> lawResp = null;
		try {
			lawResp = super.visit(() -> {
				LawResultResp bodyResp = lawQueryService.lawCourtLevelDistribute();
				return bodyResp;
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lawResp;
	}

	@Override
	@ResponseBody
	@ApiOperation(value = "律师案件时间分布")
	@RequestMapping(value="/law_caseTime_distribute",method = RequestMethod.GET)
	public CommonResponse<LawResultResp> lawCaseTimeDistribute(HttpServletRequest request) {
		CommonResponse<LawResultResp> lawResp = null;
		try {
			lawResp = super.visit(() -> {
				LawResultResp bodyResp = lawQueryService.lawCaseTimeDistribute();
				return bodyResp;
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lawResp;
	}

	@Override
	@ResponseBody
	@ApiOperation(value = "律师案件地区分布")
	@RequestMapping(value="/law_caseArea_distribute",method = RequestMethod.GET)
	public CommonResponse<LawResultResp> lawCaseAreaDistribute(HttpServletRequest request) {
		CommonResponse<LawResultResp> lawResp = null;
		try {
			lawResp = super.visit(() -> {
				LawResultResp bodyResp = lawQueryService.lawCaseAreaDistribute();
				return bodyResp;
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lawResp;
	}

	@Override
	@ResponseBody
	@ApiOperation(value = "律师诉讼阶段分布")
	@RequestMapping(value="/law_litigationStep_distribute",method = RequestMethod.GET)
	public CommonResponse<LawResultResp> lawLitigationStepDistribute(HttpServletRequest request) {
		CommonResponse<LawResultResp> lawResp = null;
		try {
			lawResp = super.visit(() -> {
				LawResultResp bodyResp = lawQueryService.lawLitigationStepDistribute();
				return bodyResp;
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lawResp;
	}

	@Override
	@ResponseBody
	@ApiOperation(value = "律师客户类型分布")
	@RequestMapping(value="/law_customerType_distribute",method = RequestMethod.GET)
	public CommonResponse<LawResultResp> lawCustomerTypeDistribute(HttpServletRequest request) {
		CommonResponse<LawResultResp> lawResp = null;
		try {
			lawResp = super.visit(() -> {
				LawResultResp bodyResp = lawQueryService.lawCustomerTypeDistribute();
				return bodyResp;
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lawResp;
	}

	@Override
	@ResponseBody
	@ApiOperation(value = "律师判决胜诉率")
	@RequestMapping(value="/law_sentence_rate",method = RequestMethod.GET)
	public CommonResponse<LawResultResp> lawSentenceRate(HttpServletRequest request) {
		CommonResponse<LawResultResp> lawResp = null;
		try {
			lawResp = super.visit(() -> {
				LawResultResp bodyResp = lawQueryService.lawSentenceRate();
				return bodyResp;
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lawResp;
	}

	@Override
	@ResponseBody
	@ApiOperation(value = "律师判决标的额分布")
	@RequestMapping(value="/law_sentence_money",method = RequestMethod.GET)
	public CommonResponse<LawResultResp> lawSentenceMoney(HttpServletRequest request) {
		CommonResponse<LawResultResp> lawResp = null;
		try {
			lawResp = super.visit(() -> {
				LawResultResp bodyResp = lawQueryService.lawSentenceMoney();
				return bodyResp;
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lawResp;
	}

	@Override
	@ResponseBody
	@ApiOperation(value = "当事人案由分布")
	@RequestMapping(value="/client_case_distribute",method = RequestMethod.GET)
	public CommonResponse<LawResultResp> clientCaseDistribute(HttpServletRequest request) {
		CommonResponse<LawResultResp> lawResp = null;
		try {
			lawResp = super.visit(() -> {
				LawResultResp bodyResp = lawQueryService.clientCaseDistribute();
				return bodyResp;
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lawResp;
	}

	@Override
	@ResponseBody
	@ApiOperation(value = "当事人案件类型分布")
	@RequestMapping(value="/client_caseType_distribute",method = RequestMethod.GET)
	public CommonResponse<LawResultResp> clientCaseTypeDistribute(HttpServletRequest request) {
		CommonResponse<LawResultResp> lawResp = null;
		try {
			lawResp = super.visit(() -> {
				LawResultResp bodyResp = lawQueryService.clientCaseTypeDistribute();
				return bodyResp;
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lawResp;
	}

	@Override
	@ResponseBody
	@ApiOperation(value = "当事人法院层级分布")
	@RequestMapping(value="/client_courtLevel_distribute",method = RequestMethod.GET)
	public CommonResponse<LawResultResp> clientCourtLevelDistribute(HttpServletRequest request) {
		CommonResponse<LawResultResp> lawResp = null;
		try {
			lawResp = super.visit(() -> {
				LawResultResp bodyResp = lawQueryService.clientCourtLevelDistribute();
				return bodyResp;
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lawResp;
	}

	@Override
	@ResponseBody
	@ApiOperation(value = "当事人案件时间分布")
	@RequestMapping(value="/client_caseTime_distribute",method = RequestMethod.GET)
	public CommonResponse<LawResultResp> clientCaseTimeDistribute(HttpServletRequest request) {
		CommonResponse<LawResultResp> lawResp = null;
		try {
			lawResp = super.visit(() -> {
				LawResultResp bodyResp = lawQueryService.clientCaseTimeDistribute();
				return bodyResp;
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lawResp;
	}

	@Override
	@ResponseBody
	@ApiOperation(value = "当事人案件地区分布")
	@RequestMapping(value="/client_caseArea_distribute",method = RequestMethod.GET)
	public CommonResponse<LawResultResp> clientCaseAreaDistribute(HttpServletRequest request) {
		CommonResponse<LawResultResp> lawResp = null;
		try {
			lawResp = super.visit(() -> {
				LawResultResp bodyResp = lawQueryService.clientCaseAreaDistribute();
				return bodyResp;
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lawResp;
	}

	@Override
	@ResponseBody
	@ApiOperation(value = "当事人判决标的额分布")
	@RequestMapping(value="/client_sentence_money",method = RequestMethod.GET)
	public CommonResponse<LawResultResp> clientSentenceMoney(HttpServletRequest request) {
		CommonResponse<LawResultResp> lawResp = null;
		try {
			lawResp = super.visit(() -> {
				LawResultResp bodyResp = lawQueryService.clientSentenceMoney();
				return bodyResp;
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lawResp;
	}

	@Override
	@ResponseBody
	@ApiOperation(value = "当事人判决胜诉率")
	@RequestMapping(value="/client_sentence_rate",method = RequestMethod.GET)
	public CommonResponse<LawResultResp> clientSentenceRate(HttpServletRequest request) {
		CommonResponse<LawResultResp> lawResp = null;
		try {
			lawResp = super.visit(() -> {
				LawResultResp bodyResp = lawQueryService.clientSentenceRate();
				return bodyResp;
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lawResp;
	}
}