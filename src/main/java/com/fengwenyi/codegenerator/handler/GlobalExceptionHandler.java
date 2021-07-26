package com.fengwenyi.codegenerator.handler;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.codegenerator.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-07-26
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BizException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultTemplate<Void> bizException(BizException e) {
        return ResultTemplate.fail(e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultTemplate<Void> runtimeException(RuntimeException e) {
        String errMsg = ExceptionUtils.getStackTrace(e);
        log.error(errMsg);
        return ResultTemplate.fail("服务异常");
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultTemplate<Void> exception(Exception e) {
        String errMsg = ExceptionUtils.getStackTrace(e);
        log.error(errMsg);
        return ResultTemplate.fail();
    }

}
