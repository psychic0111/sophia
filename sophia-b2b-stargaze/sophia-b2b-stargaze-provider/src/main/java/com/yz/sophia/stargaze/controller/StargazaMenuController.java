package com.yz.sophia.stargaze.controller;

import com.yz.sophia.business.api.entity.CommonResponse;
import com.yz.sophia.stargaze.model.po.CockpitNavigationMenu;
import com.yz.sophia.stargaze.provider.CustomerProvider;
import com.yz.sophia.stargaze.provider.StargazaMenuprovider;
import com.yz.sophia.stargaze.service.CustomerService;
import com.yz.sophia.stargaze.service.StargazaMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


/**
 * 观星台菜单
 */
@Slf4j
@CrossOrigin(origins = "*",maxAge = 3600)
@RestController("/stargazaMenu")
public class StargazaMenuController extends BaseController implements StargazaMenuprovider {


	@Autowired
	private StargazaMenuService stargazaMenuService;

	@Override
	@ResponseBody
	@ApiOperation(value = "观星台查询二级菜单列表")
	@RequestMapping(value="/getMenuList",method = RequestMethod.POST)
	public CommonResponse<List<CockpitNavigationMenu>> getMenuList(@ApiParam(name="parentTitle", value="父菜单编号，1=文化类；2=政治类；3=民生类；4=经济类", defaultValue="1", required=true) int parentTitle) {
		log.info("查询二级菜单的接口数为，parentTitle："+parentTitle);
		CommonResponse<List<CockpitNavigationMenu>> respData = null;
		try {
			respData = super.visit(() -> {
				List<CockpitNavigationMenu> menuList = stargazaMenuService.getMenuList(parentTitle);
				log.info("查询二级菜单接口返回参数：menuList:"+ menuList);
				return menuList;
			});
		} catch (Exception e) {
			log.info("查询二级菜单接口异常：e:"+e.getMessage());
			e.printStackTrace();
		}
		return respData;
	}

}
