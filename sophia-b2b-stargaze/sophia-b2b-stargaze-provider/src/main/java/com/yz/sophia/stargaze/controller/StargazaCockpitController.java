package com.yz.sophia.stargaze.controller;

import com.yz.sophia.business.api.entity.CommonResponse;
import com.yz.sophia.stargaze.model.po.CockpitNavigationMenu;
import com.yz.sophia.stargaze.model.request.StargazeQueryReq;
import com.yz.sophia.stargaze.model.response.StargazeCockpitResp;
import com.yz.sophia.stargaze.provider.StargazaCockpitProvider;
import com.yz.sophia.stargaze.service.CustomerService;
import com.yz.sophia.stargaze.service.StargazaCockpitService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 观星台驾驶舱数据
 */
@Slf4j
@CrossOrigin(origins = "*",maxAge = 3600)
@RestController("/stargazaCockpit")
public class StargazaCockpitController extends BaseController implements StargazaCockpitProvider {


    @Autowired
    private StargazaCockpitService stargazaCockpitService;

    @Override
    @ResponseBody
    @ApiOperation(value = "查询驾驶舱统计数据")
    @RequestMapping(value="/getCockpitData",method = RequestMethod.POST)
    public CommonResponse<StargazeCockpitResp> getCockpitData(@RequestBody
                                                              @Validated
                                                              @ApiParam(
                                                                      name="观星台图表数据请求对象",
                                                                      value="{\"chartLocation\": 3,\"chartType\": 1,\"parentTitle\": 4,\"statisticsYear\": \"\",\"subTitleCode\": \"465342\"}",
                                                                      required=true)
                                                              StargazeQueryReq stargazeQueryReq) {
        CommonResponse<StargazeCockpitResp> respData = null;
        try {
            respData = super.visit(() -> {
                StargazeCockpitResp menuList = stargazaCockpitService.getCockpitData(stargazeQueryReq);
                log.info("查询驾驶舱统计数据接口返回参数：menuList:"+menuList.toString());
                return menuList;
            });
        } catch (Exception e) {
            log.info("查询驾驶舱统计数据接口异常：e:"+e.getMessage());
            e.printStackTrace();
        }
        return respData;
    }

}
