package com.sutrix.android_mvp_core.function.authentication.data;

import core.model.BaseResult;

/**
 * Created by luantruong on 7/12/17.
 */

public class LoginResult extends BaseResult {
    private String token;

    public LoginResult() {

    }

    public LoginResult(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}