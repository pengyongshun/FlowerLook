package com.example.flowerlook.module_recommendation.view;

import com.example.flowerlook.module_recommendation.bean.RecommendBean;

import java.util.List;

/**
 * @Author:king1033
 * @Desc:
 * 刷新适配器，更新视图
 * 处理显示控件的逻辑  将数据传到fragment中
 * @Time:2016/9/6
 */
public interface IViewRecommendation {
    void refreshListView(List<RecommendBean>recommendBeen);
}
