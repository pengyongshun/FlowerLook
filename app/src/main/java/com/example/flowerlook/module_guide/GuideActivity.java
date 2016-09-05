package com.example.flowerlook.module_guide;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.flowerlook.R;
import com.example.flowerlook.module_guide.adapter.GuideAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuideActivity extends AppCompatActivity {
    @BindView(R.id.guide_activity_vp_guidephoto)
    public ViewPager mViewPager;
    private List<View> views = new ArrayList<>();
    private GuideAdapter mGuideAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);
        loadGuideData();
        initGuideAdapter();
        iniGuideListener();

    }

    private void iniGuideListener() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        View view1 = views.get(position);
                        Button btnOne = (Button) view1.findViewById(R.id.item_activity_guide_btn_one);
                        //btnOne.setOnClickListener(this);
                        break;
                    case 1:
                        View view2 = views.get(position);
                        Button btnTwo = (Button) view2.findViewById(R.id.item_activity_guide_btn_one);
                        break;
                    case 2:
                        View view3 = views.get(position);
                        Button btnThree = (Button) view3.findViewById(R.id.item_activity_guide_btn_one);
                        break;
                    case 3:
                        View view4 = views.get(position);
                        Button btnFour = (Button) view4.findViewById(R.id.item_activity_guide_btn_one);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initGuideAdapter() {
        mGuideAdapter = new GuideAdapter(views);
        mViewPager.setAdapter(mGuideAdapter);

    }

    private void loadGuideData() {
        View view1 = LayoutInflater.from(this).inflate(R.layout.item_vactivity_guide_vp_one, null);
        View view2 = LayoutInflater.from(this).inflate(R.layout.item_activity_guide_vp_two, null);
        View view3 = LayoutInflater.from(this).inflate(R.layout.item_activity_giude_vp_three, null);
        View view4 = LayoutInflater.from(this).inflate(R.layout.item_activity_guide_vp_four, null);
        views.add(view1);
        views.add(view2);
        views.add(view3);
        views.add(view4);

    }



}
