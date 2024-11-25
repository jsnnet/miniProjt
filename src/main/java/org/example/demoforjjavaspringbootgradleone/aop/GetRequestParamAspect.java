package org.example.demoforjjavaspringbootgradleone.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.example.demoforjjavaspringbootgradleone.utility.ValidMoblNo;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
@Slf4j
public class GetRequestParamAspect {

    @Before("execution(* org.example.demoforjjavaspringbootgradleone.common.BaseController.*(..)))")
    private Object addCntryNum(){
        Map<String, Object> result = new HashMap<>();



        return null;
    }

    @Around("execution(* org.example.demoforjjavaspringbootgradleone.service.TestService.testAfterAspect(..))")
    public Map<String, Object> testAfterAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        Map<String, Object> result = new HashMap<>();

        try{
            result = (Map<String, Object>) joinPoint.proceed();
        }catch (Exception e){
            e.printStackTrace();
        }

        String editVal = ValidMoblNo.getRidOfCountryNumber("IN", String.valueOf(result.get("usrId")));
        result.put("usrId", editVal);

        return result;
    }

}
