package com.yz.sophia.insight.dao;

import com.yz.sophia.insight.model.po.RegionInsight;
import com.yz.sophia.insight.model.po.RegionInsightExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionInsightMapper {
    long countByExample(RegionInsightExample example);

    int deleteByExample(RegionInsightExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RegionInsight record);

    int insertSelective(RegionInsight record);

    List<RegionInsight> selectByExample(RegionInsightExample example);

    RegionInsight selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RegionInsight record, @Param("example") RegionInsightExample example);

    int updateByExample(@Param("record") RegionInsight record, @Param("example") RegionInsightExample example);

    int updateByPrimaryKeySelective(RegionInsight record);

    int updateByPrimaryKey(RegionInsight record);
}