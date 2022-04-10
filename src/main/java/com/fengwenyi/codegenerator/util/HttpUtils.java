package com.fengwenyi.codegenerator.util;

import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.util.Objects;

/**
 * Http请求工具类
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-04-10
 */
public class HttpUtils {

    /**
     * Http get 请求
     * @param url 请求 URL
     * @return 返回内容
     */
    public static String get(String url) {
        var request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        var client = HttpClient.newHttpClient();
        HttpResponse<String> response = null;
        try {
            response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString(Charset.defaultCharset()));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        if (Objects.nonNull(response)
                && response.statusCode() == HttpStatus.OK.value()) {
            return response.body();
        }
        return "";
    }

}
