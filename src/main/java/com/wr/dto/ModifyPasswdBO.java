package com.wr.dto;

import java.io.Serializable;

/**
 * Created by 文歌 on 2017/9/9.
 */
public class ModifyPasswdBO implements Serializable{
    private static final long serialVersionUID = 5893728521970179809L;
    private String userId;
    private String originalPasswd;
    private String newPasswd;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOriginalPasswd() {
        return originalPasswd;
    }

    public void setOriginalPasswd(String originalPasswd) {
        this.originalPasswd = originalPasswd;
    }

    public String getNewPasswd() {
        return newPasswd;
    }

    public void setNewPasswd(String newPasswd) {
        this.newPasswd = newPasswd;
    }

    @Override
    public String toString() {
        return "ModifyPasswdBO{" +
                "userId='" + userId + '\'' +
                ", originalPasswd='" + originalPasswd + '\'' +
                ", newPasswd='" + newPasswd + '\'' +
                '}';
    }
}
