package com.fengwenyi.codegenerator.enums;

import lombok.Getter;
import org.springframework.util.StringUtils;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-08-23
 */
@Getter
public enum DbType {

    MYSQL("mysql", "MySQL")
    , ORACLE("oracle", "Oracle")
    , SQL_SERVER("sql_server", "SQL_SERVER")

    ;

    private final String code;

    private final String desc;

    DbType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static DbType getDbType(String dbName) {
        if (!StringUtils.hasText(dbName)) {
            return null;
        }
        for (DbType dbType : DbType.values()) {
            if (dbType.code.equals(dbName.toLowerCase())) {
                return dbType;
            }
        }
        return null;
    }
}
