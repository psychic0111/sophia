#!/bin/bash
### 用途: 标准彩食鲜项目脚手架生成脚本
### 使用命令格式:
### curl -O http://10.252.192.3/sophia-public/sophia-b2b-demo/raw/{version}/doc/client.sh
### sh client.sh {projectname} {version}
### 示范:
### curl -O http://10.252.192.3/sophia-public/sophia-b2b-demo/raw/master/doc/client.sh
### sh client.sh test
###
### by 车江毅
### 

projectname=$1
version=$2 #默认master

if [[ $projectname == "" ]]; then
	echo "错误: 请输入新项目名"
	exit 0
fi
if [[ $version == "" ]]; then
	version="master"
fi

### 目录
path=$(cd $(dirname $0); pwd)
path=$path/sophia-b2b-$projectname
echo "当前目录:$path,新项目名:$projectname,脚手架版本:$version"

### 下载项目模板
### rm -rf sophia-b2b-demo-${version}.tar.gz
### curl -O http://10.252.192.3/sophia-public/sophia-b2b-demo/-/archive/${version}/sophia-b2b-demo-${version}.tar.gz
tar -zxvf sophia-b2b-demo-${version}.tar.gz
mv sophia-b2b-demo-${version} sophia-b2b-$projectname
echo "完毕下载模板:sophia-b2b-demo-${version}.tar.gz"

###循环所有文件 替换com.yz.sophia.demo
function loopdic(){
  echo $1
  for f in `ls $1`
  do
    if [ -d $1"/"$f ];then
      loopdic $1"/"$f
    else
      local path2=$1"/"$f 
      local name2=$f
	  #if [[ $path2 == *client.sh ]]; then echo '打印$path2' ;fi
	  if [[ ($path2 == *.java) || ($path2 == *.xml) || ($path2 == *.properties) || ($path2 == *.md) ]]; then   
		 echo "扫描文件: ${path2}"
		  sed -i "s/com.yz.sophia.demo/com.yz.sophia.$projectname/g" $path2
		  sed -i "s/sophia-b2b-demo/sophia-b2b-$projectname/g" $path2
		  sed -i "s/swagger.title=DEMO/swagger.title=$projectname/g" $path2
	  fi
	  
    fi
  done
}
loopdic $path
echo "完毕:循环所有文件并替换demo信息"

### 循环替换模块文件夹
dirs=('sophia-b2b-demo-core' 'sophia-b2b-demo-provider' 'sophia-b2b-demo-dao' 'sophia-b2b-demo-service' 'sophia-b2b-demo-api' 'sophia-b2b-demo-task')
for d in ${dirs[@]}
do
    newd=${d/demo/${projectname}}
	echo "扫描文件夹: $path/$d/"
    mv $path/$d/src/main/java/com/yz/sophia/demo $path/$d/src/main/java/com/yz/sophia/$projectname
	mv $path/$d $path/$newd
done
echo "完毕:循环模块文件夹重命名所有demo目录"
### sophia-b2b-demo-core

### sophia-b2b-demo-api


### sophia-b2b-demo-dao


### sophia-b2b-demo-service


### sophia-b2b-demo-task


### sophia-b2b-demo-provider


### sophia-b2b-demo


echo "全部完成！！！享受它把~~~~"

echo "by 车江毅"
