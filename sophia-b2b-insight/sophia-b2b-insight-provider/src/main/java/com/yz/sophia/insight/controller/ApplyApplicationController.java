package com.yz.sophia.insight.controller;

import com.yz.sophia.business.api.entity.CommonResponse;
import com.yz.sophia.business.api.entity.Page;
import com.yz.sophia.insight.model.po.ApplyApplication;
import com.yz.sophia.insight.model.po.MultilevelMenu;
import com.yz.sophia.insight.model.request.ApplyApplicationReq;
import com.yz.sophia.insight.model.response.ApplyApplicationRelResp;
import com.yz.sophia.insight.model.response.ApplyApplicationResp;
import com.yz.sophia.insight.provider.ApplyApplicationProvider;
import com.yz.sophia.insight.service.ApplyApplicationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 应用申请接口
 */
@Slf4j
@CrossOrigin
@RestController("/application")
public class ApplyApplicationController extends BaseController implements ApplyApplicationProvider {


    @Autowired
    private ApplyApplicationService applyApplicationService;


    @Override
    @ResponseBody
    @ApiOperation(value = "录入接口")
    @RequestMapping(value="/application_service",method = RequestMethod.POST)
    public CommonResponse applicationService(@RequestBody
                                                          @Validated
                                                          @ApiParam(
                                                                  name="录入接口请求对象",
                                                                  value="{\n" +
                                                                          "\t\"userId\": \"989f0e8bff7b000\",\n" +
                                                                          "\t\"applicationName\": \"测试应用\",\n" +
                                                                          "\t\"applicationDescribe\": \"描述信息描述信息描述信息\",\n" +
                                                                          "\t\"applicationService\": \"1|2|3|5\",\n" +
                                                                          "\t\"applicationType\": \"工具应用2\",\n" +
                                                                          "\t\"menusCodeList\": [\"10021\",\"10022\",\"10023\"]\n" +
                                                                          "}",
                                                                  required=true)
                                                                  ApplyApplicationReq applyApplicationQo) {

        CommonResponse respData = null;
        try {
            respData = super.visit(() -> {
                Integer num = applyApplicationService.insertApplication(applyApplicationQo);
                log.info("录入接口返回参数：num:"+num);
                return num;
            });
        } catch (Exception e) {
            log.info("录入接口异常：e:"+e.getMessage());
            e.printStackTrace();
        }
        return respData;
    }


    @Override
    @ResponseBody
    @ApiOperation(value = "列表分页接口")
    @RequestMapping(value="/query_application_page",method = RequestMethod.POST)
    public CommonResponse<ApplyApplicationResp> queryApplicationPage(@ApiParam(name="userId", value="用户ID", defaultValue="989f0e8bff7b000", required=true) String userId,
                                                                                 Integer pageIndex, Integer pageSize) {

        log.info("列表分页接口数据为，userId："+userId+";pageIndex:"+pageIndex+";pageSize:"+pageSize);
        CommonResponse<ApplyApplicationResp> respData = null;
        try {
            respData = super.visit(() -> {
                Page<ApplyApplication> pageData = applyApplicationService.queryApplicationPage(userId,pageIndex,pageSize);
                log.info("列表分页接口返回参数：pageData:"+ pageData.toString());
                ApplyApplicationResp resp = new ApplyApplicationResp();
                resp.setApplicationPageData(pageData);
                return resp;
            });
        } catch (Exception e) {
            log.info("列表分页接口异常：e:"+e.getMessage());
            e.printStackTrace();
        }
        return respData;
    }

    @Override
    @ResponseBody
    @ApiOperation(value = "回显查询接口")
    @RequestMapping(value="/query_application_info",method = RequestMethod.POST)
    public CommonResponse<ApplyApplicationRelResp> queryApplicationInfo(@ApiParam(name="applicationCode", value="应用code", defaultValue="", required=true) String applicationCode) {
        log.info("回显查询接口数据为，applicationCode："+applicationCode);
        CommonResponse<ApplyApplicationRelResp> respData = null;
        try {
            respData = super.visit(() -> {
                ApplyApplicationRelResp applyApplicationRelResp = applyApplicationService.queryApplicationInfo(applicationCode);
                log.info("回显查询接口返回参数：ApplyApplicationRelResp:"+ applyApplicationRelResp);
                return applyApplicationRelResp;
            });
        } catch (Exception e) {
            log.info("回显查询接口异常：e:"+e.getMessage());
            e.printStackTrace();
        }
        return respData;
    }

    @Override
    @ResponseBody
    @ApiOperation(value = "菜单选择查询接口")
    @RequestMapping(value="/get_multilevel_menu",method = RequestMethod.POST)
    public CommonResponse<List<MultilevelMenu>> getMultilevelMenu(@ApiParam(name="menusRank", value="菜单级别(1=一级，2=二级，3=三级)", defaultValue="1", required=false)
                                                                      @RequestParam(name = "menusRank", required =false)Integer menusRank,
                                                                  @ApiParam(name="parentMenusCode", value="父菜单code", defaultValue="1", required=false)
                                                                  @RequestParam(name = "parentMenusCode", required =false)String parentMenusCode) {

        log.info("菜单选择查询接口数据请求参数menusRank:"+menusRank+";parentMenusCode"+parentMenusCode);
        CommonResponse<List<MultilevelMenu>> respData = null;
        try {
            respData = super.visit(() -> {
                List<MultilevelMenu> mulMenuList = applyApplicationService.getMultilevelMenu(menusRank,parentMenusCode);
                log.info("菜单选择查询接口返回参数：mulMenuList:"+ mulMenuList);
                return mulMenuList;
            });
        } catch (Exception e) {
            log.info("菜单选择查询接口异常：e:"+e.getMessage());
            e.printStackTrace();
        }
        return respData;
    }

    @Override
    @ResponseBody
    @ApiOperation(value = "编辑接口")
    @RequestMapping(value="/edit_application",method = RequestMethod.POST)
    public CommonResponse editApplication(@RequestBody
                                              @Validated
                                              @ApiParam(
                                                      name="编辑接口请求对象",
                                                      value="{\n" +
                                                              "\"applicationCode\":\"314729405\",\n" +
                                                              "\"applicationDescribe\": \"更改描述信息描述信息描述信息更改\",\n" +
                                                              "\"applicationService\": \"2|3|5\",\n" +
                                                              "\"menusCodeList\": [\"10022\",\"10023\",\"10024\"]\n" +
                                                              "}",
                                                      required=true)
                                                      ApplyApplicationReq applyApplicationQo) {

        CommonResponse respData = null;
        try {
            respData = super.visit(() -> {
                Integer num = applyApplicationService.editApplication(applyApplicationQo);
                log.info("编辑接口返回参数：num:"+num);
                return num;
            });
        } catch (Exception e) {
            log.info("编辑接口异常：e:"+e.getMessage());
            e.printStackTrace();
        }
        return respData;
    }


    @Override
    @ResponseBody
    @ApiOperation(value = "删除接口")
    @RequestMapping(value="/status_application",method = RequestMethod.POST)
    public CommonResponse statusApplication(@ApiParam(name="applicationCode", value="应用code", defaultValue="314729405", required=true) String applicationCode) {
        log.info("删除接口数据为，applicationCode："+applicationCode);
        CommonResponse respData = null;
        try {
            respData = super.visit(() -> {
                Integer auditNum = applyApplicationService.delApplication(applicationCode);
                log.info("删除接口返回参数：auditNum:"+ auditNum);
                return auditNum;
            });
        } catch (Exception e) {
            log.info("删除接口异常：e:"+e.getMessage());
            e.printStackTrace();
        }
        return respData;
    }

//    @Override
//    @ResponseBody
//    @ApiOperation(value = "审核接口")
//    @RequestMapping(value="/audit_application",method = RequestMethod.POST)
//    public CommonResponse auditApplication(@ApiParam(name="auditOperate", value="审核操作（1=审核通过，2=审核不通过）", defaultValue="", required=true) Integer auditOperate,
//                                           @ApiParam(name="applicationCode", value="应用code", defaultValue="", required=true) String applicationCode) {
//        log.info("审核接口数据为，auditOperate："+auditOperate);
//        CommonResponse respData = null;
//        try {
//            respData = super.visit(() -> {
//                Integer auditNum = applyApplicationService.auditApplication(auditOperate,applicationCode);
//                log.info("审核接口返回参数：auditNum:"+ auditNum);
//                return auditNum;
//            });
//        } catch (Exception e) {
//            log.info("审核接口异常：e:"+e.getMessage());
//            e.printStackTrace();
//        }
//        return respData;
//    }


}
