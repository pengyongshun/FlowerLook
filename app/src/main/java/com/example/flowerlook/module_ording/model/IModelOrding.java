package com.example.flowerlook.module_ording.model;

import com.example.flowerlook.module_ording.presenter.IPresenterOrding;

/**
 * Created by 彭永顺 on 2016/9/5.
 */
public interface IModelOrding {
    //去网上请求数据
    void getOrdingDataFromNetWork(IPresenterOrding.OrdingCallback callback);

}
