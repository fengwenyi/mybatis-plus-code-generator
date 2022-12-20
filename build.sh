#!/bin/bash
version=`awk '/<version>[^<]+<\/version>/{gsub(/<version>|<\/version>/,"",$1);print $1;exit;}' pom.xml`
echo $version
#jdk17
mvn clean package -DskipTests
docker build -t fengwenyi/mybatis-plus-code-generator .
docker tag fengwenyi/mybatis-plus-code-generator fengwenyi/mybatis-plus-code-generator
docker push fengwenyi/mybatis-plus-code-generator
git tag -a $version -m "v$version"
git push origin $version