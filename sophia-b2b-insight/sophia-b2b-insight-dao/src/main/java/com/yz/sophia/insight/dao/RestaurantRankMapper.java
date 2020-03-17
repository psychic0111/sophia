package com.yz.sophia.insight.dao;

import com.yz.sophia.insight.model.po.RestaurantRank;
import com.yz.sophia.insight.model.po.RestaurantRankExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRankMapper {
    long countByExample(RestaurantRankExample example);

    int deleteByExample(RestaurantRankExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RestaurantRank record);

    int insertSelective(RestaurantRank record);

    List<RestaurantRank> selectByExample(RestaurantRankExample example);

    RestaurantRank selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RestaurantRank record, @Param("example") RestaurantRankExample example);

    int updateByExample(@Param("record") RestaurantRank record, @Param("example") RestaurantRankExample example);

    int updateByPrimaryKeySelective(RestaurantRank record);

    int updateByPrimaryKey(RestaurantRank record);
}