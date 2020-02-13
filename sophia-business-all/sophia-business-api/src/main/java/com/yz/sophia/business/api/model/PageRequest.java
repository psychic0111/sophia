package com.yz.sophia.business.api.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageRequest implements Serializable {

	private static final long serialVersionUID = 8357212825359633398L;

	private Integer pageNum = 1;

	private Integer pageSize = 10;
}
