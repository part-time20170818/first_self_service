package com.wr.dto;

/**
 * Created by 文歌 on 2017/9/3.
 */
public class LoginBO {
    private String userName;
    private String passWord;
    private String checkNumber;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    @Override
    public String toString() {
        return "LoginBO{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", checkNumber='" + checkNumber + '\'' +
                '}';
    }
}
