package com.yz.sophia.insight.dao;

import com.yz.sophia.insight.model.po.RestaurantRank;
import com.yz.sophia.insight.model.po.RestaurantRankExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RestaurantRankMapper {
    long countByExample(RestaurantRankExample example);

    int deleteByExample(RestaurantRankExample example);

    int insert(RestaurantRank record);

    int insertSelective(RestaurantRank record);

    List<RestaurantRank> selectByExample(RestaurantRankExample example);

    int updateByExampleSelective(@Param("record") RestaurantRank record, @Param("example") RestaurantRankExample example);

    int updateByExample(@Param("record") RestaurantRank record, @Param("example") RestaurantRankExample example);
}