package com.fengwenyi.codegenerator.vo;

import lombok.Data;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-04-10
 */
@Data
public class VersionResponseVo {

    private String latestVersion;
    private String content;
    private String releaseUrl;
    private String downloadUrl;
    private Integer upgradeType;

}
