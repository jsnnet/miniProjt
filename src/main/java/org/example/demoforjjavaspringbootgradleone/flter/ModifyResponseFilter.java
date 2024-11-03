package org.example.demoforjjavaspringbootgradleone.flter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;
import lombok.extern.slf4j.Slf4j;

import org.example.demoforjjavaspringbootgradleone.utility.ValidMoblNo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class ModifyResponseFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("ModifyResponseFilter init()");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        String requestURI = req.getRequestURI();

        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper((HttpServletResponse) response);

        chain.doFilter(request, responseWrapper);

        byte[] respArray = responseWrapper.getContentAsByteArray();
        String respStr = new String(respArray, responseWrapper.getCharacterEncoding());
        Map oriResp = new ObjectMapper().readValue(respStr, Map.class);

        log.info("Country Info ::: "+req.getHeader("X-Device-Country"));


        if(!req.getHeader("X-Device-Country").equals("KR")
                // && !jsonStr.equals("{}")
        ) {

            JSONObject jsonObject = new JSONObject(oriResp);
            log.info("[{}] ModifyResponseFilter doFilter newResp", jsonObject);

            String jsonStr = jsonObject.toJSONString();

            /* API Response 변경 */
            String replaceStr = ValidMoblNo.getRidOfCountryNumber(req.getHeader("X-Device-Country"),jsonStr);
            log.info("Updated Result : " + replaceStr);

            response.setContentType("application/json");
            response.getOutputStream().write(replaceStr.getBytes());

        }else{

            /* API Response 유지 */
            String newResp = new ObjectMapper().writeValueAsString(oriResp);
            log.info("[{}] ModifyResponseFilter doFilter newResp", newResp);
            responseWrapper.copyBodyToResponse();
        }
    }

    @Override
    public void destroy() {
        log.info("ModifyResponseFilter destroy()");
    }
}
