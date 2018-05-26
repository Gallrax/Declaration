package com.cxgt.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Gallrax
 * @Description:
 * @Date: 2018/5/26
 */
@ControllerAdvice
public class GlobaleExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String exception(Exception e) {
        e.printStackTrace();
        return null;
    }
}
