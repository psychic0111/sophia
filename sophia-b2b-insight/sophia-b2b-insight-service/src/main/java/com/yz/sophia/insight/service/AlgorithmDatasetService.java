package com.yz.sophia.insight.service;

import com.yz.sophia.business.api.entity.Page;
import com.yz.sophia.insight.dao.AlgorithmDatasetMapper;
import com.yz.sophia.insight.dao.ProductInsightMapper;
import com.yz.sophia.insight.model.po.AlgorithmDataset;
import com.yz.sophia.insight.model.po.AlgorithmDatasetExample;
import com.yz.sophia.insight.model.po.ProductInsight;
import com.yz.sophia.insight.model.po.ProductInsightExample;
import com.yz.sophia.insight.model.vo.LineChartDataVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class AlgorithmDatasetService {

    @Autowired
    private AlgorithmDatasetMapper algorithmDatasetMapper;

    public Page<AlgorithmDataset> listAlgorithmDataset(String category, String orderField, String orderType, Integer pageIndex, Integer pageSize){
        AlgorithmDatasetExample example = new AlgorithmDatasetExample();
        AlgorithmDatasetExample.Criteria criteria = example.createCriteria();

        pageIndex = pageIndex == null ? 1 : pageIndex;
        pageSize = pageSize == null ? 10 : pageSize;

        if(StringUtils.isNotBlank(category)){
            criteria.andCategoryEqualTo(category);
        }

        int totalCount = algorithmDatasetMapper.countByExample(example);

        int offset = (pageIndex - 1) * pageSize;
        example.setOffset(offset);
        example.setPageSize(pageSize);
        if(StringUtils.isEmpty(orderField)){
            orderField = "category, data_type";
        }
        if(StringUtils.isEmpty(orderType)){
            orderType = "desc";
        }
        example.setOrderByClause(orderField + " " + orderType);
        List<AlgorithmDataset> list = algorithmDatasetMapper.selectPageByExample(example);

        Page<AlgorithmDataset> pageInfo = new Page<AlgorithmDataset>(pageIndex, pageSize, totalCount, list);
        return pageInfo;
    }

}
