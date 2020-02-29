package com.yz.sophia.stargaze.service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.yz.sophia.business.api.exception.BusinessException;
import com.yz.sophia.business.core.util.BeanUtils;
import com.yz.sophia.business.core.util.DateUtils;
import com.yz.sophia.stargaze.dao.CockpitStaChartDataMapper;
import com.yz.sophia.stargaze.dao.CockpitStatisticalChartsMapper;
import com.yz.sophia.stargaze.dao.CustomerMapper;
import com.yz.sophia.stargaze.model.enums.CooperationModeEnum;
import com.yz.sophia.stargaze.model.po.*;
import com.yz.sophia.stargaze.model.qo.CustomerQo;
import com.yz.sophia.stargaze.model.request.CustomerAddReq;
import com.yz.sophia.stargaze.model.request.StargazeQueryReq;
import com.yz.sophia.stargaze.model.response.StargazeCockpitResp;
import com.yz.sophia.stargaze.model.vo.CustomerInfoVo;
import com.yz.sophia.stargaze.model.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class StargazaCockpitService {

    @Autowired
    private CockpitStatisticalChartsMapper cockpitStatisticalChartsMapper;

    @Autowired
    private CockpitStaChartDataMapper cockpitStaChartDataMapper;

    /**
     * 查询驾驶舱统计数据
     * @param req
     * @return
     */
    public StargazeCockpitResp getCockpitData(StargazeQueryReq req) {
        StargazeQueryReq stargazeQueryReq = BeanUtils.convert(StargazeQueryReq.class, req);
        log.info("查询驾驶舱统计数据入参，stargazeQueryReq：" + stargazeQueryReq.toString());
        int parentTitle = stargazeQueryReq.getParentTitle();//一级菜单code
        String subTitleCode = stargazeQueryReq.getSubTitleCode();//二级菜单code
        int chartLocation = stargazeQueryReq.getChartLocation();//图表位置
        int chartType = stargazeQueryReq.getChartType();//图表类型
        String statisticsYear = stargazeQueryReq.getStatisticsYear();//统计年份
        //1.查询图表
        CockpitStatisticalChartsExample cocCharExample = new CockpitStatisticalChartsExample();
        CockpitStatisticalChartsExample.Criteria criteria = cocCharExample.createCriteria();
        criteria.andParentTitleEqualTo(parentTitle);
        criteria.andSubTitleCodeEqualTo(subTitleCode);
        criteria.andChartLocationEqualTo(chartLocation);
        criteria.andChartTypeEqualTo(chartType);
        List<CockpitStatisticalCharts> cockStaCharList = cockpitStatisticalChartsMapper.selectByExample(cocCharExample);
        if (cockStaCharList == null || cockStaCharList.size() <= 0){
            throw new BusinessException("查询驾驶舱统计数据-图表或菜单不存在");
        }
        log.debug("查询驾驶舱统计图表返回，cockStaCharList：" + cockStaCharList.toString());
        //2.查询图标数据
        CockpitStatisticalCharts cocStaCha = cockStaCharList.get(0);
        String chartCode = cocStaCha.getChartCode();
        CockpitStaChartDataExample cocStaDataExample = new CockpitStaChartDataExample();
        CockpitStaChartDataExample.Criteria dataCriteria = cocStaDataExample.createCriteria();
        dataCriteria.andChartCodeEqualTo(chartCode);
        if (!StringUtils.isEmpty(statisticsYear)){
            dataCriteria.andStatisticsYearEqualTo(statisticsYear);
        }
        List<CockpitStaChartData> cocStaChaDataList = cockpitStaChartDataMapper.selectByExample(cocStaDataExample);
        new StargazeCockpitResp();
        StargazeCockpitResp staCocResp = BeanUtils.convert(StargazeCockpitResp.class, cocStaCha);
        staCocResp.setCockpitDatatList(cocStaChaDataList);
        log.debug("查询驾驶舱统计数据返回，staCocResp：" + staCocResp.toString());
        return staCocResp;
    }
}
