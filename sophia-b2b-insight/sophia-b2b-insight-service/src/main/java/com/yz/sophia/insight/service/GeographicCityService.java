package com.yz.sophia.insight.service;

import com.yz.sophia.business.api.entity.Page;
import com.yz.sophia.insight.dao.GeographicCityMapper;
import com.yz.sophia.insight.dao.GeographicCityRelMapper;
import com.yz.sophia.insight.dao.LegalInstrumentInfoMapper;
import com.yz.sophia.insight.dao.LegalInstrumentMapper;
import com.yz.sophia.insight.model.po.*;
import com.yz.sophia.insight.model.response.GeographicCityResp;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GeographicCityService {

    @Autowired
    private GeographicCityMapper geographicCityMapper;

    @Autowired
    private GeographicCityRelMapper geographicCityRelMapper;


    public List<GeographicCityResp> queryGeographicData(String cityId,String cityProvince) throws Exception{
        List<GeographicCityResp> geograList = null;
        GeographicCityExample example = new GeographicCityExample();
        GeographicCityExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(cityId)) {
            criteria.andCityIdEqualTo(cityId);
        }
        if (StringUtils.isNotEmpty(cityProvince)) {
            criteria.andCityProvinceEqualTo(cityProvince);
        }
        geograList = geographicCityMapper.selectListByExample(example);
        if (geograList != null && geograList.size()>0) {
            for (GeographicCityResp geogra:
                 geograList) {
                String cityId2 = geogra.getCityId();
                GeographicCityRelExample exampleRel = new GeographicCityRelExample();
                exampleRel.createCriteria().andCityIdEqualTo(cityId2);
                List<GeographicCityRel> geographicCityRels = geographicCityRelMapper.selectByExample(exampleRel);
                geogra.setGeographicCityRelList(geographicCityRels);
            }
        }
        return geograList;
    }
}
