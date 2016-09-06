package com.example.flowerlook.module_recommendation.presenter;

import com.example.flowerlook.module_recommendation.bean.RecommendBean;

/**
 * @Author:king1033
 * @Desc:
 * 需要处理的逻辑 连接view层和Model
 * 接口回调：用于接收网络请求之后的数据
 * @Time:2016/9/6
 */
public interface IpresenterRecommendation {
void getRecommendList(int pageidx);

    interface CallBack{
        void success(RecommendBean recommendBean);
    }

}
