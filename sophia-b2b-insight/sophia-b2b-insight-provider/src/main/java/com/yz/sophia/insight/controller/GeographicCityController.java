package com.yz.sophia.insight.controller;

import com.yz.sophia.business.api.entity.CommonResponse;
import com.yz.sophia.business.api.entity.Page;
import com.yz.sophia.insight.model.po.LegalInstrument;
import com.yz.sophia.insight.model.po.LegalInstrumentInfo;
import com.yz.sophia.insight.model.response.GeographicCityResp;
import com.yz.sophia.insight.model.response.LegalInstrumentResp;
import com.yz.sophia.insight.provider.GeographicCityProvider;
import com.yz.sophia.insight.provider.LegalInstrumentProvider;
import com.yz.sophia.insight.service.GeographicCityService;
import com.yz.sophia.insight.service.LegalInstrumentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 观星台驾驶舱数据
 */
@Slf4j
@CrossOrigin
@RestController("/geographic")
public class GeographicCityController extends BaseController implements GeographicCityProvider {


    @Autowired
    private GeographicCityService geographicCityService;

    @Override
    @ResponseBody
    @ApiOperation(value = "获取地理统计数据")
    @RequestMapping(value="/query_geographic_data",method = RequestMethod.POST)
    public CommonResponse<List<GeographicCityResp>> queryGeographicData(@ApiParam(name="cityId", value="城市id", defaultValue="10002", required=false)
                                                                            @RequestParam(name = "cityId", required =false) String cityId,
                                                                        @ApiParam(name="cityProvince", value="省份名称", defaultValue="河北省", required=false)
                                                                            @RequestParam(name = "cityProvince", required =false) String cityProvince) {
        log.info("获取地理统计数据,start");
        CommonResponse<List<GeographicCityResp>> respData = null;
        try {
            respData = super.visit(() -> {
                List<GeographicCityResp> bodyResp = geographicCityService.queryGeographicData(cityId,cityProvince);
                log.info("获取地理统计数据返回参数：bodyResp:"+ bodyResp);
                return bodyResp;
            });
        } catch (Exception e) {
            log.info("获取地理统计数据接口异常：e:"+e.getMessage());
            e.printStackTrace();
        }
        return respData;
    }


}
