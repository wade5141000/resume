package com.sedia.resume.controller;

import com.sedia.resume.exception.ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

    /** 攔截自定義的 exception，轉換成指定的 response 格式 */
    @ExceptionHandler(ApplicationException.class)
    @ResponseStatus(OK)
    public void applicationExceptionHandle(ApplicationException e) {

        // TODO 接到自定義的 exception 後如何處理

    }

    /** 攔截其他所有的 Exception */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public void exceptionHandle(Exception e) throws Exception {
        log.error("發生預期外的錯誤。", e);
        throw e;
    }

}
