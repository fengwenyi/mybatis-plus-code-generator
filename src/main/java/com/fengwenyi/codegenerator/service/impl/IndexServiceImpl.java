package com.fengwenyi.codegenerator.service.impl;

import com.baomidou.mybatisplus.annotation.DbType;
import com.fengwenyi.api.result.ResultTemplate;
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
        DbType dbType = DbType.MYSQL;
        String dbUrl = "jdbc:mysql://" + requestVo.getHost() + "/" + requestVo.getDbName();
        String username = requestVo.getUsername();
        String password = requestVo.getPassword();
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
        String packageName = requestVo.getPackageName();
        CommonUtils.execute(dbType, dbUrl, username, password, driver, tablePrefixes, tableNames, packageName, fieldPrefixes, excludeTableNames);

        return ResultTemplate.success();
    }
}
