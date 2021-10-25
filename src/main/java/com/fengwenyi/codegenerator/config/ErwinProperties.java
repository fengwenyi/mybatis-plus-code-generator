package com.fengwenyi.codegenerator.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-10-25
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties("erwin")
public class ErwinProperties {

    /**
     * 启动方式
     */
    private String startMethod;

}
