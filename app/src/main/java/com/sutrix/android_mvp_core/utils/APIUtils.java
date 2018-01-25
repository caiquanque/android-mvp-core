package com.sutrix.android_mvp_core.utils;

import core.data.services.APIService;

import core.data.services.RetrofitClient;

/**
 * Created by luantruong on 7/12/17.
 */

public class APIUtils {

    private static final String BASE_URL = "https://reqres.in/";

    public static APIService getAPIService() {
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
