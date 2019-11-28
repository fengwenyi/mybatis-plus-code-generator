# MyBatis-Plus 代码生成器

## 概述

代码生成器，又被叫做逆向工程，MyBatis官方为了推广，自己也写了一个，我之前也使用这个，功能也是非常强大，强大以为支持自定义配置，那么问题来了，我该怎么配置才合理呢，所以，有人把所有的配置项都弄成中文的，还有人开发了生成插件，这些在我以往的博文中都看看到。MyBatis-Plus的代码生成器到底怎么样，这我就不评判了，我就这样说，用用看吧。

在MyBatis-Plus的官网文档中，有将代码生成器的问题，有配置详解，也有项目示例代码，复制来就可用。

我这次是用MP 3.0.1，也就是最新版，官方还没有更新呢，所以，我去找了很久的源码，才将这个完成，勉强适合自己的了。这个在 `CodeGenerator` Module中，可以下下下来，导入到IDE中，看一下，修改配置就能运行。有问题，也可以与我讨论。

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

## 使用方法

第一步：Git 克隆
```
# 克隆下
git clone ...
```

第二步：IDEA导入

第三步：MySQL:MySQL8CodeGenerator

第三步：Oracle:OracleCodeGenerator

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
String packageName = "com.example.module_name.db";
```
