#!/bin/bash
mvn clean package -DskipTests
docker build -t fengwenyi/mybatis-plus-code-generator:3.5.1.3 .
docker tag fengwenyi/mybatis-plus-code-generator:3.5.1.3 fengwenyi/mybatis-plus-code-generator:3.5.1.3
docker push fengwenyi/mybatis-plus-code-generator:3.5.1.3
git tag -a 3.5.1.3 -m 'v3.5.1.3'
git push origin 3.5.1.3