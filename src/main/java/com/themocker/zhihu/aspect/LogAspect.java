package com.themocker.zhihu.aspect;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);
    @Before("execution(* com.themocker.zhihu.controller.*Controller.*(..))")
    public void beforeMethod(){
            logger.info("before");
    }

    @After("execution(* com.themocker.zhihu.controller.IndexController.*(..))")
    public void afterMethod(){
            logger.info("after");
    }

}
