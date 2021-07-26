package com.fengwenyi.codegenerator.service.impl;

import com.baomidou.mybatisplus.annotation.DbType;
import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.codegenerator.bo.CodeGeneratorBo;
import com.fengwenyi.codegenerator.exception.BizException;
import com.fengwenyi.codegenerator.service.IIndexService;
import com.fengwenyi.codegenerator.util.CommonUtils;
import com.fengwenyi.codegenerator.vo.CodeGeneratorRequestVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-07-12
 */
@Service
@Slf4j
public class IndexServiceImpl implements IIndexService {
    @Override
    public ResultTemplate<Void> codeGenerator(CodeGeneratorRequestVo requestVo) {

        CodeGeneratorBo bo = new CodeGeneratorBo();

        BeanUtils.copyProperties(requestVo, bo);

        handleDb(requestVo, bo);
        handleTable(requestVo, bo);

        return execute(bo);

    }

    private ResultTemplate<Void> execute(CodeGeneratorBo bo) {
        try {
            CommonUtils.execute(bo);
            return ResultTemplate.success();
        } catch (Exception ignored) {

        }
        return ResultTemplate.fail();
    }


    // 处理数据库
    private void handleDb(CodeGeneratorRequestVo requestVo, CodeGeneratorBo bo) {
        DbType dbType;
        String dbUrl;
        String username = requestVo.getUsername();
        String password = requestVo.getPassword();
        String driver;
        if (!StringUtils.hasText(requestVo.getDbTypeName()) || DbType.getDbType(requestVo.getDbTypeName()) == DbType.MYSQL) {
            // mysql
            dbType = DbType.MYSQL;
            dbUrl = "jdbc:mysql://" + requestVo.getHost() + "/" + requestVo.getDbName();
            driver = "com.mysql.cj.jdbc.Driver";
        } else if (DbType.getDbType(requestVo.getDbTypeName()) == DbType.ORACLE) {
            dbType = DbType.ORACLE;
            dbUrl = "jdbc:oracle:thin:@" + requestVo.getHost() + ":" + requestVo.getDbName();
            driver = "oracle.jdbc.OracleDriver";
        } else if (DbType.getDbType(requestVo.getDbTypeName()) == DbType.SQL_SERVER){
            dbType = DbType.SQL_SERVER;
            dbUrl = "jdbc:sqlserver://" + requestVo.getHost() + ";DatabaseName=" + requestVo.getDbName();
            driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        } else {
            throw new BizException("暂不支持的数据库类型");
        }
        bo.setDbType(dbType).setDbUrl(dbUrl).setDriver(driver).setUsername(username).setPassword(password);
    }

    // 处理表
    private void handleTable(CodeGeneratorRequestVo requestVo, CodeGeneratorBo bo) {
        if (StringUtils.hasText(requestVo.getTableNames())) {
            bo.setTableNames(split(requestVo.getTableNames()));
        }
        if (StringUtils.hasText(requestVo.getTablePrefixes())) {
            bo.setTablePrefixes(split(requestVo.getTablePrefixes()));
        }
        if (StringUtils.hasText(requestVo.getFieldPrefixes())) {
            bo.setFieldPrefixes(split(requestVo.getFieldPrefixes()));
        }
        if (StringUtils.hasText(requestVo.getExcludeTableNames())) {
            bo.setExcludeTableNames(split(requestVo.getExcludeTableNames()));
        }
    }

    private String[] split(String value) {
        if (!StringUtils.hasText(value)) {
            return null;
        }
        List<String> valueList = new ArrayList<>();
        String[] values;
        if (value.contains(",")) {
            log.info("逗号分割");
            values = value.split(",");
        } else if (value.contains("\n")) {
            log.info("回车分割");
            values = value.split("\n");
        } else {
            log.info("默认空格分割");
            values = value.split(" ");
        }
        for (String str : values) {
            str = str.trim();
            if (StringUtils.hasText(str)) {
                valueList.add(str);
            }
        }
        String[] result = new String[valueList.size()];
        return  valueList.toArray(result);
    }
}
