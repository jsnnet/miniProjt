package org.example.demoforjjavaspringbootgradleone.common;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;

public class BaseController {

    public Map<String, Object> getParams(HttpServletRequest request) {

        Map<String, Object> checkParams = new HashMap<String, Object>();

        checkParams.put("userNm", request.getParameter("first_name"));
        checkParams.put("mobileNo", request.getParameter("mobi_no"));

        /* 이메일 아이디 */
        checkParams.put("oriUserId", request.getParameter("curr_email_addr"));
        checkParams.put("oriIdTpCd", request.getParameter("id_tp_code"));

        /* 휴대폰 아이디 */
        checkParams.put("userId", request.getParameter("email_addr"));
        checkParams.put("idTpCd", request.getParameter("add_id_tp_code"));

        return checkParams;
    }

}
