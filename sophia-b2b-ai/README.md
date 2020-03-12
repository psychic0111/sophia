# sophia-b2b-ai

彩食鲜标准项目模板（脚手架）,所有的后端java项目都必须按照这个项目模板构建。
* 标准化项目结构:定义标准的项目分层结构,便于技术资源共享和交叉业务协作开发。
* 标准化技术选型:定义标准的分布式技术选型,便于运维人员统一维护,同时简化使用和统一性能监控和优化。
* 愿景：业务开发只关注业务需求,专注编写业务代码; 对于技术只关注使用,不需要关注基础服务的集成和相关配置(因为所有都已经集成完毕)。
       

## 通过脚手架初始化项目
脚手架目录: /doc/client.sh
```
# 使用说明: [windows 下面使用git bash运行]
# curl -O  http://10.252.192.3/sophia-public/sophia-b2b-ai/raw/{分支名:默认master}/doc/client.sh
# sh client.sh {项目名:默认demo,必填} {分支名:默认master,可不填}

curl -O  http://10.252.192.3/sophia-public/sophia-b2b-ai/raw/master/doc/client.sh
sh client.sh test
```

## 通过自动化部署脚本部署环境
自动化部署脚本目录: /doc/jenkins-client.sh
自动部署jenkins环境+ssh主机登陆,自动部署web api server（支持2台负载均衡,不包含java sdk安装）
```
# 使用说明: [windows 下面使用git bash运行]
# curl -O  http://10.252.192.3/sophia-public/sophia-b2b-ai/raw/{分支名:默认master}/doc/jenkins-client.sh
# sh jenkins-client.sh

curl -O  http://10.252.192.3/sophia-public/sophia-b2b-ai/raw/master/doc/jenkins-client.sh
sh jenkins-client.sh
```
## 项目git分支管理说明
```
jenkins 一般发布的分支为test,prd 两个分支
/test 测试发布分支(所有新版本合并到最新的测试版本的分支)
/prd 线上发布分支(所有待发布版本合并到最新的发布版本的分支)
```
## 项目结构说明
```
sophia-b2b-ai
    -- sophia-b2b-ai-api  #api端第三方调用提供request，response类库 （api协议层）
    -- sophia-b2b-ai-core #公共代码 （核心层）
    -- sophia-b2b-ai-dao #数据库操作 （数据层）
    -- sophia-b2b-ai-service  #业务逻辑 （服务层）
    -- sophia-b2b-ai-task #批处理任务 （任务层）
    -- sophia-b2b-ai-provider #api端接口实现（api实现层，提供者模式）
 -- doc #项目资料 （文档资料）
 -- README.md #项目文档 （说明文档）
```

## 项目开发人员（必读） -- 新员工培训手册
http://10.252.192.10:8080/webdoc/view/Pubff808081685d412e0168a820df7803f7.html

## 项目开发和线上环境说明
http://10.252.192.10:8080/webdoc/view/Pubff808081685d412e016ab3f557fd258c.html

## mybatis代码自动生成参考知识库
生成器目录:/doc/mybatis-generator.zip
* http://10.252.192.10:8080/webdoc/view/Pubff808081685d412e01685ef34d3000d4.html
  
## pinpoint 部署集成探针示例
* http://10.252.192.10:8080/webdoc/view/Pubff808081685d412e016a47dd82761517.html

## elk集成文档(默认已集成并关闭)
* http://10.252.192.10:8080/webdoc/view/Pubff808081685d412e016a6888a08918e1.html

## cat集成文档（默认已集成并关闭）
* http://10.252.192.10:8080/webdoc/view/Pubff8080816aff1991016b59439508742f.html

## job集成文档(默认已集成并关闭)
* http://10.252.192.10:8080/webdoc/view/Pubff808081685d412e016adfd16d861465.html

## message 消息集成文档（默认已集成并关闭）
* 短信: http://10.252.192.10:8080/webdoc/view/Pubff808081685d412e016ac55bd8871e6e.html

## mq 消息队列集成文档（默认已集成并关闭）
* rocketmq: http://10.252.192.10:8080/webdoc/view/Pubff8080816aff1991016b500707553c73.html

## apollo 配置中心集成文档（默认已集成并关闭）
* http://10.252.192.10:8080/webdoc/view/Pubff8080816aff1991016b593af2753365.html

## sharding-jdbc 集成文档 （默认已集成,但关闭）
* http://10.252.192.10:8080/webdoc/view/Pubff8080816aff1991016b594a7a342c31.html

## eureka 注册服务 (默认已集成并关闭)
* http://10.252.192.10:8080/webdoc/view/Pubff8080816aff1991016b5aa3c67c0f86.html

## eureka 调用其他项目api集成 (默认已集成并关闭)
* http://10.252.192.10:8080/webdoc/view/Pubff8080816aff1991016b9cc99535234d.html

## redis缓存集成文档（默认已集成并关闭）
* http://10.252.192.10:8080/webdoc/view/Pubff8080816aff1991016b788cad130b5f.html

## elasticsearch-sql集成文档（默认已集成并关闭）
* http://10.252.192.10:8080/webdoc/view/Pubff8080816aff1991016b7937b16035f1.html

## business公共业务组件集成文档(包含api和core内核,默认已集成并关闭)
http://10.252.192.10:8080/webdoc/view/Pubff8080816aff1991016baca03d227951.html

## 公开第三方接口给其他应用调用
1. cd sophia-b2b-ai-api  #进入api
2. mvn clean install #编译api
3. mvn deploy  #部署到nesus 给第三方引用
备注: 如果项目根pom文件有更新则还需要发布根pom文件(一般这里会定义jar版本号)

## 安装部署目录结构标准
```
/home/web #线上部署目录结构说明,用户web,默认目录归属web用户
    -- jenkins-publish #jenkins自动上传jar的目录
    -- demo-provider #项目demo-provider目录
        -- sophia-b2b-ai-provider-1.0-SNAPSHOT.jar #spring-boot 服务集合打包jar
        -- start.sh #项目start 启动脚本 详情如下
        -- backup #jar 包备份
        -- rollback.sh #项目rollback 回滚脚本 详情如下
        -- pinpoint-agent #pinpoint 部署集成 详情如下
```

## 启动脚本和回滚脚本示例
* 启动脚本: http://10.252.192.10:8080/webdoc/view/Pubff808081685d412e01688432f6080311.html
* 回滚脚本: http://10.252.192.10:8080/webdoc/view/Pubff808081685d412e016a1092a2f5101a.html

## jenkins 部署示例
* 正常: sophia_dev_demo (dev是开发环境)
* 回滚: sophia_dev_demo_rollback

## sonar 代码质量检测集成示例
* http://10.252.192.10:8080/webdoc/view/Pubff808081685d412e016a86812bf319e0.html
  
## 注意事项
1.  项目采用jenkins部署,必须有正常发布，也有回滚发布。
2.  项目部署目录采用web权限用户部署。

