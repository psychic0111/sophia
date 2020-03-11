package com.yz.sophia.insight.controller;

import com.yz.sophia.business.api.entity.CommonResponse;
import com.yz.sophia.insight.model.po.RestaurantRank;
import com.yz.sophia.insight.model.po.SysUser;
import com.yz.sophia.insight.provider.RestaurantRankProvider;
import com.yz.sophia.insight.provider.SysUserProvider;
import com.yz.sophia.insight.service.RestaurantRankService;
import com.yz.sophia.insight.service.SysUserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 数据洞察-餐饮
 */
@Slf4j
@CrossOrigin(origins = "*",maxAge = 3600)
@RestController("/catering")
public class RestaurantRankController extends BaseController implements RestaurantRankProvider {


    @Autowired
    private RestaurantRankService restaurantRankService;

    @Override
    @RequestMapping(value="/get",method = RequestMethod.GET)
    @ApiOperation("根据品牌搜索品牌详情")
    public CommonResponse<RestaurantRank> getRestaurantRankByName(@RequestParam String restaurantBrand) {
        return super.visit(() -> {return restaurantRankService.getRestaurantRankByName(restaurantBrand);
        });
    }

}
