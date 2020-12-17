package com.jy.day01.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.bumptech.glide.Glide;
import com.jy.day01.R;
import com.jy.day01.base.BaseAdapter;
import com.jy.day01.model.bean.ShopBean;

import java.util.ArrayList;
import java.util.List;

public class TopicAdapter extends BaseAdapter {
    Context context;

    public TopicAdapter(List mData, Context context) {
        super(mData, context);
        this.context = context;
    }

    @Override
    protected int getLayout() {
        return R.layout.item_topic;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        ShopBean.DataBean.TopicListBean bean = (ShopBean.DataBean.TopicListBean) data;
        ImageView img = (ImageView) vh.getViewByid(R.id.img);
        TextView tvTitle = (TextView) vh.getViewByid(R.id.tv_title);
        TextView tvModel = (TextView) vh.getViewByid(R.id.tv_money);
        TextView tvType = (TextView) vh.getViewByid(R.id.tv_type);

        Glide.with(context).load(bean.getItem_pic_url()).into(img);
        tvTitle.setText(bean.getTitle());
        tvModel.setText("￥" + bean.getPrice_info() + "元起");
        tvType.setText(bean.getSubtitle());
    }
}
