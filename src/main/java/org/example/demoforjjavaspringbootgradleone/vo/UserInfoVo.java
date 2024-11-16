package org.example.demoforjjavaspringbootgradleone.vo;

import jdk.jfr.Name;

import java.util.List;

@Name("account")
public class UserInfoVo {

    String userNo;
    String userName;
    String userId;
    String idType;
    String mobileNumber;
    String emailAddress;
    List<UserIdListVo> userIdList;

    /* getter */
    public String getUserNo() {
        return userNo;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserId() {
        return userId;
    }

    public String getIdType() {
        return idType;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public List<UserIdListVo> getUserIdList() {
        return userIdList;
    }

    /* setter */
    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setUserIdList(List<UserIdListVo> userIdList) {
        this.userIdList = userIdList;
    }
}
