package com.yz.sophia.bsf.shardingjdbc.base;

import java.lang.annotation.*;

/**
 * @author: chejiangyi
 * @version: 2019-09-01 14:24
 * 配置:spring.shardingsphere.sharding.default-database-strategy.hint.algorithm-class-name = DataSourceShardingAlgorithm
 **/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name() ;
}

