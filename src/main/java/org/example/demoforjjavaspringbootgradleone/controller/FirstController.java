package org.example.demoforjjavaspringbootgradleone.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import org.example.demoforjjavaspringbootgradleone.common.BaseController;
import org.example.demoforjjavaspringbootgradleone.service.TestService;
import org.example.demoforjjavaspringbootgradleone.vo.UserIdListVo;

import org.example.demoforjjavaspringbootgradleone.vo.UserInfoVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class FirstController extends BaseController {

    @Autowired
    TestService testService;

    @PostMapping("/v2.0/service/user/mobile")
    public UserInfoVo firstController(HttpServletRequest request, HttpServletResponse response) {

        Map<String,Object> rst = testService.testAfterAspect();

        log.info("============================ start ============================");
        this.testingPublicMethod();
        log.info("============================ end ============================");

        Map<String, Object> req = this.getRequestParams(request);
        //AccountVo userInfo = new AccountVo();
        UserInfoVo userInfo = new UserInfoVo();
        List<UserIdListVo> userIdListVo = new ArrayList<>();
        UserIdListVo emailIdInfo = new UserIdListVo();
        UserIdListVo mobileIdInfo = new UserIdListVo();

        try {

            userInfo.setUserId((String) req.get("userId"));
            userInfo.setUserName((String) req.get("userNm"));
            userInfo.setMobileNumber((String) req.get("mobileNo"));

            /* userIdList 채우기
            *                   >> 조회 방식 아닌 List 추가 방식으로
            * */
            emailIdInfo.setUserId((String) req.get("oriUserId"));
            emailIdInfo.setIdType((String) req.get("oriIdTpCd"));
            emailIdInfo.setDisplayUserId((String) req.get("oriUserId"));

            mobileIdInfo.setUserId((String) req.get("userId"));
            mobileIdInfo.setIdType((String) req.get("idTpCd"));
            mobileIdInfo.setDisplayUserId((String) req.get("userId"));

            userIdListVo.add(emailIdInfo);
            userIdListVo.add(mobileIdInfo);
            userInfo.setUserIdList(userIdListVo);

        }catch(Exception e) {

        }

        return userInfo;

    }
}
