package com.fengwenyi.codegenerator.vo;

import lombok.Data;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-07-12
 */
@Data
public class CodeGeneratorRequestVo {

    private Integer dbType;

    private String host;

    private String username;

    private String password;

    private String dbName;

    private String packageName;

    private String outDir;

}
