package com.example.flowerlook;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.flowerlook.module_home.adapter.HomeAdapter;
import com.example.flowerlook.module_hot.fragment.HotFragment;
import com.example.flowerlook.module_ording.fragment.OrdingFragment;
import com.example.flowerlook.module_recommendation.fragment.RecommendationFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {
    @BindView(R.id.home_activity_tool_content)
    public Toolbar mToolbar;
    @BindView(R.id.home_activity_tab_title)
    public TabLayout mTabLayout;
    @BindView(R.id.home_activity_vp_fragment)
    public ViewPager mViewPager;
    private List<Fragment> fragments=new ArrayList<>();
    private List<String> titles=new ArrayList<>();
    private HomeAdapter mHomeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        loadHomeData();
        initHomeAdapter();

    }

    private void initHomeAdapter() {
        mHomeAdapter = new HomeAdapter(getSupportFragmentManager(),fragments,titles);
        mViewPager.setAdapter(mHomeAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void loadHomeData() {
        OrdingFragment ordingFragment = new OrdingFragment().newInstance();
        HotFragment hotFragment = new HotFragment().newInstance();
        RecommendationFragment recommendationFragment = new RecommendationFragment().newInstance();
        fragments.add(ordingFragment);
        fragments.add(hotFragment);
        fragments.add(recommendationFragment);
        titles.add("订阅");
        titles.add("热门");
        titles.add("推荐");
    }


    /**
     * 对toolBar进行监听
     * */
    public void onClick(View view){
        switch (view.getId()){
            case R.id.home_activity_tool_iv_icon:
                //TODO 转跳到登录界面
                Toast.makeText(HomeActivity.this, "转跳到登录界面", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home_activity_tool_btn_refluse:
                //TODO 刷新当前界面的数据
                Toast.makeText(HomeActivity.this, "刷新当前界面的数据", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home_activity_tool_iv_ording:
                //TODO 转跳到订阅界面
                Toast.makeText(HomeActivity.this, "刷新当前界面的数据", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
