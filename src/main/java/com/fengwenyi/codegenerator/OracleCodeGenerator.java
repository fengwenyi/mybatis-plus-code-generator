package com.fengwenyi.codegenerator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.fengwenyi.codegenerator.util.CommonUtils;

/**
 * @author Erwin Feng
 * @since 2019-04-17 10:33
 */
public class OracleCodeGenerator {

    public static void main(String[] args) {
        DbType dbType = DbType.ORACLE;
        String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "username";
        String password = "password";
        String driver = "oracle.jdbc.OracleDriver";
        // 表前缀，生成的实体类，不含前缀
        String [] tablePrefixs = {""};
        // 表名，为空，生成所有的表
        String [] tableNames = {""};
        // 基础包名
        String packageName = "com.example";
        CommonUtils.execute(dbType, dbUrl, username, password, driver, tablePrefixs, tableNames, packageName);
    }

}
