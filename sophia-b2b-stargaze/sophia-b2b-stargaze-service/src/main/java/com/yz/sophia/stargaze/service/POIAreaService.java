package com.yz.sophia.stargaze.service;

import com.yz.sophia.stargaze.dao.PoiAreaMapper;
import com.yz.sophia.stargaze.model.po.PoiArea;
import com.yz.sophia.stargaze.model.po.PoiAreaExample;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class POIAreaService {

    @Autowired
    private PoiAreaMapper poiAreaMapper;

    public List<PoiArea> listPOI(String provinceName, String cityName, Integer limitCount){
        PoiAreaExample example = new PoiAreaExample();
        PoiAreaExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(provinceName)){
            criteria.andProvinceNameEqualTo(provinceName.trim());
        }

        if(StringUtils.isNotBlank(cityName)){
            criteria.andCityNameEqualTo(cityName.trim());
        }

        example.setOrderByClause("province_name, city_name");
        List<PoiArea> poiAreaList = poiAreaMapper.selectByExample(example);

        if(limitCount != null && limitCount > 0){
            return poiAreaList.subList(0, limitCount - 1);
        }
        return poiAreaList;
    }
}
