package org.example.demoforjjavaspringbootgradleone.aop;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.example.demoforjjavaspringbootgradleone.wrapper.CustomResponseWrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.ContentCachingResponseWrapper;

@Slf4j
@Component
public class CustomInterceptor implements HandlerInterceptor {
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        //CustomResponseWrapper customResponseWrapper = new CustomResponseWrapper(response);
        //String originalResponse = customResponseWrapper.getCaptureResponse();
        //log.info("postHandle response ::: "+originalResponse)//;
        //customResponseWrapper.writeModifiedResponse(originalResponse);

    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception {

        log.info("afterCompletion responsse :::"+ response.getCharacterEncoding());
    }
}
