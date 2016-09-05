package com.example.flowerlook.module_welcome;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.flowerlook.HomeActivity;
import com.example.flowerlook.R;
import com.example.flowerlook.module_guide.GuideActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelcomeActivity extends AppCompatActivity {
    @BindView(R.id.welcome_activity_iv_show)
    public ImageView ivWelcome;
    private SharedPreferences firstStartSp;
    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //获取SharedPreferences对象
            firstStartSp = getSharedPreferences("count", Context.MODE_PRIVATE);
            int count = firstStartSp.getInt("count", 0);
            //判断程序与第几次运行，如果是第一次运行则跳转到引导页面
            if (count==0){
                Intent intent=new Intent();
                intent.setClass(WelcomeActivity.this,GuideActivity.class);
                startActivity(intent);
                finish();
            }else {
                //转跳到首页
                Intent intent1=new Intent();
                intent1.setClass(WelcomeActivity.this, HomeActivity.class);
                startActivity(intent1);
                finish();
            }
            count++;
            //获取编辑器
            SharedPreferences.Editor editor=firstStartSp.edit();
            //存入内部存储中
            editor.putInt("count",count);
            editor.commit();
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        mHandler.sendEmptyMessageDelayed(1,2000);
    }
}
