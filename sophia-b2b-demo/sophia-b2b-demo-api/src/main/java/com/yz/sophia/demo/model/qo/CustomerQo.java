package com.yz.sophia.demo.model.qo;

import java.util.List;

import com.yz.sophia.business.api.entity.Pagination;
import lombok.Data;


@Data
public class CustomerQo extends Pagination {
	private Long id;
	private String customerNumber;
	private String regionProvinceName;
	private String regionCity;
	private String regionArea;
	private String customerStatus;
	private List<String> notCustomerStatusList;
	private Long salesUserId;
	private Long managerUserId;
	private String firstCategoryCode;
	private String secondCategoryCode;
	private String salesProvince;
	private Integer minOrderCount;
	private Integer maxOrderCount;
	private String keyword;
	// 排序字段：1-距离(暂不支持)，2-日下单额，3-客单价，4-月频次，5-未下单天数
	private Integer orderField;
	// 排序类型: 0-升序，1-降序
	private Integer sortType;
	private Double longitude;
	private Double latitude;
}
