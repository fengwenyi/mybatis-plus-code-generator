FROM openjdk:8-jdk-alpine
MAINTAINER Erwin Feng xfsy_2015@163.com
COPY target/mybatis-plus-code-generator-*.jar mybatis-plus-code-generator.jar
ENTRYPOINT ["sh", "-c", "java -jar mybatis-plus-code-generator.jar"]