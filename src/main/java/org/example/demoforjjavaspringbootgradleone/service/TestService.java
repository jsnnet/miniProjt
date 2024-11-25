package org.example.demoforjjavaspringbootgradleone.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TestService {

    public Map<String,Object> testAfterAspect(){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", "200");
        result.put("msg", "success");
        result.put("usrId", "+917428730894");
        return result;
    }
}
