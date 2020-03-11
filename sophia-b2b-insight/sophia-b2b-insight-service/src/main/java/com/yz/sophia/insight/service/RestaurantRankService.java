package com.yz.sophia.insight.service;

import com.yz.sophia.insight.dao.RestaurantRankMapper;
import com.yz.sophia.insight.model.po.RestaurantRank;
import com.yz.sophia.insight.model.po.RestaurantRankExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhaojing.jiang
 * @date 2020-03-10
 */
@Service
public class RestaurantRankService {
    @Autowired
    RestaurantRankMapper restaurantRankMapper;

    public RestaurantRank getRestaurantRankByName(String restaurantBrand){

        RestaurantRankExample ex = new RestaurantRankExample();
        ex.createCriteria().andRestaurantBrandEqualTo(restaurantBrand);
        List<RestaurantRank> list=restaurantRankMapper.selectByExample(ex);
        return list.get(0);
    }
}
