#!/bin/bash
mvn clean package -DskipTests
docker build -t fengwenyi/mybatis-plus-code-generator:3.5.0.3 .