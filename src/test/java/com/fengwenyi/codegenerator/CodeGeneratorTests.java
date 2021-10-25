package com.fengwenyi.codegenerator;

import com.baomidou.mybatisplus.annotation.DbType;
import org.junit.jupiter.api.Test;

/**
 * @author Erwin Feng
 * @since 2020/5/29
 */
public class CodeGeneratorTests {

    @Test
    public void testMySQLCodeGenerator() {
        DbType dbType = DbType.MYSQL;
        String dbUrl = "jdbc:mysql://192.168.16.128:3306/study-spring-boot-mybatis-plus";
        String username = "root";
        String password = "123456";
        String driver = "com.mysql.cj.jdbc.Driver";
        // 表前缀，生成的实体类，不含前缀
        String [] tablePrefixes = {};
        // 表名，为空，生成所有的表
        String [] tableNames = {};
        // 字段前缀
        String [] fieldPrefixes = {};
        // 排除的表名
        String [] excludeTableNames = {};
        // 基础包名
        String packageName = "com.fengwenyi.studyspringbootmybatisplus.db";
        //CommonUtils.execute(dbType, dbUrl, username, password, driver, tablePrefixes, tableNames, packageName, fieldPrefixes, excludeTableNames);
    }

}
