package com.cxgt.commmon.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

/**
 * @Author: 冯冠凯
 * @Description:
 * @Date: Created on 2017/11/16
 * @Version: 1.0
 */
//@Order(1)
//@Aspect
//@Component
public class SimpleLogAspect {

    private static final Logger logger = Logger.getLogger(SimpleLogAspect.class);

    /**
     * @Author: 冯冠凯
     * @Description: 切点为@SimpleLog
     * @Date: Created on 2017/11/23
     * @Version: 1.0
     */
//    @Pointcut("@annotation(com.cxgt.annotaion.SimpleLog)")
    public void execute() {
    }

    /**
     * @Author: 冯冠凯 
     * @Description: 记录@SimpleLog标识的方法的方法名、参数和执行时间(方便上线后查询日志精确到方法)
     * @Date: Created on 2017/11/23
     * @Version: 1.0
     */
//    @Around("execute()")
    public Object aroud(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getTarget().getClass().getName();//获取类名
        String methodName = joinPoint.getSignature().getName();//获取方法名
        Object[] args = joinPoint.getArgs();//获取参数
        long begin = System.currentTimeMillis();
        logger.info(" ---------- Action begin className : " + className + ", methodName : " + methodName + ", args : " + Arrays.asList(args) + "; -----------");
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        logger.info(" className : " + className + " methodName : " + methodName + " 执行时间 : " + (end - begin));
        logger.info(" ---------- Action end className : " + className + ", methodName : " + methodName + ", result : " + result + "; -----------");
        return result;
    }

    /**
     * @Author: 冯冠凯 
     * @Description: 记录@SimpleLog标识的方法抛出异常之后记录异常并返回null
     * @Date: Created on 2017/11/23
     * @Version: 1.0
     */
//    @AfterThrowing(pointcut = "execute()", throwing = "throwable")
    public Object afterThrowing(JoinPoint joinPoint, Throwable throwable) {
        String className = joinPoint.getTarget().getClass().getName();//获取类名
        String methodName = joinPoint.getSignature().getName();//获取方法名
        Object[] args = joinPoint.getArgs();//获取参数
        String message = throwable.getMessage();
        throwable.printStackTrace();
        logger.error("\"  Action Exception className : " + className + ", methodName : " + methodName + ", args : " + Arrays.asList(args) + " message : " + message + " -----------");
        return null;
    }
}
