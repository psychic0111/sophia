package com.yz.sophia.insight.provider;
import com.yz.sophia.business.api.entity.CommonResponse;
import com.yz.sophia.insight.model.response.LawResultResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.yz.sophia.insight.model.request.CustomerAddReq;
import com.yz.sophia.insight.model.response.CustomerDetailsResp;

import javax.servlet.http.HttpServletRequest;


/**
 * FeignClient命名规则说明:
 * name 为提供服务的${spring.application.name}名称,不能写错,否则使用api的客户端在注册中心无法找到对应的服务。
 * 		比如sophia-b2b-insight-provider 为sophia-b2b-insight项目provider模块提供的服务
 * path 为api的相对路径,格式:${server.servlet.context-path|/相对路径
 * 		比如/api/customer
 */
@Api("法律查询服务")
@FeignClient(name = "sophia-b2b-insight-provider",path = "/api/law")
@RequestMapping("/lawQuery")
public interface LawQueryProvider {

    // 服务中方法的映射路径,确保参数一致
    @GetMapping("/lawyerCaseDistribute")
    @ApiOperation("律师案由分布")
    CommonResponse<LawResultResp> lawyerCaseDistribute(HttpServletRequest request);

    @GetMapping("/lawyerCaseTypeDistribute")
    @ApiOperation("律师案件类型分布")
    CommonResponse<LawResultResp> lawyerCaseTypeDistribute(HttpServletRequest request);

    @GetMapping("/lawCourtLevelDistribute")
    @ApiOperation("律师法院层级分布")
    CommonResponse<LawResultResp> lawCourtLevelDistribute(HttpServletRequest request);

    @GetMapping("/lawCaseTimeDistribute")
    @ApiOperation("律师案件时间分布")
    CommonResponse<LawResultResp> lawCaseTimeDistribute(HttpServletRequest request);

    @GetMapping("/lawCaseAreaDistribute")
    @ApiOperation("律师案件地区分布")
    CommonResponse<LawResultResp> lawCaseAreaDistribute(HttpServletRequest request);

    @GetMapping("/lawLitigationStepDistribute")
    @ApiOperation("律师诉讼阶段分布")
    CommonResponse<LawResultResp> lawLitigationStepDistribute(HttpServletRequest request);

    @GetMapping("/lawCustomerTypeDistribute")
    @ApiOperation("律师客户类型分布")
    CommonResponse<LawResultResp> lawCustomerTypeDistribute(HttpServletRequest request);

    @GetMapping("/lawSentenceRate")
    @ApiOperation("律师判决胜诉率")
    CommonResponse<LawResultResp> lawSentenceRate(HttpServletRequest request);

    @GetMapping("/lawSentenceMoney")
    @ApiOperation("律师判决标的额分布")
    CommonResponse<LawResultResp> lawSentenceMoney(HttpServletRequest request);

    @GetMapping("/clientCaseDistribute")
    @ApiOperation("当事人案由分布")
    CommonResponse<LawResultResp> clientCaseDistribute(HttpServletRequest request);

    @GetMapping("/clientCaseTypeDistribute")
    @ApiOperation("当事人案件类型分布")
    CommonResponse<LawResultResp> clientCaseTypeDistribute(HttpServletRequest request);

    @GetMapping("/clientCourtLevelDistribute")
    @ApiOperation("当事人法院层级分布")
    CommonResponse<LawResultResp> clientCourtLevelDistribute(HttpServletRequest request);

    @GetMapping("/clientCaseTimeDistribute")
    @ApiOperation("当事人案件时间分布")
    CommonResponse<LawResultResp> clientCaseTimeDistribute(HttpServletRequest request);

    @GetMapping("/clientCaseAreaDistribute")
    @ApiOperation("当事人案件地区分布")
    CommonResponse<LawResultResp> clientCaseAreaDistribute(HttpServletRequest request);

    @GetMapping("/clientSentenceMoney")
    @ApiOperation("当事人判决标的额分布")
    CommonResponse<LawResultResp> clientSentenceMoney(HttpServletRequest request);

    @GetMapping("/clientSentenceRate")
    @ApiOperation("当事人判决胜诉率")
    CommonResponse<LawResultResp> clientSentenceRate(HttpServletRequest request);

}

