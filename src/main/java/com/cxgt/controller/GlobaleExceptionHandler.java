package com.cxgt.controller;

import com.cxgt.commmon.constants.ResultCodeEnum;
import com.cxgt.commmon.exception.PassportValidateException;
import com.cxgt.commmon.util.ResultUtil;
import com.cxgt.commmon.vo.Result;
import org.apache.log4j.Logger;
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

    private static final Logger LOG = Logger.getLogger(GlobaleExceptionHandler.class);

    /**
     * @author: Gallrax
     * @Description: 没有权限访问抛的异常
     * @date: 2018/5/26 14:56
     * @param:
     * @return:
     */
    @ExceptionHandler(UnauthorizedException.class)
    public String unauthorizedException(UnauthorizedException e) {
        LOG.error(" unauthorizedException : " + e.getMessage());
//        e.printStackTrace();
        return "redirect:/admin/login.html";
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
        LOG.error(" unauthenticatedException : " + e.getMessage());
//        e.printStackTrace();
        return "redirect:/admin/login.html";
    }

    @ExceptionHandler(PassportValidateException.class)
    public String passportValidateException(PassportValidateException e) {
        LOG.error(" Passport validate is not pass !");
        //此处许判断是否为ajax请求
        return null;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result exception(Exception e) {
        e.printStackTrace();
        return ResultUtil.fail(ResultCodeEnum.UNAUTHORIZED);
    }
}
