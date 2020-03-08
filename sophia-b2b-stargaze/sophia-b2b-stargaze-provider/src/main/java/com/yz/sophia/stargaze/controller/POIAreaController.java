package com.yz.sophia.stargaze.controller;

import com.yz.sophia.business.api.entity.CommonResponse;
import com.yz.sophia.stargaze.model.po.PoiArea;
import com.yz.sophia.stargaze.provider.POIAreaProvider;
import com.yz.sophia.stargaze.service.POIAreaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 观星台驾驶舱数据
 */
@Slf4j
@CrossOrigin(origins = "*",maxAge = 3600)
@RestController("/poi")
public class POIAreaController extends BaseController implements POIAreaProvider {


    @Autowired
    private POIAreaService poiAreaService;

    @Override
    @ResponseBody
    @ApiOperation("检索省范围下的地点海拔数据")
    @RequestMapping(value="/searchByProvince",method = RequestMethod.POST)
    public CommonResponse<List<PoiArea>> searchByProvince(@ApiParam(name = "provinceName", value = "省、直辖市名称, 例如：北京市、河北省", defaultValue = "", required = true) @RequestParam(name = "provinceName", required = true) String provinceName) {
        CommonResponse<List<PoiArea>> respData = new CommonResponse<>();

        try {
            respData = super.visit(() -> {
                List<PoiArea> poiAreaList = poiAreaService.listPOI(provinceName, null, null);
                return poiAreaList;
            });
        } catch (Exception e) {
            log.info("检索省范围下的地点海拔数据：e:"+e.getMessage());
            e.printStackTrace();
        }
        return respData;
    }

    @Override
    @ResponseBody
    @RequestMapping(value="/searchByCity",method = RequestMethod.POST)
    @ApiOperation("检索市范围下的地点海拔数据")
    public CommonResponse<List<PoiArea>> searchByCity(@ApiParam(name = "provinceName", value = "省、直辖市名称, 例如：北京市、河北省", defaultValue = "", required = true) @RequestParam(name = "provinceName", required = true) String provinceName,
                                                      @ApiParam(name = "cityName", value = "市、区的名称, 例如：张家口市、朝阳区", defaultValue = "", required = true) @RequestParam(name = "cityName", required = true) String cityName) {
        CommonResponse<List<PoiArea>> respData = new CommonResponse<>();

        try {
            respData = super.visit(() -> {
                List<PoiArea> poiAreaList = poiAreaService.listPOI(provinceName, cityName, null);
                return poiAreaList;
            });
        } catch (Exception e) {
            log.info("检索市范围下的地点海拔数据：e:"+e.getMessage());
            e.printStackTrace();
        }
        return respData;
    }
}
