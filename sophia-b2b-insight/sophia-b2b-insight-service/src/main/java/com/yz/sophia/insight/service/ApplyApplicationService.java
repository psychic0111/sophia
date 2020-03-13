package com.yz.sophia.insight.service;

import com.yz.sophia.bsf.utils.SnowflakeIdWorker;
import com.yz.sophia.business.api.entity.Page;
import com.yz.sophia.business.core.util.BeanUtils;
import com.yz.sophia.insight.dao.*;
import com.yz.sophia.insight.model.po.*;
import com.yz.sophia.insight.model.request.ApplyApplicationReq;
import com.yz.sophia.insight.model.response.ApplyApplicationRelResp;
import com.yz.sophia.insight.util.AppKeyUtils;
import com.yz.sophia.insight.util.MathUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ApplyApplicationService {

    @Autowired
    private ApplyApplicationMapper applyApplicationMapper;

    @Autowired
    private ApplyApplicationRelMapper applyApplicationRelMapper;
    
    @Autowired
    private MultilevelMenuMapper multilevelMenuMapper;

    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;

    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public Integer insertApplication(ApplyApplicationReq req) throws Exception{
        //1.新增ApplyApplication表
        ApplyApplicationReq applyApplicationQo = BeanUtils.convert(ApplyApplicationReq.class, req);
        log.info("录入接口入参，applyApplicationQo：" + applyApplicationQo.toString());
        String hexString = MathUtils.getPrimaryKey(6);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String appKey = AppKeyUtils.getAppKey();
        String appSecret = AppKeyUtils.getAppSecret(appKey);
        ApplyApplication applyApplication = new ApplyApplication();
        applyApplication.setUserId(applyApplicationQo.getUserId());
        applyApplication.setApplicationName(applyApplicationQo.getApplicationName());
        applyApplication.setApplicationType(applyApplicationQo.getApplicationType());
        applyApplication.setApplicationService(applyApplicationQo.getApplicationService());
        applyApplication.setApplicationDescribe(applyApplicationQo.getApplicationDescribe());
        applyApplication.setApplicationCode(hexString);
        applyApplication.setAuditStatus(0);//0=待审核，1=审核通过，2=审核不通过
        applyApplication.setStatus(0);//-1=删除，0=正常
        applyApplication.setApiKey(appKey);
        applyApplication.setSecretKey(appSecret);
        applyApplication.setCreateTime(timestamp);
        applyApplication.setUpdateTime(timestamp);
        int insertNum = applyApplicationMapper.insert(applyApplication);
        //2.新增ApplyApplicationRel关联表
        List<String> menusCodeList = applyApplicationQo.getMenusCodeList();
        if (menusCodeList == null) {
            throw new Exception("menusCodeList不能为空！");
        }
        List<ApplyApplicationRel> aaRelList = new ArrayList<>();
        for (String menusCode: menusCodeList) {
            ApplyApplicationRel rel = new ApplyApplicationRel();
            rel.setMenusCode(menusCode);
            rel.setApplicationCode(hexString);
            aaRelList.add(rel);
        }
        int insertBatchNum = applyApplicationRelMapper.insertBatch(aaRelList);
        return insertNum;
    }

    public Page<ApplyApplication> queryApplicationPage(String userId, Integer pageIndex, Integer pageSize) throws Exception{

        ApplyApplicationExample example = new ApplyApplicationExample();
        ApplyApplicationExample.Criteria criteria = example.createCriteria();

        pageIndex = pageIndex == null ? 1 : pageIndex;
        pageSize = pageSize == null ? 10 : pageSize;
        if(StringUtils.isEmpty(userId)){
            throw new Exception("userId不能为空！");
        }
        criteria.andUserIdEqualTo(userId);
        criteria.andStatusEqualTo(0);//正常状态
        int totalCount = applyApplicationMapper.countByExample(example);
        int offset = (pageIndex - 1) * pageSize;
        example.setOffset(offset);
        example.setPageSize(pageSize);
        example.setOrderByClause("create_time" + " " + "desc");//排序规则
        List<ApplyApplication> list = applyApplicationMapper.selectPageByExample(example);
        Page<ApplyApplication> pageInfo = new Page<ApplyApplication>(pageIndex, pageSize, totalCount, list);
        return pageInfo;
    }

    public ApplyApplicationRelResp queryApplicationInfo(String applicationCode) throws Exception {
        ApplyApplicationRelResp aaResp = applyApplicationMapper.selectByPrimaryKey(applicationCode);
        if (aaResp == null ) {
            throw new Exception("查询接口申请信息失败！");
        }
        List<Map<String, Object>> menuTwoList = null;
        List<Map<String, Object>> muitOneList = null;
        List<Map<String, Object>> menuOneList = null;
        List<Map<String, Object>> menuMapList = null;
        List<Map<String, Object>> allMenu = new ArrayList<Map<String, Object>>();
        String apCode = aaResp.getApplicationCode();
        ApplyApplicationRelExample applyApplicationRelExample = new ApplyApplicationRelExample();
        applyApplicationRelExample.createCriteria().andApplicationCodeEqualTo(apCode);
        List<ApplyApplicationRel> relList = applyApplicationRelMapper.selectByExample(applyApplicationRelExample);
        if (relList == null || relList.size() <= 0) {
            throw new Exception("查询关联表数据失败！");
        }
        List<Map<String, Object>> multilevelList = multilevelMenuMapper.selectByList(relList);
        List<Map<String, Object>> menuThreeList = multilevelList.stream().filter(a ->3==(Integer)a.get("menus_rank")).collect(Collectors.toList());//三级菜单
        List<Map<String, Object>> muitTwoList = multilevelList.stream().filter(a ->2==(Integer)a.get("menus_rank")).collect(Collectors.toList());//二级菜单
        if (menuThreeList != null && menuThreeList.size()>0) {
            menuTwoList = multilevelMenuMapper.selectByParentList(menuThreeList);//二级菜单
            allMenu.addAll(menuThreeList);
        }
        if (muitTwoList != null && muitTwoList.size()>0) {
            muitOneList = multilevelMenuMapper.selectByParentList(muitTwoList);//一级菜单
            allMenu.addAll(muitTwoList);
        }
        if (menuTwoList != null && menuTwoList.size()>0) {
            menuOneList = multilevelMenuMapper.selectByParentList(menuTwoList);//一级菜单
            allMenu.addAll(menuTwoList);
        }
        if (menuOneList != null && menuOneList.size()>0) {
            allMenu.addAll(menuOneList);
        }
        if (muitOneList != null && muitOneList.size()>0) {
            allMenu.addAll(muitOneList);
        }

        if (allMenu != null && allMenu.size()>0) {
            menuMapList = queryCategoryInfo(allMenu);//递归方式获取菜单树状结构
        }
        aaResp.setApplyApplicationRelList(menuMapList);
        return aaResp;
    }

    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public Integer delApplication(String applicationCode) throws Exception{
        ApplyApplication applyApplication = new ApplyApplication();
        applyApplication.setStatus(-1);
        applyApplication.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        ApplyApplicationExample applyApplicationExample = new ApplyApplicationExample();
        applyApplicationExample.createCriteria().andApplicationCodeEqualTo(applicationCode);
        int i = applyApplicationMapper.updateStatusByExample(applyApplication, applyApplicationExample);
        if (i <= 0) {
            throw new Exception("删除操作失败！");
        }
        return i;
    }


//    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
//    public Integer auditApplication(Integer auditOperate, String applicationCode) throws Exception {
//        if (auditOperate !=1 || auditOperate !=2) {
//            throw new Exception("auditOperatea值非法！");
//        }
//        ApplyApplication applyApplication = new ApplyApplication();
//        applyApplication.setAuditStatus(auditOperate);
//        applyApplication.setUpdateTime(new Timestamp(System.currentTimeMillis()));
//        ApplyApplicationExample applyApplicationExample = new ApplyApplicationExample();
//        applyApplicationExample.createCriteria().andApplicationCodeEqualTo(applicationCode);
//        int i = applyApplicationMapper.updateByExample(applyApplication, applyApplicationExample);
//        if (i <= 0) {
//            throw new Exception("审核操作失败！");
//        }
//        return i;
//    }

    public List<MultilevelMenu> getMultilevelMenu(Integer menusRank, String parentMenusCode) throws Exception{
        MultilevelMenuExample multilevelMenuExample = new MultilevelMenuExample();
        MultilevelMenuExample.Criteria criteria = multilevelMenuExample.createCriteria();
        if (menusRank != null) {
            criteria.andMenusRankEqualTo(menusRank);
        }
        if (!StringUtils.isEmpty(parentMenusCode)) {
            criteria.andParentMenusCodeEqualTo(parentMenusCode);
        }
        List<MultilevelMenu> multilevelMenuList = multilevelMenuMapper.selectByExample(multilevelMenuExample);
        log.debug("查询二级菜单返回，multilevelMenuList：" + multilevelMenuList.toString());
        return multilevelMenuList;
    }


    protected List<Map<String, Object>> queryCategoryInfo(List<Map<String, Object>> allMenu) {
        //根节点
        List<Map<String, Object>> rootMenu = new ArrayList<Map<String, Object>>();
        for (Map<String, Object> nav : allMenu) {
            String parentId = String.valueOf(nav.get("menus_rank"));
            if(parentId.equals("1")){//父节点是1的，为根节点。
                rootMenu.add(nav);
            }
        }
        /* 根据Menu类的order排序 */
//	      Collections.sort(rootMenu, order());
        //为根菜单设置子菜单，getClild是递归调用的
        for (Map<String, Object> nav : rootMenu) {
            /* 获取根节点下的所有子节点 使用getChild方法*/
            String id = String.valueOf(nav.get("menus_code"));
            List<Map<String, Object>> childList = getChild(id, allMenu);
//	        nav.setChildren(childList);//给根节点设置子节点
            nav.put("child", childList);
        }


        return rootMenu;
    }


    /**
     * 	获取子节点
     * @param id 父节点id
     * @param allMenu 所有菜单列表
     * @return 每个根节点下，所有子菜单列表
     */
    protected List<Map<String, Object>> getChild(String id,List<Map<String, Object>> allMenu){
        //子菜单
        List<Map<String, Object>> childList = new ArrayList<Map<String, Object>>();
        for (Map<String, Object> nav : allMenu) {
            // 遍历所有节点，将所有菜单的父id与传过来的根节点的id比较
            //相等说明：为该根节点的子节点。
            String parentId = String.valueOf(nav.get("parent_menus_code"));
            if(id.equals(parentId)){
                childList.add(nav);
            }
        }
        //递归
        for (Map<String, Object> nav : childList) {
            String tempId = String.valueOf(nav.get("menus_code"));
            //nav.setChildren(,getChild(tempId, allMenu));
            nav.put("child", getChild(tempId, allMenu));
        }
        //Collections.sort(childList,order());//排序
        //如果节点下没有子节点，返回一个空List（递归退出）
        if(childList.size() == 0){
            return new ArrayList<Map<String, Object>>();
        }
        return childList;
    }

}
