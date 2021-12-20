#!/bin/bash
version=`awk '/<version>[^<]+<\/version>/{gsub(/<version>|<\/version>/,"",$1);print $1;exit;}' pom.xml`
echo $version
mvn clean package -DskipTests
docker build -t fengwenyi/mybatis-plus-code-generator:$version .
docker tag fengwenyi/mybatis-plus-code-generator:$version fengwenyi/mybatis-plus-code-generator:$version
docker push fengwenyi/mybatis-plus-code-generator:$version
git tag -a $version -m "v$version"
git push origin $version