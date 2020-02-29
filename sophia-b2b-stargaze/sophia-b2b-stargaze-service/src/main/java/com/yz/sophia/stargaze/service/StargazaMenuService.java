package com.yz.sophia.stargaze.service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.yz.sophia.business.api.exception.BusinessException;
import com.yz.sophia.business.core.util.BeanUtils;
import com.yz.sophia.business.core.util.DateUtils;
import com.yz.sophia.stargaze.dao.CockpitNavigationMenuMapper;
import com.yz.sophia.stargaze.dao.CustomerMapper;
import com.yz.sophia.stargaze.model.enums.CooperationModeEnum;
import com.yz.sophia.stargaze.model.po.CockpitNavigationMenu;
import com.yz.sophia.stargaze.model.po.CockpitNavigationMenuExample;
import com.yz.sophia.stargaze.model.po.Customer;
import com.yz.sophia.stargaze.model.qo.CustomerQo;
import com.yz.sophia.stargaze.model.request.CustomerAddReq;
import com.yz.sophia.stargaze.model.vo.CustomerInfoVo;
import com.yz.sophia.stargaze.model.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class StargazaMenuService {

    @Autowired
    private CockpitNavigationMenuMapper cockpitNavigationMenuMapper;


    /**
     * 查询二级菜单
     * @param parentTitle
     * @return
     */
    public List<CockpitNavigationMenu> getMenuList(int parentTitle) {
        log.debug("查询二级菜单入参，parentTitle：" + parentTitle);
        CockpitNavigationMenuExample cockpitNavigationMenuExample = new CockpitNavigationMenuExample();
        cockpitNavigationMenuExample.createCriteria().andParentTitleEqualTo(parentTitle);
        List<CockpitNavigationMenu> cockpitNavigationMenus = cockpitNavigationMenuMapper.selectByExample(cockpitNavigationMenuExample);
        log.debug("查询二级菜单返回，cockpitNavigationMenus：" + cockpitNavigationMenus.toString());
        return cockpitNavigationMenus;
    }
}
