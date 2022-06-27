package com.fengwenyi.codegenerator;

import com.fengwenyi.apistarter.EnableApiStarter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-07-12
 */
@SpringBootApplication
@EnableApiStarter
@Slf4j
public class MyBatisPlusCodeGeneratorApplication {

    public static void main(String[] args) {
        ApplicationContext application = SpringApplication.run(MyBatisPlusCodeGeneratorApplication.class, args);
        Environment env = application.getEnvironment();
        String ip;
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        String port = env.getProperty("server.port");
        String appName = env.getProperty("spring.application.name");
        String path = env.getProperty("server.servlet.context-path");

        String msg = "\n---------------------------------------------------------------------------"
                + "\n\tApplication "+ appName + " is running! Access URLs:"
                + "\n\tLocal: \t\thttp://localhost:" + port
                + "\n\tExternal: \thttp://" + ip + ":" + port
                + "\n---------------------------------------------------------------------------"
                ;

        log.info(msg);
    }

}
