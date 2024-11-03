package org.example.demoforjjavaspringbootgradleone.vo;

import java.util.List;

public class UserIdListVo {

    String userId;
    String idType;
    String displayUserId;

    /* getter */

    public String getUserId() {
        return userId;
    }

    public String getIdType() {
        return idType;
    }

    public String getDisplayUserId() {
        return displayUserId;
    }

    /* setter */

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public void setDisplayUserId(String displayUserId) {
        this.displayUserId = displayUserId;
    }
}
