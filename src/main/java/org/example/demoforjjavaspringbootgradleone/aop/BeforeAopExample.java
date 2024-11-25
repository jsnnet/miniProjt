package org.example.demoforjjavaspringbootgradleone.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
@Slf4j
public class BeforeAopExample {

    @Before("execution(* org.example.demoforjjavaspringbootgradleone.mapper.FirstMapper.*(..))")
    //@Around("org.example.demoforjjavaspringbootgradleone.mapper.FirstMapper.insertFirstData()")
    public void doAccessCheck() {
        log.info("doAccessCheck");
    }
}
