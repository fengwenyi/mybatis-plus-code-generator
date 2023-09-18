package com.fengwenyi.codegenerator.service.impl;

import com.baomidou.mybatisplus.annotation.DbType;
import com.fengwenyi.api.result.ResponseTemplate;
import com.fengwenyi.apistarter.utils.Asserts;
import com.fengwenyi.codegenerator.bo.CodeGeneratorBo;
import com.fengwenyi.codegenerator.generator.MyAutoGenerator;
import com.fengwenyi.codegenerator.service.IIndexService;
import com.fengwenyi.codegenerator.vo.CodeGeneratorRequestVo;
import com.fengwenyi.javalib.http.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
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
    public ResponseTemplate<Void> codeGenerator(CodeGeneratorRequestVo requestVo) {

        CodeGeneratorBo bo = new CodeGeneratorBo();

        BeanUtils.copyProperties(requestVo, bo);

        handleDb(requestVo, bo);
        handleTable(requestVo, bo);

        return execute(bo);

    }

    @Override
    public String upgrade(String version) {
        String url = "https://erwin-api.fengwenyi.com/erwin/app/upgrade?" +
                "appCode=mybatis-plus-code-generator&version=" + version;
        return HttpUtils.get(url);
    }

    private ResponseTemplate<Void> execute(CodeGeneratorBo bo) {
        try {
            new MyAutoGenerator(bo).execute();
            return ResponseTemplate.success();
        } catch (Exception e) {
            String errMsg = ExceptionUtils.getStackTrace(e);
            log.error(errMsg);
        }
        return ResponseTemplate.fail();
    }


    // 处理数据库
    private void handleDb(CodeGeneratorRequestVo requestVo, CodeGeneratorBo bo) {
        String dbUrl = "";
        String username = requestVo.getUsername();
        String password = requestVo.getPassword();
        String driver = "";
        if (!StringUtils.hasText(requestVo.getDbTypeName())
                || DbType.getDbType(requestVo.getDbTypeName()) == DbType.MYSQL) {
            // mysql
            dbUrl = "jdbc:mysql://" + requestVo.getHost() + "/" + requestVo.getDbName();
            driver = "com.mysql.cj.jdbc.Driver";
        } else if (DbType.getDbType(requestVo.getDbTypeName()) == DbType.ORACLE) {
            dbUrl = "jdbc:oracle:thin:@" + requestVo.getHost() + ":" + requestVo.getDbName();
            driver = "oracle.jdbc.OracleDriver";
        } else if (DbType.getDbType(requestVo.getDbTypeName()) == DbType.SQL_SERVER){
            dbUrl = "jdbc:sqlserver://" + requestVo.getHost() + ";DatabaseName=" + requestVo.getDbName();
            driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        } else if (DbType.getDbType(requestVo.getDbTypeName()) == DbType.POSTGRE_SQL) {
            dbUrl = "jdbc:postgresql://" + requestVo.getHost() + "/" + requestVo.getDbName();
            driver = "org.postgresql.Driver";
        } else {
            Asserts.fail("暂不支持的数据库类型");
        }
        bo.setDbUrl(dbUrl).setDriver(driver).setUsername(username).setPassword(password);
    }

    // 处理表
    private void handleTable(CodeGeneratorRequestVo requestVo, CodeGeneratorBo bo) {
        bo
                .setTableNames(split(requestVo.getTableNames()))
                .setTablePrefixes(split(requestVo.getTablePrefixes()))
                .setFieldPrefixes(split(requestVo.getFieldPrefixes()))
                .setExcludeTableNames(split(requestVo.getExcludeTableNames()))
                .setIgnoreColumns(split(requestVo.getIgnoreColumns()))
        ;
    }

    private String[] split(String value) {
        if (!StringUtils.hasText(value)) {
            return new String[]{};
        }
        List<String> valueList = new ArrayList<>();
        String[] values;
        if (value.contains(",")) {
            values = value.split(",");
        } else if (value.contains("\n")) {
            values = value.split("\n");
        } else {
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
