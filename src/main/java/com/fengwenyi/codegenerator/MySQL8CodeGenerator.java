package com.fengwenyi.codegenerator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.fengwenyi.codegenerator.util.CommonUtils;

/**
 * MySQL 数据库代码生成类
 * @author Erwin Feng[xfsy_2015@163.com]
 * @since 2019-04-17 10:33
 */
public class MySQL8CodeGenerator {

    public static void main(String[] args) {
        DbType dbType = DbType.MYSQL;
        String dbUrl = "jdbc:mysql://localhost:3306/db-name";
        String username = "root";
        String password = "123456";
        String driver = "com.mysql.cj.jdbc.Driver";
        // 表前缀，生成的实体类，不含前缀
        String [] tablePrefixs = {"t_"};
        // 表名，为空，生成所有的表
        String [] tableNames = {};
        // 基础包名
        String packageName = "com.example.module_name.db";
        CommonUtils.execute(dbType, dbUrl, username, password, driver, tablePrefixs, tableNames, packageName);
    }

}
