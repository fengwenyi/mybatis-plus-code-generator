# 更新日志

## v3.5.4.1-2 (2023-12-16)

这个版本主要是对前端库 layui 进行版本升级

:arrow_up: Dependency Upgrades

- Upgrade to Spring Boot 2.7.18
- Upgrade to layui 2.9.0

不再提供单独的下载链接！


## v3.5.4.1-1 (2023-11-26)

:star: New Features

- 支持 PostgreSQL
- mapper接口文件命名：I%sMapper, service接口文件命名：IMp%sService, serviceImpl文件命名：Mp%sServiceImpl。
- service 包名改为 mp

:arrow_up: Dependency Upgrades

- Upgrade to Spring Boot 2.7.17
- Upgrade to mybatis-plus-generator 3.5.4.1
- Upgrade to mybatis-plus 3.5.4.1
- Upgrade to JavaLib 2.2.2

:bug: Bug Fixes

- 应该是一处判断错误导致始终无法使用util.Date ([#33](https://github.com/fengwenyi/mybatis-plus-code-generator/pull/33))


## v3.5.2.8

这是一个常规版本升级。

:star: New Features

- 更改日期时间类型选择描述。（之前是 jdk 版本）
- 逻辑删除字段名称：deleted_state。（之前是 delete_state）
- jdk 版本改为 8。（之前是 17，spring boot 3.0.0 会改回17）

:arrow_up: Dependency Upgrades

- Upgrade to Spring Boot 2.7.6
- Upgrade to JavaLib 2.2.2



## v3.5.2.7

2022.06.27 ~ 2022.07.02

:star: New Features

- 控制台提供访问地址日志打印，点击即可访问

:bug: Bug Fixes

- 修复版本校验更新失败的问题 ([#31](https://github.com/fengwenyi/mybatis-plus-code-generator/issues/31))



## v3.5.2.6

2022.06.20 ~ 2022.06.25

:star: New Features

- 配置支持缓存 ([#22](https://github.com/fengwenyi/mybatis-plus-code-generator/issues/22))
- 优化 Dao 文件名，去掉前缀 `I`
- 优化 Repository 文件名，去掉前缀 `MP`


:arrow_up: Dependency Upgrades

- Upgrade to Spring Boot 2.7.1
- Upgrade to api-spring-boot-starter 1.3.2



## v3.5.2.5

2022.04.22 ~ 2022.06.07

- 【fix】修复版本更新内容可能乱码的问题 [#29](https://github.com/fengwenyi/mybatis-plus-code-generator/issues/29)
- 【Upgrade】Upgrade to Spring Boot 2.7.0
- 【Upgrade】Upgrade to MyBatis Plus 3.5.2
- 【Upgrade】Upgrade to api-spring-boot-starter 1.3.0
- 【Upgrade】Upgrade to mysql8 8.0.29
- 【Upgrade】Upgrade to SQL Server 10.2.1.jre17
- 【Dependency】dependency JavaLib 2.1.6


## v3.5.2.4

2022.04.10 ~ 2022.04.20

- 【修复】修复每次版本升级校验时，最新版不出现弹窗 [#28](https://github.com/fengwenyi/mybatis-plus-code-generator/issues/28)
- 【优化】优化版本检查接口，让用户无感知
- 【升级】api-spring-boot-starter -> 1.2.0

## v3.5.2.3

2022.04.09 ~ 2022.04.10

- 【新增】正式支持配置多个数据源
- 【新增】支持版本更新检查
- 【升级】api-spring-boot-starter -> 1.0.1

## v3.5.2.2

2022.04.03 ~ 2022.04.04

- 【升级】spring boot 2.6.6
- 【升级】mysql8 8.0.28

## v3.5.2.1

2021.11.30 - 2022.03.08

- 【尝鲜】数据库可以配置多个（浏览器刷新会清空）。
- 【优化】docker容器中jar名称改为 `mybatis-plus-code-generator.jar`
- 【优化】打包发布命令自动获取版本
- 【升级】spring boot 2.6.4
- 【升级】MyBatis-Plus-Generator 3.5.2
- 【升级】MyBatis-Plus 3.5.1
- 【升级】beetl 3.10.0.RELEASE
- 【升级】SQL Server 10.2.0.jre17

## v3.5.1.4

2021.11.28

- 【变更】jdk 1.8 -> 17。
- 【变更】端口调整 8080 -> 8899。
- 【新增】恢复支持docker部署。[#21](https://github.com/fengwenyi/mybatis-plus-code-generator/issues/21)
- 【新增】banner显示版本。
- 【修复】修复前端页面解析接口响应提示信息字段不正确([#19](https://github.com/fengwenyi/mybatis-plus-code-generator/issues/19)) 。
- 【修复】修复作者个人网站链接地址不对的问题。
- 【修复】docker形式部署，输出目录指向的是服务器。[#18](https://github.com/fengwenyi/mybatis-plus-code-generator/issues/18)
- 【调整】`可选配置` 和 `表配置` 交换。
- 【优化】界面优化。
- 【优化】优化shell脚本。[#20](https://github.com/fengwenyi/mybatis-plus-code-generator/issues/20)
- 【升级】spring-boot -> 2.6.0。
- 【升级】beetl -> 3.8.1.RELEASE。


## v3.5.1.3

2021-10-21

这是一个BUG修复版本。

- 【变更】不支持docker部署
- 【修复】修复数据库类型前后端参数不一致，导致无法选择数据库类型的问题([#16](https://github.com/fengwenyi/mybatis-plus-code-generator/issues/16))
- 【优化】代码优化，去除没有用到或者多余的代码
- 【变更】逻辑删除字段，delete_status -> delete_state。
- 【移除】删除自定义DbType，改用 `com.baomidou.mybatisplus.annotation.DbType`
- 【升级】spring boot -> 2.5.6。
- 【升级】api-spring-boot-starter -> 1.1.0。
- 【升级】junit -> 1.13.2。

## v3.5.1.2

2021-10-14

- 【新增】新增支持是否开启 `@Mapper` 配置([#5](https://github.com/fengwenyi/mybatis-plus-code-generator/issues/5))
- 【新增】页面增加源码链接
- 【新增】缓存数据库连接信息([#15](https://github.com/fengwenyi/mybatis-plus-code-generator/issues/15))
- 【优化】界面优化
- 【优化】使用必应图片作为背景，每日自动更换
- 【清理】pom.xml
- 【升级】mssql-jdbc -> 9.4.0.jre16
- 【升级】velocity-engine-core -> 2.3
- 【升级】freemarker -> 2.3.31
- 【升级】beetl -> 3.7.0.RELEASE

## v3.5.1.1

2021-09-26

- 【修复】修复上个版本，xml文件无法自定义目录的问题
- 【变动】实体类，开启lombok注解，@Data变更为@Getter和@Setter
- 【优化】重写MyAutoGenerator，与之前版本不兼容
- 【优化】优化boolean处理
- 【升级】mysql-plus-generator -> 3.5.1
- 【升级】mysql-plus -> 3.4.3.4
- 【升级】mysql8 -> 8.0.26
- 【升级】mysql5 -> 5.1.49
- 【升级】spring-boot -> 2.5.5


## v3.5.0.3

- 【修复】修复关闭字段注解无效的问题。([#13](https://github.com/fengwenyi/mybatis-plus-code-generator/issues/13))
- 【新增】服务docker化。([#12](https://github.com/fengwenyi/mybatis-plus-code-generator/issues/12))
- 【升级】spring-boot 2.5.4
- 【升级】api-spring-boot-starter 1.0.1

## v3.5.0.2

- 【新增】新增忽略字段，继承父类的字段不再生成
- 【修复】修复开启swagger支持报错问题([#9](https://github.com/fengwenyi/mybatis-plus-code-generator/issues/9))
- 【修复】修复开启lombok却不生效的问题([#10](https://github.com/fengwenyi/mybatis-plus-code-generator/issues/10))

## v3.5.0.1

- mybatis-plus-generator版本升级到3.5.0
- 生成器的代码重构，MyAutoGenerator
- 更新阿里云Maven仓库地址
- 引入 api-spring-boot-starter 依赖
- 删除 CommonUtils
- 删除全局异常处理，由 api-spring-boot-starter 处理
- 删除业务异常(BizException)，改为 api-spring-boot-starter 的 ApiException
- 新增debug日志打印

## v3.4.1-3

- 实体类支持lombok配置 #6
- 实体类支持数据库字段配置 #7
- XML自定义配置 #8

## 2021.07.27

- 优化提供的默认值。
- 修复说明文档运行命令不正确的问题。
- 调整数据库信息输入的顺序。
- 数据库密码输入框改为明文。
- 优化说明文档。

## 2021.07.26

- 提供更多配置。
- 优化界面。
- 加入banner。

## 2021.07.13

- 通过UI界面录入数据库参数生成代码。