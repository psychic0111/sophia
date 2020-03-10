package com.yz.sophia.insight.dao;

import com.yz.sophia.insight.model.po.ProductInsight;
import com.yz.sophia.insight.model.po.ProductInsightExample;
import com.yz.sophia.insight.model.vo.LineChartDataVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductInsightMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_insight
     *
     * @mbggenerated
     */
    int countByExample(ProductInsightExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_insight
     *
     * @mbggenerated
     */
    int deleteByExample(ProductInsightExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_insight
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_insight
     *
     * @mbggenerated
     */
    int insert(ProductInsight record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_insight
     *
     * @mbggenerated
     */
    int insertSelective(ProductInsight record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_insight
     *
     * @mbggenerated
     */
    List<ProductInsight> selectByExample(ProductInsightExample example);

    List<ProductInsight> selectPageByExample(ProductInsightExample example);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_insight
     *
     * @mbggenerated
     */
    ProductInsight selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_insight
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ProductInsight record, @Param("example") ProductInsightExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_insight
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ProductInsight record, @Param("example") ProductInsightExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_insight
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ProductInsight record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_insight
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ProductInsight record);

    List<LineChartDataVo> lineChartByExampleDay(ProductInsightExample example);

    List<LineChartDataVo> lineChartByExampleHour(ProductInsightExample example);
}