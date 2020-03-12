#!/bin/bash
echo "正在下载配置包..."
rm -rf jenkins-client-1.0-SNAPSHOT.jar
curl -O http://10.252.192.3/sophia-public/jenkins-client/raw/master/doc/jenkins-client-1.0-SNAPSHOT.jar
echo "准备运行配置包..."
java -jar -Dfile.encoding=utf-8 jenkins-client-1.0-SNAPSHOT.jar
rm -rf jenkins-client-1.0-SNAPSHOT.jar