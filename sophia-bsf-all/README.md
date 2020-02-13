# sophia-bsf-all
## 介绍
BSF 为 base service framework 的简写，定义为技术团队的基础框架,用于基础服务的集成和跟业务无关的基础技术集成。

BSF集成了自研的监控报警，用来监控各个服务系统的性能及异常告警。集成并封装Apollo,Rocket MQ,Redis, Elastic Search,ELK,XXLJOB, Sharding JDBC,Cat,Eureka,七牛云等第三方中间件，提供简易使用的底层框架。

## 愿景
为了更好地支持业务开发，让开发人员从中间件中解放出来，专注业务以提高开发效率。同时基础框架集中统一优化中间件相关服务及使用，为开发人员提供高性能,更方便的基础服务接口及工具。

## 项目结构规范说明
```
sophia-bsf-all 
    -- sophia-bsf-core (项目核心类库)
    -- sophia-bsf-demo (项目集成使用demo)
    -- sophia-bsf-dependencies (项目依赖pom定义)
        -- README.md (说明文档，必须有)
    -- sophia-bsf-starter （项目full-start包）
    -- sophia-bsf-elk (ELK集成)
    -- sophia-bsf-job (XXL-JOB集成)
    -- sophia-bsf-cat (CAT监控集成)
    -- sophia-bsf-apollo (Apollo配置中心集成)
    -- sophia-bsf-message (消息-短信-钉钉消息集成)
    -- sophia-bsf-shardingjdbc (分库分表ShardingJDBC 集成) 
    -- sophia-bsf-mq (消息队列Rocket MQ集成) 
    -- sophia-bsf-redis(缓存Redis集成)
    -- sophia-bsf-eureka(服务注册与发现集成)
    -- sophia-bsf-file（文件服务集成）
    -- sophia-bsf-elasticsearch(ES集成) 
    -- sophia-bsf-health（自研健康检查） 
    -- 框架名 (例如:sophia-bsf-elk,cat,apollo等)
```

## 相关文档
本系统个子模块分别集成分装了对应中间件服务，文档如下：
1. [sophia-bsf-core](sophia-bsf-core/README.md)
2. [sophia-bsf-demo](sophia-bsf-demo/README.md)
3. [sophia-bsf-dependencies](sophia-bsf-dependencies/README.md)
4. [sophia-bsf-starter](sophia-bsf-starter/README.md)
5. [sophia-bsf-elk](sophia-bsf-elk/README.md) 
6. [sophia-bsf-job](sophia-bsf-job/README.md) 
7. [sophia-bsf-cat](sophia-bsf-cat/README.md) 
8. [sophia-bsf-apollo](sophia-bsf-apollo/README.md) 
9. [sophia-bsf-message](sophia-bsf-message/README.md) 
10. [sophia-bsf-shardingjdbc](sophia-bsf-shardingjdbc/README.md) 
11. [sophia-bsf-mq](sophia-bsf-mq/README.md) 
12. [sophia-bsf-redis](sophia-bsf-redis/README.md) 
13. [sophia-bsf-eureka](sophia-bsf-eureka/README.md) 
14. [sophia-bsf-file](sophia-bsf-file/README.md) 
15. [sophia-bsf-elasticsearch](sophia-bsf-elasticsearch/README.md) 
16. [sophia-bsf-health](sophia-bsf-health/README.md) 

## 编译说明
1. mvn install sophia-bsf-dependencies
2. mvn install sophia-bsf-all

## 版本升级/切换
```
备注: 格式:1.0.0-RELEASE (版本号+-+RELEASE/SNAPSHOT) 
cd sophia-bsf-dependencies
mvn versions:set -DgenerateBackupPoms=false
或
mvn versions:set -DgenerateBackupPoms=false -DnewVersion={version}
```

## 使用说明

1. 依赖引用

    继承sophia-bsf-dependencies
``` 
    <parent>
        <groupId>com.yz.sophia.bsf</groupId>
        <artifactId>sophia-bsf-dependencies</artifactId>
        <version>1.7.1-SNAPSHOT</version>
    </parent>
```
    或者引入依赖 sophia-bsf-starter
```
    <dependency>
        <groupId>com.yz.sophia.bsf</groupId>
        <artifactId>sophia-bsf-dependencies</artifactId>
        <version>1.7.1-SNAPSHOT</version>
        <type>pom</type>
        <scope>import</scope>
    </dependency>
    <dependency>
       <artifactId>sophia-bsf-starter</artifactId>
       <groupId>com.yz.sophia.bsf</groupId>
       <version>1.7.1-SNAPSHOT</version>
    </dependency>
```

2. Demo程序  
    框架的使用demo，请参考[sophia-bsf-demo](sophia-bsf-demo)  
    各个组件的使用，请参考相关模块文档。

3. 参考properties配置文件  
    [resources/application.properties](resources/application.properties)

注意：
    首次下载代码,首先构建sophia-bsf-dependencies模块，然后在构建整个工程。

    ```shell 
    cd sophia-bsf-dependencies
    mvn install
    cd ../
    mvn install 
    ```

