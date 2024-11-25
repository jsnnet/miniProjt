package org.example.demoforjjavaspringbootgradleone.common;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public abstract class BaseController {

    protected Map<String, Object> getRequestParams(HttpServletRequest request) {

        Map<String, Object> checkParams = new HashMap<String, Object>();

        return checkParams;
    }

    public void testingPublicMethod(){
        log.info("================== testingPublicMethod ==================");
    }

}
