# 更新日志

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