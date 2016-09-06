package com.example.flowerlook.module_ording.view;

import com.example.flowerlook.module_ording.bean.OrdingListBean;

import java.util.List;

/**
 * Created by 彭永顺 on 2016/9/5.
 */
public interface IViewOrding {
    // 处理显示控件的逻辑  将数据传到fragment中
    void setText(List<OrdingListBean.RowBean.ArticleListBean> ordingListBean);
}
