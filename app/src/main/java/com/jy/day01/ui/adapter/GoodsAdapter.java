package com.jy.day01.ui.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jy.day01.R;
import com.jy.day01.base.BaseAdapter;
import com.jy.day01.model.bean.GoodslistBean;

import java.util.ArrayList;
import java.util.List;

public class GoodsAdapter extends BaseAdapter {
    Context context;

    public GoodsAdapter(List mData, Context context) {
        super(mData, context);
        this.context = context;
    }

    @Override
    protected int getLayout() {
        return R.layout.item_goods;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        GoodslistBean.DataBeanX.DataBean bean = (GoodslistBean.DataBeanX.DataBean) data;

        ImageView img = (ImageView) vh.getViewByid(R.id.img);
        TextView tvTitle = (TextView) vh.getViewByid(R.id.tv_title);
        TextView tvMoney = (TextView) vh.getViewByid(R.id.tv_money);

        Glide.with(context).load(bean.getList_pic_url()).into(img);
        tvTitle.setText(bean.getName());
        tvMoney.setText("￥" + bean.getRetail_price());
    }
}
