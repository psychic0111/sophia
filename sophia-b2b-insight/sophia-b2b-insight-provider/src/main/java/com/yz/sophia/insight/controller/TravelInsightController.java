package com.yz.sophia.insight.controller;

import com.yz.sophia.business.api.entity.CommonResponse;
import com.yz.sophia.insight.model.po.TravelInsight;
import com.yz.sophia.insight.provider.TravelInsightProvider;
import com.yz.sophia.insight.service.TravelInsightService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * create by liuji on 2020/3/16
 * 数据洞察 旅游实时获取火车数据
 **/
@Slf4j
@CrossOrigin(origins = "*",maxAge = 3600)
@RestController("/travelInsight")
public class TravelInsightController extends BaseController implements TravelInsightProvider {
    @Autowired
    private TravelInsightService travelInsightService;

    @Override
    public CommonResponse<TravelInsight> getTravelInsight() {
        return super.visit(() -> {
            return travelInsightService.getTravelInsight();
        });
    }
}
