package com.cxgt.commmon.aspect;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.extra.servlet.ServletUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cxgt.entity.Log;
import com.cxgt.service.LogService;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.jmx.export.assembler.MethodNameBasedMBeanInfoAssembler;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author: 冯冠凯
 * @Description:
 * @Date: Created on 2017/11/16
 * @Version: 1.0
 */
@Order(1)
@Aspect
@Component
public class SimpleLogAspect {

    private static final Logger logger = Logger.getLogger(SimpleLogAspect.class);
    private ThreadLocal<Log> threadLocal = new ThreadLocal<Log>();//防止线程共享log
    @Autowired
    LogService logService;

    /**
     * @Author: 冯冠凯
     * @Description: 切点为@SimpleLog
     * @Date: Created on 2017/11/23
     * @Version: 1.0
     */
    @Pointcut("@annotation(com.cxgt.commmon.annotaion.SimpleLog)")
    public void execute() {
    }

    /**
     * @Author: 冯冠凯
     * @Description: 记录@SimpleLog标识的方法的方法名、参数和执行时间(方便上线后查询日志精确到方法)
     * @Date: Created on 2017/11/23
     * @Version: 1.0
     */
    @Around("execute()")
    public Object aroud(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getTarget().getClass().getName();//获取类名
        String methodName = joinPoint.getSignature().getName();//获取方法名
        Object[] args = joinPoint.getArgs();//获取参数
        long begin = System.currentTimeMillis();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = ServletUtil.getClientIP(request);
        logger.info(" ---------- Controller begin className : " + className + ", methodName : " + methodName + ", args : " + Arrays.asList(args) + "; -----------");
        newLog(className, methodName, Arrays.asList(args).toString(), new Date(begin), ip, 0);//自动放置ThreadLocal
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        setLog(JSON.toJSONString(result), new Date(end), null);//自动设置ThreadLocal中的log
        Long excute = end - begin;
        logger.info(" ---------- Controller end className : " + className + ", methodName : " + methodName + " 执行时间 : " + excute + ", result : " + result + " ; -----------");
        logService.insert(threadLocal.get());
        return result;
    }

    /**
     * @Author: 冯冠凯
     * @Description: 记录@SimpleLog标识的方法抛出异常之后记录异常并返回null
     * @Date: Created on 2017/11/23
     * @Version: 1.0
     */
    @AfterThrowing(pointcut = "execute()", throwing = "throwable")
    public Object afterThrowing(JoinPoint joinPoint, Throwable throwable) {
        String className = joinPoint.getTarget().getClass().getName();//获取类名
        String methodName = joinPoint.getSignature().getName();//获取方法名
        Object[] args = joinPoint.getArgs();//获取参数
        String message = throwable.getMessage();
        throwable.printStackTrace();
        logger.error(" ---------- Controller Exception className : " + className + ", methodName : " + methodName + ", args : " + Arrays.asList(args) + " message : " + message + " -----------");
//        Log log = newLog(className, methodName, new Date(begin), new Date(end), excute.intValue(), 0, null);
//        logService.insert(log);
        setLog(null, new Date(), throwable);//进入异常捕获则说明log已经初始化
        logService.insert(threadLocal.get());
        return null;
    }

    /**
     * @author: Gallrax
     * @Description: 线程内初始化log, 记录执行方法前内容(防止出现异常导致log数据丢失)
     * @date: 2018/5/26 11:48
     * @param:
     * @return:
     */
    private void newLog(String className, String methodName, String param, Date beginTime, String ip, Integer isAdmin) {
        Log log = new Log();
        log.setClassName(className);
        log.setMethodName(methodName);
        log.setParam(param);
        log.setBeginTime(beginTime);
        log.setInsertTime(new Date());
        threadLocal.set(log);
    }

    /**
     * @author: Gallrax
     * @Description: 方法执行结束设置参数, 无论是否抛出异常, log都在threadlocal中，无需担心数据丢失
     * @date: 2018/5/26 11:49
     * @param:
     * @return:
     */
    private void setLog(String result, Date endTime, Throwable throwable) {
        Log log = threadLocal.get();
        log.setResult(result);
        log.setEndTime(endTime);
        long begin = log.getBeginTime().getTime();
        long end = endTime.getTime();
        Long excuteTime = end - begin;
        log.setExcuteTime(excuteTime.intValue());
        if (ObjectUtil.isNotNull(throwable)) {
            log.setException(throwable.toString());
            String json = JSON.toJSONString(Arrays.asList(throwable.getStackTrace()));
            logger.info(json);
            log.setExceptionContent(json);
        }
    }
}
