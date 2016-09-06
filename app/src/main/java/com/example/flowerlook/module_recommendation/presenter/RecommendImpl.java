package com.example.flowerlook.module_recommendation.presenter;

import com.example.flowerlook.module_recommendation.bean.RecommendBean;
import com.example.flowerlook.module_recommendation.model.IModelRecoommendation;
import com.example.flowerlook.module_recommendation.view.IViewRecommendation;

/**
 * @Author:king1033
 * @Desc:
 * @Time:2016/9/6
 */
public class RecommendImpl implements IpresenterRecommendation,IpresenterRecommendation.CallBack{

    IModelRecoommendation mModelRecoommendation;
    IViewRecommendation mViewRecommendation;

    public RecommendImpl(IViewRecommendation vewRecommendation) {
        //this.mModelRecoommendation = new ModelRecoommendationImpl();
        this.mViewRecommendation = vewRecommendation;
    }

    @Override
    public void getRecommendList(int pageidx) {

    }

    @Override
    public void success(RecommendBean recommendBean) {

    }


}
