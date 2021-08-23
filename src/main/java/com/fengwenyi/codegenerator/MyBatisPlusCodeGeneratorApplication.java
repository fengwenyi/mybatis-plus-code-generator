package com.fengwenyi.codegenerator;

import com.fengwenyi.apistarter.EnableApiStarter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-07-12
 */
@SpringBootApplication
@EnableApiStarter
public class MyBatisPlusCodeGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBatisPlusCodeGeneratorApplication.class, args);
    }

}
