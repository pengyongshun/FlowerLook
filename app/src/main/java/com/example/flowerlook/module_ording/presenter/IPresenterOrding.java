package com.example.flowerlook.module_ording.presenter;

import com.example.flowerlook.module_ording.bean.OrdingListBean;

import java.util.List;

/**
 * Created by 彭永顺 on 2016/9/5.
 */
public interface IPresenterOrding {
    /**
     * 查询modelc层的数据，启动model层去加载数据
     * */
    void getOrdingDataFromModel();
    /**
     * 接口回调：用于接收网络请求之后的数据  从model层获取数据
     */
    interface OrdingCallback {
        void success(List<OrdingListBean.RowBean.ArticleListBean> ordingListBean);
    }
}
