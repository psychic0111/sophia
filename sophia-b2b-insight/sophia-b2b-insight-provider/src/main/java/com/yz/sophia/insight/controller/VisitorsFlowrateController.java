package com.yz.sophia.insight.controller;

import com.yz.sophia.business.api.entity.CommonResponse;
import com.yz.sophia.insight.model.po.RestaurantRank;
import com.yz.sophia.insight.model.po.VisitorsFlowrate;
import com.yz.sophia.insight.provider.RestaurantRankProvider;
import com.yz.sophia.insight.provider.VisitorsFlowrateProvider;
import com.yz.sophia.insight.service.RestaurantRankService;
import com.yz.sophia.insight.service.VisitorsFlowrateService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


/**
 * 数据洞察-旅游
 */
@Slf4j
@CrossOrigin(origins = "*",maxAge = 3600)
@RestController("/travel")
public class VisitorsFlowrateController extends BaseController implements VisitorsFlowrateProvider {


    @Autowired
    private VisitorsFlowrateService visitorsFlowrateService;


    @Override
    @RequestMapping(value="/get",method = RequestMethod.GET)
    @ApiOperation("根据开始时间结束时间与地点搜索旅游数据")
    public CommonResponse<List<VisitorsFlowrate>> getVisitorsFlowrateByDateAndSpot(String spot, String startDate, String endDate) {
        return super.visit(() -> {return visitorsFlowrateService.getVisitorsFlowrateByDateAndSpot(startDate,endDate,spot);
        });
    }
}
