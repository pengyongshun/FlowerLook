package com.example.flowerlook.module_ording.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.flowerlook.OrdingDetialActivity;
import com.example.flowerlook.R;
import com.example.flowerlook.base_uitls.LogUtils;
import com.example.flowerlook.module_ording.adapter.OrdingFragmentAdapter;
import com.example.flowerlook.module_ording.bean.OrdingListBean;
import com.example.flowerlook.module_ording.presenter.concetion.PresenterOrdingContction;
import com.example.flowerlook.module_ording.view.IViewOrding;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
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
    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            loadOrdingFragmentData();
            mListView.onRefreshComplete();
            mOrdingFragmentAdapter.notifyDataSetChanged();
        }
    };

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
        iniOrdingFragmentListener();
        return view;
    }

    private void iniOrdingFragmentListener() {
        //下拉刷新
        mListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                //下拉刷新
                if (articleListBeanList!=null){
                    articleListBeanList.clear();
                }
                mHandler.sendEmptyMessageDelayed(1,1000);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

            }
        });
        //对一个item进行监听
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (!articleListBeanList.isEmpty()){
                    OrdingListBean.RowBean.ArticleListBean articleListBean = articleListBeanList.get(position - 1);
                    String articleUrl = articleListBean.getArticleUrl();
                    String title = articleListBean.getTitle();
                    Intent intent=new Intent(context, OrdingDetialActivity.class);
                    Bundle bundle=new Bundle();
                    bundle.putString("articleUrl",articleUrl);
                    bundle.putString("title",title);
                    intent.putExtra("bundle",bundle);
                    startActivity(intent);
                }

            }
        });
    }

    private void loadOrdingFragmentData() {
        if (articleListBeanList.isEmpty()){
            //启动，加载数据   入口
            mPresenterOrdingContction = new PresenterOrdingContction(this);
            mPresenterOrdingContction.getOrdingDataFromModel();
        }

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
    }

}
