# MyBatis-Plus 代码生成器

## Current Version

3.4.1

## 概述

代码生成器，又被叫做逆向工程，MyBatis官方为了推广，自己也写了一个，我之前也使用这个，功能也是非常强大，强大以为支持自定义配置，那么问题来了，我该怎么配置才合理呢，所以，有人把所有的配置项都弄成中文的，还有人开发了生成插件，这些在我以往的博文中都看看到。MyBatis-Plus的代码生成器到底怎么样，这我就不评判了，我就这样说，用用看吧。

**功能列表：**

* [x] 自动生成model类

* [x] 自动生成dao接口

* [x] 自动生成xml文件

* [x] 自动生成service接口
 
* [x] 自动生成service实现类

* [x] model支持Builder模式

* [x] 支持swagger2

* [x] 支持生成数据库字段常量

* [x] 支持生成Kotlin代码

* [x] ……more……

## 目录结构

```
.
├── README.md
├── pom.xml
└── src
    ├── main
    │   └── java
    │       └── com
    │           └── fengwenyi
    │               └── code_generator
    │                   ├── Config.java                      // 自定义配置
    │                   ├── MySQL8CodeGenerator.java         // MySQL代码生成器
    │                   ├── OracleCodeGenerator.java         // Oracle代码生成器
    │                   └── util
    │                       └── CommonUtils.java
    └── test
        └── java
            └── com
                └── fengwenyi
                    └── code_generator
                        └── CodeGeneratorTests                // 代码生成器测试

```

## 支持的数据库

* [x] MySQL

* [x] Oracle
  
* [x] SQL Server

## 快速开始

你只需要三步，就能生成代码

#### 第一步：Git克隆
```
git clone git@github.com:fengwenyi/mybatis-plus-code-generator.git
```

#### 第二步：IDE导入

#### 第三步：简单且必应的配置即可运行

`MySQL`：MySQL8CodeGenerator

`Oracle`：OracleCodeGenerator

## 简单且必要的配置

| 参数名 | 说明 | 示例值 |
| ---   | ---  | ---   |
| dbUrl   | 数据库连接URL  | jdbc:mysql://localhost:3306/dbName   |
| username   | 数据库用户名  | dbUsername   |
| password   | 数据库密码  | dbPassword   |
| driver   | 数据库连接驱动  | com.mysql.cj.jdbc.Driver   |
| tablePrefixes   | 表前缀，生成的实体类，不含前缀  | t   |
| tableNames   | 表名，为空，生成所有的表  | t_user, t_goods, t_order   |
| fieldPrefixes   | 字段前缀  | -   |
| packageName   | 基础包名  | com.example.module.db   |

## 更多配置项

com.fengwenyi.code_generator.Config

| 参数名 | 说明 | 默认值 |
| ---   | ---  | ---   |
|   PACKAGE_NAME_CONTROLLER    |  数据库控制层包名    |     controller  |
|   PACKAGE_NAME_SERVICE    |  数据库服务接口包名    |     repository  |
|   PACKAGE_NAME_SERVICE_IMPL    |  数据库服务接口实现类包名    |     repository.impl  |
|   PACKAGE_NAME_MODEL    |  数据库实体类包名    |     entity  |
|   PACKAGE_NAME_DAO    |  数据库操作接口包名    |     dao  |
|   DIR_NAME_XML    |  MyBatis XML文件夹名称    |     mapper  |
|   FILE_NAME_MODEL    |  数据库实体类文件名后缀    |     %sEntity  |
|   FILE_NAME_DAO    |  数据库操作接口文件名后缀    |     I%sDao  |
|   FILE_NAME_XML    |  MyBatis XML文件名后缀    |     %sMapper  |
|   FILE_NAME_SERVICE    |  数据库服务接口文件名后缀    |     MP%sRepository  |
|   FILE_NAME_SERVICE_IMPL    |  数据库服务接口实现类文件名后缀    |     %sRepositoryImpl  |
|   FILE_NAME_CONTROLLER    |  数据库控制层文件名后缀    |     %sController  |
|   FIELD_LOGIC_DELETE_NAME    |  逻辑删除字段名称    |     delete_status  |
|   FIELD_VERSION_NAME    |  乐观锁字段名称    |     version  |
|   AUTHOR    |  类注释作者    |     Erwin Feng  |
|   PROJECT_PATH    |  工程路径    |     System.getProperty("user.dir")  |
|   OUTPUT_DIR    |  生成的文件路径    |     PROJECT_PATH + "/temp/code-generator"  |
|   TEMPLATE_ENGINE    |  模板引擎。velocity / freemarker / beetl    |     velocity  |
|   SWAGGER_SUPPORT    |  生成的实体类是否支持Swagger    |     false  |


## 注意事项

1、关于指定生成的表名

```
// 表名，为空，生成所有的表
String [] tableNames = {};

// 表名，具体表名
String [] tableNames = {"table"};

// 表名，多张表
String [] tableNames = {"table1", "table1"};

// 注意：生成多张表时，不能写成
String [] tableNames = {""};
```

2、包名

```
// 基础包名
// 这是基础包名，会在后面加dao/model/service等包名
String packageName = "com.example.module.db";
```

3、数据库操作服务接口默认以 `MP` 为前缀，如：`MPUserService`

4、报错 `Error java: 错误；不支持发行版5`

解决办法：

将 `Java Compiler` 下 `module` 对应的 `java` 版本改成 `8+`
