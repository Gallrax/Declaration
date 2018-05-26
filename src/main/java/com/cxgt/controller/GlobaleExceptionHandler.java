package com.cxgt.controller;

import com.cxgt.entity.Log;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
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

    private static final Logger logger = Logger.getLogger(GlobaleExceptionHandler.class);

    /**
     * @author: Gallrax
     * @Description: 没有权限访问抛的异常
     * @date: 2018/5/26 14:56
     * @param:
     * @return:
     */
    @ExceptionHandler(UnauthorizedException.class)
    public String unauthorizedException(UnauthorizedException e) {
        logger.error(" unauthorizedException : " + e.getMessage());
//        e.printStackTrace();
        return "admin/login/login";
    }

    /**
     * @author: Gallrax
     * @Description: 没有登陆认证抛的异常
     * @date: 2018/5/26 14:56
     * @param:
     * @return:
     */
    @ExceptionHandler(UnauthenticatedException.class)
    public String unauthenticatedException(UnauthenticatedException e) {
        logger.error(" unauthenticatedException : " + e.getMessage());
//        e.printStackTrace();
        return "admin/login/login";
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String exception(Exception e) {
        e.printStackTrace();
        return null;
    }
}
