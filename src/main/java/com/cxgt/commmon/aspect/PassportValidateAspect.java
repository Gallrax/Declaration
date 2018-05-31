package com.cxgt.commmon.aspect;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.extra.servlet.ServletUtil;
import com.cxgt.commmon.exception.PassportValidateException;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 冯冠凯
 * @Description: passport验证
 * @Date: Created on 2018/05/28
 * @Version: 1.0
 */
@Order(1)
@Aspect
@Component
public class PassportValidateAspect {

    private static final Logger logger = Logger.getLogger(PassportValidateAspect.class);

    /**
     * @Author: 冯冠凯
     * @Description: 切点为@SimpleLog
     * @Date: Created on 2017/11/23
     * @Version: 1.0
     */
    @Pointcut("@annotation(com.cxgt.commmon.annotaion.PassportValidate)")
    public void execute() {
    }

    /**
     * @Author: 冯冠凯
     * @Description: 过滤cookie中是否包含uid(初始设置)
     * @Date: Created on 2017/11/23
     * @Version: 1.0
     */
    @Around("execute()")
    public Object aroud(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Cookie cookie = ServletUtil.getCookie(request, "uid");
//        if (ObjectUtil.isNull(cookie)) throw new PassportValidateException();
        return joinPoint.proceed();
    }

}
