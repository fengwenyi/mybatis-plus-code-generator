# MyBatis-Plus 代码生成器

## 概述

代码生成器，又被叫做逆向工程，MyBatis官方为了推广，自己也写了一个，我之前也使用这个，功能也是非常强大，强大以为支持自定义配置，那么问题来了，我该怎么配置才合理呢，所以，有人把所有的配置项都弄成中文的，还有人开发了生成插件，这些在我以往的博文中都看看到。MyBatis-Plus的代码生成器到底怎么样，这我就不评判了，我就这样说，用用看吧。

在MyBatis-Plus的官网文档中，有将代码生成器的问题，有配置详解，也有项目示例代码，复制来就可用。

我这次是用MP 3.3.1，也就是最新版，官方还没有更新呢，所以，我去找了很久的源码，才将这个完成，勉强适合自己的了。这个在 `CodeGenerator` Module中，可以下下下来，导入到IDE中，看一下，修改配置就能运行。有问题，也可以与我讨论。

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

* [ ] ......

## 目录结构

```
.
├── README.md
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── fengwenyi
    │   │           └── codegenerator
    │   │               ├── Config.java
    │   │               ├── MySQL8CodeGenerator.java
    │   │               ├── OracleCodeGenerator.java
    │   │               └── util
    │   │                   └── CommonUtils.java
    │   └── resources
    └── test
        └── java
```

## 支持的数据库

* [x] MySQL

* [x] Oracle

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

```
String dbUrl = "jdbc:mysql://localhost:3306/dbName";
String username = "dbUsername";
String password = "dbPassword";
String driver = "com.mysql.cj.jdbc.Driver";
// 表前缀，生成的实体类，不含前缀
String [] tablePrefixes = {};
// 表名，为空，生成所有的表
String [] tableNames = {};
// 字段前缀
String [] fieldPrefixes = {};
// 基础包名
String packageName = "com.example.module.db";
```

## 更多配置

```java
package com.fengwenyi.codegenerator;

/**
 * @author Erwin Feng
 * @since 2019-04-17 12:04
 */
public class Config {

    /** 包名：controller */
    public static final String PACKAGE_NAME_CONTROLLER = "controller";

    /** 包名：service */
    public static final String PACKAGE_NAME_SERVICE = "service";

    /** 包名：service.impl */
    public static final String PACKAGE_NAME_SERVICE_IMPL = "service.impl";

    /** 包名：model */
    public static final String PACKAGE_NAME_MODEL = "model";

    /** 包名：dao */
    public static final String PACKAGE_NAME_DAO = "dao";

    /** 包名：xml */
    public static final String PACKAGE_NAME_XML = "mapper";

    /** 文件名后缀：Model */
    public static final String FILE_NAME_MODEL = "%sModel";

    /** 文件名后缀：Dao */
    public static final String FILE_NAME_DAO = "%sDao";

    /** 文件名后缀：Mapper */
    public static final String FILE_NAME_XML = "%sMapper";

    /** MP开头，Service结尾 */
    public static final String FILE_NAME_SERVICE = "MP%sService";

    /** 文件名后缀：ServiceImpl */
    public static final String FILE_NAME_SERVICE_IMPL = "%sServiceImpl";

    /** 文件名后缀：Controller */
    public static final String FILE_NAME_CONTROLLER = "%sController";


    /** 作者 */
    public static final String AUTHOR = "Erwin Feng";

    /** 生成文件的输出目录 */
    public static String projectPath = System.getProperty("user.dir");

    /** 输出目录 */
//    public static final String outputDir = projectPath + "/src/main/java";
    public static final String outputDir = "/Users/code-generator";

}
```

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
