package com.group8.entity;

import java.io.Serializable;

/**
 * className:User
 * discriptoin:
 * author:丁启斌
 * createTime:2018-11-23 17:30
 */
public class User implements Serializable {
    private int id;
    private String userName;
    private String PWD;
    private String salt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPWD() {
        return PWD;
    }

    public void setPWD(String PWD) {
        this.PWD = PWD;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
