#!/bin/bash
mvn clean package -DskipTests
git tag -a 3.5.1.3 -m 'v3.5.1.3'
git push origin 3.5.1.3