package com.fengwenyi.codegenerator.bo;

import com.baomidou.mybatisplus.annotation.DbType;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-07-14
 */
@Data
@Accessors(chain = true)
public class CodeGeneratorBo {

    private DbType dbType;
    private String dbUrl;
    private String username;
    private String password;
    private String driver;
    private String [] tablePrefixes;
    private String [] tableNames;
    private String packageName;
    private String [] fieldPrefixes;
    private String [] excludeTableNames;
    
}
