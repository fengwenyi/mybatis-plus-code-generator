:: #!/bin/bash
version=3.5.2.7
echo $version
jdk17
mvn clean package -DskipTests
docker build -t fengwenyi/mybatis-plus-code-generator .
docker tag fengwenyi/mybatis-plus-code-generator fengwenyi/mybatis-plus-code-generator
docker push fengwenyi/mybatis-plus-code-generator
git tag -a $version -m "v$version"
git push origin $version