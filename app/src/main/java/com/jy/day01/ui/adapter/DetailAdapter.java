package com.jy.day01.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jy.day01.R;
import com.jy.day01.base.BaseAdapter;
import com.jy.day01.model.bean.DetailBean;

import java.util.ArrayList;
import java.util.List;

public class DetailAdapter extends BaseAdapter {

    Context context;

    public DetailAdapter(List mData, Context context) {
        super(mData, context);
        this.context = context;
    }

    @Override
    protected int getLayout() {
        return R.layout.item_detail;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        DetailBean.DataBean.BrandBean bean = (DetailBean.DataBean.BrandBean) data;
        ImageView img = (ImageView) vh.getViewByid(R.id.img);
        TextView tvTitle = (TextView) vh.getViewByid(R.id.tv_title);
        TextView tvType = (TextView) vh.getViewByid(R.id.tv_type);

        Glide.with(context).load(bean.getApp_list_pic_url()).into(img);
        tvTitle.setText(bean.getName());
        tvType.setText(bean.getSimple_desc());
    }
}
