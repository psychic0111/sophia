package com.yz.sophia.insight.controller;

import com.yz.sophia.business.api.entity.CommonResponse;
import com.yz.sophia.business.api.entity.Page;
import com.yz.sophia.insight.model.po.LegalInstrument;
import com.yz.sophia.insight.model.po.LegalInstrumentInfo;
import com.yz.sophia.insight.model.response.LegalInstrumentResp;
import com.yz.sophia.insight.provider.LegalInstrumentProvider;
import com.yz.sophia.insight.service.LegalInstrumentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



/**
 * 观星台驾驶舱数据
 */
@Slf4j
@CrossOrigin
@RestController("/legal")
public class LegalInstrumentController extends BaseController implements LegalInstrumentProvider {


    @Autowired
    private LegalInstrumentService legalInstrumentService;

    @Override
    @ResponseBody
    @ApiOperation(value = "获取案件文书分页数据")
    @RequestMapping(value="/query_legalin_strument",method = RequestMethod.POST)
    public CommonResponse<LegalInstrumentResp> queryLegalinStrument(@ApiParam(name="lawCause", value="案由", defaultValue="承包经营权纠纷", required=false) @RequestParam(name = "lawCause", required = false) String lawCause,
                                                                    @ApiParam(name="judgmentType", value="案件类型", defaultValue="民事", required=false) @RequestParam(name = "judgmentType", required = false)String judgmentType,
                                                                    Integer pageIndex, Integer pageSize) {
        log.info("获取案件文书分页数据接口数为，lawCause："+lawCause+";judgmentType:"+judgmentType+";pageIndex:"+pageIndex+";pageSize:"+pageSize);
        CommonResponse<LegalInstrumentResp> respData = null;
        try {
            respData = super.visit(() -> {
                Page<LegalInstrument> pageData = legalInstrumentService.queryLegalinStrument(lawCause,judgmentType,pageIndex,pageSize);
                log.info("获取案件文书分页数据返回参数：pageData:"+ pageData.toString());
                LegalInstrumentResp resp = new LegalInstrumentResp();
                resp.setLegalPageData(pageData);
                return resp;
            });
        } catch (Exception e) {
            log.info("获取案件文书分页数据接口异常：e:"+e.getMessage());
            e.printStackTrace();
        }
        return respData;
    }

    @Override
    @ResponseBody
    @ApiOperation(value = "获取案件文书详情")
    @RequestMapping(value="/query_legal_info",method = RequestMethod.POST)
    public CommonResponse<LegalInstrumentInfo> queryLegalInfo(@ApiParam(name="judgmentCode", value="案件code", defaultValue="11105", required=false)
                                                                  @RequestParam(name = "judgmentCode", required =true)  String judgmentCode) {
        log.info("获取案件文书详情接口数为，judgmentCode："+judgmentCode);
        CommonResponse<LegalInstrumentInfo> respData = null;
        try {
            respData = super.visit(() -> {
                LegalInstrumentInfo legalInstrumentInfo = legalInstrumentService.queryLegalInfo(judgmentCode);
                log.info("获取案件文书详情返回参数：legalInstrumentInfo:"+ legalInstrumentInfo);
                return legalInstrumentInfo;
            });
        } catch (Exception e) {
            log.info("获取案件文书详情接口异常：e:"+e.getMessage());
            e.printStackTrace();
        }
        return respData;
    }


}
