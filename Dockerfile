FROM openjdk:17-jdk-alpine
MAINTAINER Erwin Feng xfsy_2015@163.com
COPY target/mybatis-plus-code-generator-*.jar app.jar
ENTRYPOINT ["sh", "-c", "java -jar app.jar"]