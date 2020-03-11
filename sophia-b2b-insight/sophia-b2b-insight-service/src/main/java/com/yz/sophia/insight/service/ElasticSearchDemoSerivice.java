//package com.yz.sophia.insight.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.google.common.collect.Lists;
//import com.yz.sophia.bsf.elasticsearch.base.ElasticSearchAware;
//import com.yz.sophia.bsf.elasticsearch.impl.ElasticSearchSqlProvider;
//import com.yz.sophia.insight.model.vo.UserVo;
//
//import lombok.Data;
//
///**
// * ElasticSearchSql 使用示范 sql 形式的 elasticsearch 使用封装
// * https://github.com/NLPchina/elasticsearch-sql 内部文档:
// * http://10.252.192.10:8080/webdoc/view/Pubff8080816aff1991016b7937b16035f1.html
// * 测试环境调试: http://10.252.192.41:8080/
// **/
//@Service
//public class ElasticSearchDemoSerivice {
//
//	@Data
//	public static class UserVo2 extends UserVo implements ElasticSearchAware {
//		public UserVo2(String id, String name) {
//			super(id, name);
//		}
//	}
//
//	@Autowired(required = false)
//	private ElasticSearchSqlProvider searchService;
//
//	// 查询index下的数据
//	public List<UserVo> selectByIndex() {
//		List<UserVo> result = searchService.searchBySql("select * from aaa where id = 5", UserVo.class);
//		return result;
//	}
//
//	// 查询type下的数据 SELECT * FROM indexName/type
//	public Object selectByType() {
//		List<UserVo> result = searchService.searchBySql("select * from aaa/bbb", UserVo.class);
//		return result;
//	}
//
//	// 数据对象需要实现com.yz.sophia.bsf.es.base.ElasticSearchAware接口,当数据对象的id不是null,
//	// 根据id插入或者更新数据.当id是null则直接插入数据
//	//
//	// 为了保证插入数据的效率,用户可自定义配置bsf.es.bulkSize.
//	// 当插入数据量小于bulkSize,使用遍历的方式提交数据
//	// 当插入数据量大于等于bulkSize,使用批量的方式提交数据
//	// 官方推荐bulkSize设置为1000-5000,根据数据对象的大小看情况调整
//	// bulkSize默认值为2000
//	public void insertOrUpdate() {
//		List<UserVo2> result = Lists.newArrayList();
//		// insert or update
//		result.add(new UserVo2("-1", "demo1"));
//		// insert or update
//		result.add(new UserVo2("1", "demo2"));
//		// insert
//		result.add(new UserVo2(null, "demo3"));
//		searchService.insertData("aaa", "bbb", result);
//	}
//
//	// 删除数据
//	public void delete() {
//		searchService.deleteBySql("delete from aaa where id = 5");
//	}
//}
