package com.yz.sophia.insight.dao;

import com.yz.sophia.insight.model.po.TravelInsight;
import com.yz.sophia.insight.model.po.TravelInsightExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TravelInsightMapper {
    int countByExample(TravelInsightExample example);

    int deleteByExample(TravelInsightExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TravelInsight record);

    int insertSelective(TravelInsight record);

    List<TravelInsight> selectByExample(TravelInsightExample example);

    TravelInsight selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TravelInsight record, @Param("example") TravelInsightExample example);

    int updateByExample(@Param("record") TravelInsight record, @Param("example") TravelInsightExample example);

    int updateByPrimaryKeySelective(TravelInsight record);

    int updateByPrimaryKey(TravelInsight record);
}