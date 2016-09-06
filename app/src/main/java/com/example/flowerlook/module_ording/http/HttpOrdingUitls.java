package com.example.flowerlook.module_ording.http;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Author:pengyongshun
 * @Desc: 使用Retrofit来加载数据
 * @Time:2016/9/6
 */
public class HttpOrdingUitls {
    private static HttpOrdingService httpService;
    public static HttpOrdingService init(String baseUrl){
        if (httpService==null){
            Retrofit.Builder builder=new Retrofit.Builder();
            if (baseUrl==null){
                try {
                    throw new Exception("基础地址不能为空");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            //添加基础地址
            builder.baseUrl(baseUrl);
            //添加Gson对象
            builder.addConverterFactory(GsonConverterFactory.create());
            Retrofit build = builder.build();
            HttpOrdingService httpService = build.create(HttpOrdingService.class);
            return httpService;
        }
        return null;
    }
}
