package com.example.flowerlook.module_recommendation.http;


import com.example.flowerlook.module_recommendation.bean.RecommendBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @Author:king1033
 * @Desc:
 * @Time:2016/9/6
 */
public interface HttpService{
    @GET("/mobile/article/getRecommendArticleList?platform=haokan&dev=android&version=v1.0&timestamp=1473146656474&count=10&userToken=f0e3de3296a7d6c2459bb8235fc2a92d&random=889062&pageidx=0")
    Observable<RecommendBean> queryRecommend(@Query("pageidx") int num);
}

