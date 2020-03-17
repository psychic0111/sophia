package com.yz.sophia.stargaze.provider;

import com.yz.sophia.business.api.entity.CommonResponse;
import com.yz.sophia.stargaze.model.po.PoiArea;
import com.yz.sophia.stargaze.model.response.POIProvinceDetailResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * FeignClient命名规则说明:
 * name 为提供服务的${spring.application.name}名称,不能写错,否则使用api的客户端在注册中心无法找到对应的服务。
 * 		比如sophia-b2b-stargaze-provider 为sophia-b2b-stargaze项目provider模块提供的服务
 * path 为api的相对路径,格式:${server.servlet.context-path|/相对路径
 * 		比如/api/customer
 */
@Api("POI检索")
@FeignClient(name = "sophia-b2b-stargaze-provider",path = "/api/stargaza")
@RequestMapping("/poi")
public interface POIAreaProvider {

    @ResponseBody
    @ApiOperation("查询所有省范围下监测点数量")
    @RequestMapping(value="/countProvincesPoints",method = RequestMethod.GET)
    CommonResponse<List<POIProvinceDetailResp>> countProvincesPoints();

    // 服务中方法的映射路径,确保参数一致
	@GetMapping("/searchByProvince")
	@ApiOperation("检索省范围下的地点海拔数据")
	CommonResponse<List<PoiArea>> searchByProvince(@ApiParam(name = "provinceName", value = "省、直辖市名称, 例如：北京市、河北省", defaultValue = "", required = true) String provinceName);

	@GetMapping("/searchByCity")
	@ApiOperation("检索市范围下的地点海拔数据")
	CommonResponse<List<PoiArea>> searchByCity(@ApiParam(name = "provinceName", value = "省、直辖市名称, 例如：北京市、河北省", defaultValue = "", required = true) String provinceName,
											   @ApiParam(name = "cityName", value = "市、区的名称, 例如：张家口市、朝阳区", defaultValue = "", required = true) String cityName);
}
