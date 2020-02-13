package com.yz.sophia.business.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: chejiangyi
 * @version: 2019-08-08 16:03
 **/
@Data
@AllArgsConstructor
public class Page<T> implements Serializable {

    private int pageNum;

    private int pageSize;

    private int totalNum;

    private List<T> data;

}