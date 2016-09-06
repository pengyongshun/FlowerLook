package com.example.flowerlook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrdingDetialActivity extends AppCompatActivity {

    @BindView(R.id.activity_detial_ording_tool_content)
    public Toolbar mToolbar;
    @BindView(R.id.activity_detial_ording_tv_title)
    public TextView mTvTitle;
    @BindView(R.id.activity_detial_ording_web_content)
    public WebView mWebView;
    @BindView(R.id.activity_detial_ording_rg_button)
    public RadioGroup mRadioGroup;

    private String articleUrl;
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ording_detial);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        //获取从列表界面传来的url
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        articleUrl = bundle.getString("articleUrl");
        title = bundle.getString("title");
        loadData();
        initListener();
    }

    private void initListener() {
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.activity_detial_ording_rb_collection:
                        Toast.makeText(OrdingDetialActivity.this, "点击了收藏", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.activity_detial_ording_rb_share:
                        Toast.makeText(OrdingDetialActivity.this, "点击了分享", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    private void loadData() {
        if (!articleUrl.isEmpty()){
            mWebView.loadUrl(articleUrl);
            WebViewClient webViewClient=new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
            };
            mWebView.setWebViewClient(webViewClient);
        }
        if (!title.isEmpty()){
            mTvTitle.setText(title);
        }
    }
    public void onClick(View view){
        //点击返回到上一个界面
        finish();
    }

}
