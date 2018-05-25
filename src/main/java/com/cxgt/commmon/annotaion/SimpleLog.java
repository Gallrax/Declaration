package com.cxgt.commmon.annotaion;

import java.lang.annotation.*;

/**
 * @Author: 冯冠凯
 * @Description: 简单日志记录进入的每个方法名，该方法执行时间
 * @Date: Created on 2017/11/16
 * @Version: 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SimpleLog {
}
