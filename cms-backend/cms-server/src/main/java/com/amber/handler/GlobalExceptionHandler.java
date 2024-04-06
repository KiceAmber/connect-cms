package com.amber.handler;

import com.amber.constant.MessageConstant;
import com.amber.exception.BaseException;
import com.amber.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理器，处理项目中抛出的业务异常
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 捕获业务异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler
    public Result exceptionHandler(BaseException ex) {
        log.error("异常信息：{}", ex.getMessage());
        return Result.error(ex.getMessage());
    }

    /**
     * 处理 SQL 唯一键重复异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler
    public Result exceptionHandler(SQLIntegrityConstraintViolationException ex) {
        // 对创建了 unique index 的字段进行处理
        String message = ex.getMessage();
        if (message.contains("Duplicate entry")) {
            String[] str = message.split(" ");
            String username = str[2];
            String msg = username + MessageConstant.COMMON_ALREADY_EXISTS;
            return Result.error(msg);
        } else {
            return Result.error(MessageConstant.COMMON_UNKNOWN_ERROR);
        }
    }
}