package org.example.demoforjjavaspringbootgradleone.aop;


import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.example.demoforjjavaspringbootgradleone.vo.AccountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@Slf4j
@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice implements ResponseBodyAdvice<Object> {

    @Autowired
    HttpServletRequest httpServletRequest;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        String requestURI = httpServletRequest.getRequestURI();
        if(requestURI.contains("/v2.0/service/")
                ||requestURI.contains("/v2.0/account/")
                ||requestURI.contains("/v2.0/terms/")){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        Object obj = new Object();
        log.debug("check body ::: "+body.getClass().getName());
        String bodyName = body.getClass().getName();

        if(body instanceof AccountVo) {

            return obj;
        }else{
            return body;
        }
    }

}