package com.example.flowerlook.module_recommendation.http;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * @Author:king1033
 * @Desc:
 * @Time:2016/9/6
 */
public class HttpUtil {
    public static final String BASE_URL = "http://haokan.weijuju.com";
    private static HttpService mHttpService;

    public static HttpService create() {
        if (mHttpService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            mHttpService = retrofit.create(HttpService.class);
        }
        return mHttpService;
    }
}
