package com.fengwenyi.codegenerator.service.impl;

import com.baomidou.mybatisplus.annotation.DbType;
import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.codegenerator.bo.CodeGeneratorBo;
import com.fengwenyi.codegenerator.service.IIndexService;
import com.fengwenyi.codegenerator.util.CommonUtils;
import com.fengwenyi.codegenerator.vo.CodeGeneratorRequestVo;
import org.springframework.stereotype.Service;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-07-12
 */
@Service
public class IndexServiceImpl implements IIndexService {
    @Override
    public ResultTemplate<Void> codeGenerator(CodeGeneratorRequestVo requestVo) {

        Integer dbTypeCode = requestVo.getDbType();

        DbType dbType;
        String dbUrl;
        String username = requestVo.getUsername();
        String password = requestVo.getPassword();
        String driver;

        if (dbTypeCode == null || dbTypeCode == 1) {
            // mysql
            dbType = DbType.MYSQL;
            dbUrl = "jdbc:mysql://" + requestVo.getHost() + "/" + requestVo.getDbName();
            driver = "com.mysql.cj.jdbc.Driver";
        } else if (dbTypeCode == 2) {
            dbType = DbType.ORACLE;
            dbUrl = "jdbc:oracle:thin:@" + requestVo.getHost() + ":" + requestVo.getDbName();
            driver = "oracle.jdbc.OracleDriver";
        } else if (dbTypeCode == 3){
            dbType = DbType.SQL_SERVER;
            dbUrl = "jdbc:sqlserver://" + requestVo.getHost() + ";DatabaseName=" + requestVo.getDbName();
            driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        } else {
            return ResultTemplate.fail("暂不支持的数据库类型");
        }

        // 表前缀，生成的实体类，不含前缀
        String [] tablePrefixes = {};
        // 表名，为空，生成所有的表
        String [] tableNames = {};
        // 字段前缀
        String [] fieldPrefixes = {};
        // 排除的表名
        String [] excludeTableNames = {};
        // 基础包名
        String packageName = requestVo.getPackageName();

        CodeGeneratorBo bo = new CodeGeneratorBo()
                .setDbType(dbType)
                .setDbUrl(dbUrl)
                .setUsername(username)
                .setPassword(password)
                .setDriver(driver)
                .setTablePrefixes(tablePrefixes)
                .setTableNames(tableNames)
                .setPackageName(packageName)
                .setFieldPrefixes(fieldPrefixes)
                .setExcludeTableNames(excludeTableNames)
                ;

        return execute(bo);

    }

    private ResultTemplate<Void> execute(CodeGeneratorBo bo) {
        try {
            DbType dbType = bo.getDbType();
            String dbUrl = bo.getDbUrl();
            String username = bo.getUsername();
            String password = bo.getPassword();
            String driver = bo.getDriver();
            String [] tablePrefixes = bo.getTablePrefixes();
            String [] tableNames = bo.getTableNames();
            String packageName = bo.getPackageName();
            String [] fieldPrefixes = bo.getFieldPrefixes();
            String [] excludeTableNames = bo.getExcludeTableNames();
            CommonUtils.execute(dbType, dbUrl, username, password, driver, tablePrefixes, tableNames, packageName, fieldPrefixes, excludeTableNames);
            return ResultTemplate.success();
        } catch (Exception ignored) {

        }
        return ResultTemplate.fail();
    }
}
