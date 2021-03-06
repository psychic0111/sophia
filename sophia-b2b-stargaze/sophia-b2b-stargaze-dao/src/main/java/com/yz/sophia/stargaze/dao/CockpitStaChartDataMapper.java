package com.yz.sophia.stargaze.dao;

import com.yz.sophia.stargaze.model.po.CockpitStaChartData;
import com.yz.sophia.stargaze.model.po.CockpitStaChartDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CockpitStaChartDataMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cockpit_sta_chart_data
     *
     * @mbggenerated
     */
    int countByExample(CockpitStaChartDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cockpit_sta_chart_data
     *
     * @mbggenerated
     */
    int deleteByExample(CockpitStaChartDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cockpit_sta_chart_data
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cockpit_sta_chart_data
     *
     * @mbggenerated
     */
    int insert(CockpitStaChartData record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cockpit_sta_chart_data
     *
     * @mbggenerated
     */
    int insertSelective(CockpitStaChartData record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cockpit_sta_chart_data
     *
     * @mbggenerated
     */
    List<CockpitStaChartData> selectByExample(CockpitStaChartDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cockpit_sta_chart_data
     *
     * @mbggenerated
     */
    CockpitStaChartData selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cockpit_sta_chart_data
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") CockpitStaChartData record, @Param("example") CockpitStaChartDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cockpit_sta_chart_data
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") CockpitStaChartData record, @Param("example") CockpitStaChartDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cockpit_sta_chart_data
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CockpitStaChartData record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cockpit_sta_chart_data
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CockpitStaChartData record);
}