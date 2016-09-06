package com.example.flowerlook.module_ording.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.flowerlook.R;
import com.example.flowerlook.base_uitls.ImageLoader;
import com.example.flowerlook.module_ording.bean.OrdingListBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @Author:pengyongshun
 * @Desc:  ordingfragment的列表的适配器
 * @Time:2016/9/6
 */
public class OrdingFragmentAdapter extends BaseAdapter {
    private List<OrdingListBean.RowBean.ArticleListBean> beanList;
    private Context context;
    private LayoutInflater mInflater;

    public OrdingFragmentAdapter(Context context, List<OrdingListBean.RowBean.ArticleListBean> beanList) {
        this.context = context;
        this.beanList = beanList;
        mInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return beanList==null?0:beanList.size();
    }

    @Override
    public Object getItem(int position) {
        return beanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        OrdingViewHodler hodler=null;
        if (convertView==null){
            convertView=mInflater.inflate(R.layout.item_fragment_ording_listview,parent,false);
            hodler=new OrdingViewHodler(convertView);
        }else {
            hodler= (OrdingViewHodler) convertView.getTag();
        }
        //跟新UI
        OrdingListBean.RowBean.ArticleListBean articleListBean = beanList.get(position);
        String coverUrl = articleListBean.getCoverUrl();
        String digest = articleListBean.getDigest();
        String officialAccountPicture = articleListBean.getOfficialAccountPicture();
        String title = articleListBean.getTitle();
        String postTime = articleListBean.getPostTime();
        String author = articleListBean.getAuthor();
        hodler.tvAutjorOrding.setText(author);
        hodler.tvDigestOrding.setText(digest);
        hodler.tvPosttimeOrding.setText(postTime);
        hodler.tvTitleOrding.setText(title);
        ImageLoader.init(context).load(officialAccountPicture,hodler.civCoverOrding);
        ImageLoader.init(context).load(coverUrl,hodler.ivOffOrding);
        return convertView;
    }
    class OrdingViewHodler{
        @BindView(R.id.item_ording_fragment_listview_civ_coverurl)
        CircleImageView civCoverOrding;
        @BindView(R.id.item_ording_fragment_listview_iv_officialaccountpicture)
        ImageView ivOffOrding;
        @BindView(R.id.item_ording_fragment_listview_tv_author)
        TextView tvAutjorOrding;
        @BindView(R.id.item_ording_fragment_listview_tv_digest)
        TextView tvDigestOrding;
        @BindView(R.id.item_ording_fragment_listview_tv_posttime)
        TextView tvPosttimeOrding;
        @BindView(R.id.item_ording_fragment_listview_tv_title)
        TextView tvTitleOrding;
        public OrdingViewHodler(View view){
            ButterKnife.bind(this,view);
            view.setTag(this);
        }
    }
}
