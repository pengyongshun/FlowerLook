package com.example.flowerlook.module_ording.http;

import com.example.flowerlook.base_http.url.OrdingUrl;
import com.example.flowerlook.module_ording.bean.OrdingListBean;

import retrofit2.Call;
import retrofit2.http.GET;


/**
 * @Author:pengyongshun
 * @Desc:
 * @Time:2016/9/6
 */
public interface HttpOrdingService {
   @GET(OrdingUrl.ORDING_LIST_BOTTOM)
   Call<OrdingListBean> getOrdingListDataFromGet();
}
