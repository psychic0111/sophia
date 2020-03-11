package com.yz.sophia.insight.service;

import com.yz.sophia.insight.dao.VisitorsFlowrateMapper;
import com.yz.sophia.insight.model.po.VisitorsFlowrate;
import com.yz.sophia.insight.model.po.VisitorsFlowrateExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Service;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author zhaojing.jiang
 * @date 2020-03-11
 */
@Service
public class VisitorsFlowrateService {
    @Autowired
    VisitorsFlowrateMapper visitorsFlowrateMapper;

    public List<VisitorsFlowrate> getVisitorsFlowrateByDateAndSpot(String startDate, String endDate, String spot) {

        VisitorsFlowrateExample ex = new VisitorsFlowrateExample();

        ex.createCriteria().andTrafficDateBetween(strToDateLong(startDate), strToDateLong(endDate)).andScenicSpotEqualTo(spot);
        List<VisitorsFlowrate> list = visitorsFlowrateMapper.selectByExample(ex);
        return list;
    }

    public static Date strToDateLong(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }
}
