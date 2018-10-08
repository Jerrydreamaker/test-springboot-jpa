package com.iecas.testspringboot.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class HttpAspect {
    //拦截 com.iecas.testspringboot.controller 包下，GirlController类中girlList()方法
    @Pointcut("execution(public * com.iecas.testspringboot.controller.GirlController" +
            ".*(..))")
    public void log(){
    }

    /**
     * 记录访问日志
     * @param joinPoint
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes= (ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        log.info("url={}",request.getRequestURL());
        log.info("method={}",request.getMethod());
        log.info("ip={}",request.getRemoteAddr());
        log.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+
        joinPoint.getSignature().getName());
        log.info("args={}",joinPoint.getArgs());
    }
    //获取返回的结果
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        log.info("response:{}",object.toString());
    }

}
