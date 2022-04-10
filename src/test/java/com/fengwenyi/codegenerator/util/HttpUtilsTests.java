package com.fengwenyi.codegenerator.util;

import org.junit.jupiter.api.Test;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-04-10
 */
public class HttpUtilsTests {

    @Test
    public void testGet() {
        /*String result = HttpUtils.get("https://www.baidu.com");
        System.out.println(result);*/
        String result = HttpUtils.get("https://erwin-api.fengwenyi.com/erwin/blog/page?currentPage=1&pageSize=10");
        System.out.println(result);
    }

}
