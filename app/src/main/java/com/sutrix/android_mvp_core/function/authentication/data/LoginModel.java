package com.sutrix.android_mvp_core.function.authentication.data;

import core.model.BaseModel;

/**
 * Created by luantruong on 7/12/17.
 *
 * Sign in DTTHONG
 */

public class LoginModel extends BaseModel {
    private String username;
    private String password;

    public LoginModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
