#!/bin/bash
version=3.5.1.4
mvn clean package -DskipTests
docker build -t fengwenyi/mybatis-plus-code-generator:$version .
docker tag fengwenyi/mybatis-plus-code-generator:$version fengwenyi/mybatis-plus-code-generator:$version
docker push fengwenyi/mybatis-plus-code-generator:$version
git tag -a $version -m "v$version"
git push origin $version