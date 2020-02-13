# sophia-business-all
基于bsf之下的公共业务框架,所有公共业务的组件放这里

## 项目结构规范说明
```
sophia-business-all
    -- sophia-business-api (api常用协议定义,此处不准使用bsf框架)
    -- sophia-business-core (业务公共的核心层)
    -- sophia-business-dependencies (项目依赖pom定义)
    -- sophia-business-starter （项目full-start包）
    -- sophia-business-extend （专门为供应链项目做的扩展包,注意: 其他项目不能使用）
```

## 相关文档
* sophia-business-api
   api常用协议的定义,里面不能包含其他的包和复杂的逻辑内容,必须保持精简。
* sophia-business-core 
   里面的包含对业务的公共抽象类库,以及常用的工具类。
* sophia-business-extend
   里面包含对业务的扩展包，仅为供应链项目的扩展兼容支持【其他项目不能使用】
* business公共业务组件集成文档(包含api和core内核,默认已集成并关闭)
   http://10.252.192.10:8080/webdoc/view/Pubff8080816aff1991016baca03d227951.html

## 编译说明
1. mvn install sophia-business-dependencies
2. mvn install sophia-business-all

## 版本升级/切换
```
版本号规则: bsf的版本号 + 业务版本号  (版本号+-+RELEASE/SNAPSHOT)
cd sophia-business-dependencies
mvn versions:set -DgenerateBackupPoms=false
或
mvn versions:set -DgenerateBackupPoms=false -DnewVersion={version}
```
    
## 其他    
 

##### by 车江毅