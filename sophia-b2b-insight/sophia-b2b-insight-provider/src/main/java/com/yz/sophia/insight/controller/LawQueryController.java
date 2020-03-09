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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 法律接口
 */
@Slf4j
@CrossOrigin
@RestController
public class LawQueryController extends BaseController implements LawQueryProvider {

	@Autowired
	private LawQueryService lawQueryService;

	@Override
	@ResponseBody
	@ApiOperation(value = "律师查询")
	@RequestMapping(value="/lawyer_search",method = RequestMethod.GET)
	public CommonResponse<LawResultResp> lawyerSearch(@ApiParam(name="keyword", value="律师姓名", defaultValue="燕霞")String keyword, int pageNo, int pageSize) {
		CommonResponse<LawResultResp> lawResp = null;
		try {
			lawResp = super.visit(() -> {
				LawResultResp bodyResp = lawQueryService.lawyerSearch(keyword,pageNo,pageSize);
				return bodyResp;
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lawResp;
	}

	@Override
	@ResponseBody
	@ApiOperation(value = "当事人查询")
	@RequestMapping(value="/client_search",method = RequestMethod.GET)
	public CommonResponse<LawResultResp> clientSearch(@ApiParam(name="fullName", value="当事人姓名", defaultValue="小明")String fullName) {
		CommonResponse<LawResultResp> lawResp = null;
		try {
			lawResp = super.visit(() -> {
				LawResultResp bodyResp = lawQueryService.clientSearch(fullName);
				return bodyResp;
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lawResp;
	}

	@Override
	@ResponseBody
	@ApiOperation(value = "律师案由分布")
	@RequestMapping(value="/lawyer_case_distribute",method = RequestMethod.GET)
	public CommonResponse<LawResultResp> lawyerCaseDistribute(@ApiParam(name="paramCode", value="律师code", defaultValue="74525") String paramCode) {
		CommonResponse<LawResultResp> lawResp = null;
		try {
			lawResp = super.visit(() -> {
				LawResultResp bodyResp = lawQueryService.lawyerCaseDistribute(paramCode);
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
	public CommonResponse<LawResultResp> lawyerCaseTypeDistribute(@ApiParam(name="paramCode", value="律师code", defaultValue="74525") String paramCode) {
		CommonResponse<LawResultResp> lawResp = null;
		try {
			lawResp = super.visit(() -> {
				LawResultResp bodyResp = lawQueryService.lawyerCaseTypeDistribute(paramCode);
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
	public CommonResponse<LawResultResp> lawCourtLevelDistribute(@ApiParam(name="paramCode", value="律师code", defaultValue="74525") String paramCode) {
		CommonResponse<LawResultResp> lawResp = null;
		try {
			lawResp = super.visit(() -> {
				LawResultResp bodyResp = lawQueryService.lawCourtLevelDistribute(paramCode);
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
	public CommonResponse<LawResultResp> lawCaseTimeDistribute(@ApiParam(name="paramCode", value="律师code", defaultValue="74525") String paramCode) {
		CommonResponse<LawResultResp> lawResp = null;
		try {
			lawResp = super.visit(() -> {
				LawResultResp bodyResp = lawQueryService.lawCaseTimeDistribute(paramCode);
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
	public CommonResponse<LawResultResp> lawCaseAreaDistribute(@ApiParam(name="paramCode", value="律师code", defaultValue="74525") String paramCode) {
		CommonResponse<LawResultResp> lawResp = null;
		try {
			lawResp = super.visit(() -> {
				LawResultResp bodyResp = lawQueryService.lawCaseAreaDistribute(paramCode);
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
	public CommonResponse<LawResultResp> lawLitigationStepDistribute(@ApiParam(name="paramCode", value="律师code", defaultValue="74525") String paramCode) {
		CommonResponse<LawResultResp> lawResp = null;
		try {
			lawResp = super.visit(() -> {
				LawResultResp bodyResp = lawQueryService.lawLitigationStepDistribute(paramCode);
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
	public CommonResponse<LawResultResp> lawCustomerTypeDistribute(@ApiParam(name="paramCode", value="律师code", defaultValue="74525") String paramCode) {
		CommonResponse<LawResultResp> lawResp = null;
		try {
			lawResp = super.visit(() -> {
				LawResultResp bodyResp = lawQueryService.lawCustomerTypeDistribute(paramCode);
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
	public CommonResponse<LawResultResp> lawSentenceRate(@ApiParam(name="paramCode", value="律师code", defaultValue="74525") String paramCode) {
		CommonResponse<LawResultResp> lawResp = null;
		try {
			lawResp = super.visit(() -> {
				LawResultResp bodyResp = lawQueryService.lawSentenceRate(paramCode);
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
	public CommonResponse<LawResultResp> lawSentenceMoney(@ApiParam(name="paramCode", value="律师code", defaultValue="74525") String paramCode) {
		CommonResponse<LawResultResp> lawResp = null;
		try {
			lawResp = super.visit(() -> {
				LawResultResp bodyResp = lawQueryService.lawSentenceMoney(paramCode);
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
	public CommonResponse<LawResultResp> clientCaseDistribute(@ApiParam(name="paramCode", value="当事人code", defaultValue="51167") String paramCode) {
		CommonResponse<LawResultResp> lawResp = null;
		try {
			lawResp = super.visit(() -> {
				LawResultResp bodyResp = lawQueryService.clientCaseDistribute(paramCode);
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
	public CommonResponse<LawResultResp> clientCaseTypeDistribute(@ApiParam(name="paramCode", value="当事人code", defaultValue="51167") String paramCode) {
		CommonResponse<LawResultResp> lawResp = null;
		try {
			lawResp = super.visit(() -> {
				LawResultResp bodyResp = lawQueryService.clientCaseTypeDistribute(paramCode);
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
	public CommonResponse<LawResultResp> clientCourtLevelDistribute(@ApiParam(name="paramCode", value="当事人code", defaultValue="51167") String paramCode) {
		CommonResponse<LawResultResp> lawResp = null;
		try {
			lawResp = super.visit(() -> {
				LawResultResp bodyResp = lawQueryService.clientCourtLevelDistribute(paramCode);
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
	public CommonResponse<LawResultResp> clientCaseTimeDistribute(@ApiParam(name="paramCode", value="当事人code", defaultValue="51167") String paramCode) {
		CommonResponse<LawResultResp> lawResp = null;
		try {
			lawResp = super.visit(() -> {
				LawResultResp bodyResp = lawQueryService.clientCaseTimeDistribute(paramCode);
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
	public CommonResponse<LawResultResp> clientCaseAreaDistribute(@ApiParam(name="paramCode", value="当事人code", defaultValue="51167") String paramCode) {
		CommonResponse<LawResultResp> lawResp = null;
		try {
			lawResp = super.visit(() -> {
				LawResultResp bodyResp = lawQueryService.clientCaseAreaDistribute(paramCode);
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
	public CommonResponse<LawResultResp> clientSentenceMoney(@ApiParam(name="paramCode", value="当事人code", defaultValue="51167") String paramCode) {
		CommonResponse<LawResultResp> lawResp = null;
		try {
			lawResp = super.visit(() -> {
				LawResultResp bodyResp = lawQueryService.clientSentenceMoney(paramCode);
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
	public CommonResponse<LawResultResp> clientSentenceRate(@ApiParam(name="paramCode", value="当事人code", defaultValue="51167") String paramCode) {
		CommonResponse<LawResultResp> lawResp = null;
		try {
			lawResp = super.visit(() -> {
				LawResultResp bodyResp = lawQueryService.clientSentenceRate(paramCode);
				return bodyResp;
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lawResp;
	}
}