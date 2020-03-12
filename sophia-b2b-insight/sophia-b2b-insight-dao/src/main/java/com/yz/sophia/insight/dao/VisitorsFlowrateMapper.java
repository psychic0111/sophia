package com.yz.sophia.insight.dao;

import com.yz.sophia.insight.model.po.VisitorsFlowrate;
import com.yz.sophia.insight.model.po.VisitorsFlowrateExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface VisitorsFlowrateMapper {
    long countByExample(VisitorsFlowrateExample example);

    int deleteByExample(VisitorsFlowrateExample example);

    int insert(VisitorsFlowrate record);

    int insertSelective(VisitorsFlowrate record);

    List<VisitorsFlowrate> selectByExample(VisitorsFlowrateExample example);

    int updateByExampleSelective(@Param("record") VisitorsFlowrate record, @Param("example") VisitorsFlowrateExample example);

    int updateByExample(@Param("record") VisitorsFlowrate record, @Param("example") VisitorsFlowrateExample example);
}