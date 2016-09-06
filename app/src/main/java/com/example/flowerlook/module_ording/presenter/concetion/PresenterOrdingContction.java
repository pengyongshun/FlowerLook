package com.example.flowerlook.module_ording.presenter.concetion;

import com.example.flowerlook.module_ording.bean.OrdingListBean;
import com.example.flowerlook.module_ording.model.IModelOrding;
import com.example.flowerlook.module_ording.model.load_data.ModuleOrdingData;
import com.example.flowerlook.module_ording.presenter.IPresenterOrding;
import com.example.flowerlook.module_ording.view.IViewOrding;

import java.util.List;

/**
 * @Author:pengyongshun
 * @Desc:  链接module层和view的
 * @Time:2016/9/6
 */
public class PresenterOrdingContction implements IPresenterOrding,IPresenterOrding.OrdingCallback{
     IModelOrding moduleOrdingData=new ModuleOrdingData();
     IViewOrding viewOrding;

    public PresenterOrdingContction(IViewOrding viewOrding) {
        this.viewOrding = viewOrding;
    }

    /***
     * 调用启动Model去加载数据
     *
     * */
    @Override
    public void getOrdingDataFromModel() {
         moduleOrdingData.getOrdingDataFromNetWork(this);
    }

    /**
     * 从model那里获取数据   并将数据传入到View层
     *
     * */

    @Override
    public void success(List<OrdingListBean.RowBean.ArticleListBean> ordingListBean) {
         if (ordingListBean==null){
             return;
         }
        viewOrding.setText(ordingListBean);
    }
}
