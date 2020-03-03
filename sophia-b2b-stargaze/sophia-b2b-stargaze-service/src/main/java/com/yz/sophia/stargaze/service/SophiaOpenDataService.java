package com.yz.sophia.stargaze.service;

import com.yz.sophia.business.api.entity.Page;
import com.yz.sophia.stargaze.dao.SophiaOpenServiceMapper;
import com.yz.sophia.stargaze.model.po.SophiaOpenService;
import com.yz.sophia.stargaze.model.po.SophiaOpenServiceExample;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SophiaOpenDataService {

    @Autowired
    private SophiaOpenServiceMapper sophiaOpenServiceMapper;

    public Page<SophiaOpenService> listOpenServiceDataByKeyword(String keyword, int pageIndex, int pageSize){
        SophiaOpenServiceExample example = new SophiaOpenServiceExample();
        SophiaOpenServiceExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(keyword)){
            criteria.andDescriptionLike("%" + keyword + "%");
            example.or(new SophiaOpenServiceExample().createCriteria().andChildModuleLike("%" + keyword + "%"));
            example.or(new SophiaOpenServiceExample().createCriteria().andProductModuleLike("%" + keyword + "%"));
        }

        List<SophiaOpenService> list = sophiaOpenServiceMapper.selectByExample(example);
        Page<SophiaOpenService> page = new Page<>(pageIndex, pageSize, list.size(), list);
        return page;
    }
}
