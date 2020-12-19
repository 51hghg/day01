package com.jy.day01.ui.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jy.day01.R;
import com.jy.day01.base.BaseAdapter;
import com.jy.day01.model.bean.NewBean;

import java.util.List;

public class NewGoodsAdapter extends BaseAdapter {
    Context context;

    public NewGoodsAdapter(List mData, Context context) {
        super(mData, context);
        this.context = context;
    }

    @Override
    protected int getLayout() {
        return R.layout.item_newgoods;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        NewBean.DataBeanX.DataBean bean = (NewBean.DataBeanX.DataBean) data;
        ImageView imageView = vh.itemView.findViewById(R.id.img);
        TextView name = vh.itemView.findViewById(R.id.tv_name);
        TextView tv = vh.itemView.findViewById(R.id.tv_price);
        Glide.with(context).load(bean.getList_pic_url()).into(imageView);
        name.setText(bean.getName());
        tv.setText(bean.getRetail_price() + "");
    }
}
