package com.example.flowerlook.module_ording.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.flowerlook.R;
import com.example.flowerlook.base_uitls.LogUtils;
import com.example.flowerlook.module_ording.adapter.OrdingFragmentAdapter;
import com.example.flowerlook.module_ording.bean.OrdingListBean;
import com.example.flowerlook.module_ording.presenter.concetion.PresenterOrdingContction;
import com.example.flowerlook.module_ording.view.IViewOrding;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OrdingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrdingFragment extends Fragment implements IViewOrding {
    private Context context;
    @BindView(R.id.ording_fragment_content_lv)
    public PullToRefreshListView mListView;
    private List<OrdingListBean.RowBean.ArticleListBean> articleListBeanList=new ArrayList<>();
    private OrdingFragmentAdapter mOrdingFragmentAdapter;
    private PresenterOrdingContction mPresenterOrdingContction;

    // TODO: Rename and change types and number of parameters
    public static OrdingFragment newInstance() {
        OrdingFragment fragment = new OrdingFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_ording, container, false);
        ButterKnife.bind(this,view);
        initOrdingfagmentAdapter();
        loadOrdingFragmentData();
        return view;
    }

    private void loadOrdingFragmentData() {
        //启动，加载数据   入口
        mPresenterOrdingContction = new PresenterOrdingContction(this);
        mPresenterOrdingContction.getOrdingDataFromModel();
    }

    private void initOrdingfagmentAdapter() {
        if(articleListBeanList!=null){
            mOrdingFragmentAdapter = new OrdingFragmentAdapter(context,articleListBeanList);
            mListView.setAdapter(mOrdingFragmentAdapter);
        }

    }


    @Override
    public void setText(List<OrdingListBean.RowBean.ArticleListBean> ordingListBean) {
        //加载后的数据  出口
        articleListBeanList.addAll(ordingListBean);
        mOrdingFragmentAdapter.notifyDataSetChanged();
        LogUtils.log(OrdingFragment.class,articleListBeanList.size()+"");
    }
}
