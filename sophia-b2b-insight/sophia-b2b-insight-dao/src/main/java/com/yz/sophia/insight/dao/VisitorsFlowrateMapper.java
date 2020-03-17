package com.yz.sophia.insight.dao;

import com.yz.sophia.insight.model.po.VisitorsFlowrate;
import com.yz.sophia.insight.model.po.VisitorsFlowrateExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitorsFlowrateMapper {
    long countByExample(VisitorsFlowrateExample example);

    int deleteByExample(VisitorsFlowrateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(VisitorsFlowrate record);

    int insertSelective(VisitorsFlowrate record);

    List<VisitorsFlowrate> selectByExample(VisitorsFlowrateExample example);

    VisitorsFlowrate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") VisitorsFlowrate record, @Param("example") VisitorsFlowrateExample example);

    int updateByExample(@Param("record") VisitorsFlowrate record, @Param("example") VisitorsFlowrateExample example);

    int updateByPrimaryKeySelective(VisitorsFlowrate record);

    int updateByPrimaryKey(VisitorsFlowrate record);
}