package com.yz.sophia.insight.model.request;

import com.yz.sophia.insight.model.po.ApplyApplication;
import lombok.Data;

import java.util.List;


@Data
public class ApplyApplicationReq extends ApplyApplication {
	/**
	 *菜单code列表
	 */
	private List<String> menusCodeList;

}
