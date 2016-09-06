package com.example.flowerlook.module_ording.model.load_data;

import com.example.flowerlook.base_http.url.OrdingUrl;
import com.example.flowerlook.module_ording.bean.OrdingListBean;
import com.example.flowerlook.module_ording.http.HttpOrdingUitls;
import com.example.flowerlook.module_ording.model.IModelOrding;
import com.example.flowerlook.module_ording.presenter.IPresenterOrding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @Author:pengyongshun
 * @Desc: 去网络加载数据  使用refiot请求框架
 * @Time:2016/9/6
 */
public class ModuleOrdingData implements IModelOrding{


    @Override
    public void getOrdingDataFromNetWork(final IPresenterOrding.OrdingCallback callback) {
        HttpOrdingUitls.init(OrdingUrl.ORDING_LIST_BAES).getOrdingListDataFromGet().enqueue(new Callback<OrdingListBean>() {
            @Override
            public void onResponse(Call<OrdingListBean> call, Response<OrdingListBean> response) {
                  if (response==null){
                      return;
                  }
                OrdingListBean ordingListBean = response.body();
                OrdingListBean.RowBean row = ordingListBean.getRow();
                List<OrdingListBean.RowBean.ArticleListBean> articleList = row.getArticleList();
                callback.success(articleList);
            }

            @Override
            public void onFailure(Call<OrdingListBean> call, Throwable t) {

            }
        });
    }
}
