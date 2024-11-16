package org.example.demoforjjavaspringbootgradleone.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.coyote.BadRequestException;

import org.example.demoforjjavaspringbootgradleone.common.BaseController;
import org.example.demoforjjavaspringbootgradleone.utility.ValidMoblNo;
import org.example.demoforjjavaspringbootgradleone.vo.AccountVo;
import org.example.demoforjjavaspringbootgradleone.vo.UserIdListVo;

import org.example.demoforjjavaspringbootgradleone.vo.UserInfoVo;
import org.json.simple.JSONObject;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FirstController extends BaseController {

    @PostMapping("/v2.0/service/user/mobile")
    public UserInfoVo firstController(HttpServletRequest request, HttpServletResponse response) {

        Map<String, Object> req = this.getParams(request);
        //AccountVo userInfo = new AccountVo();
        UserInfoVo userInfo = new UserInfoVo();
        List<UserIdListVo> userIdListVo = new ArrayList<>();
        UserIdListVo emailIdInfo = new UserIdListVo();
        UserIdListVo mobileIdInfo = new UserIdListVo();

        try {

            /* 휴대폰 번호 검증 */
            //if(ValidMoblNo.isPhoneNumberId((String) req.get("userId"))){

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

            //}else{
            //    throw new BadRequestException();
            //}

        }catch(Exception e) {

        }

        return userInfo;

    }
}
