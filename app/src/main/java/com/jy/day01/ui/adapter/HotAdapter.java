package com.jy.day01.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jy.day01.R;
import com.jy.day01.base.BaseAdapter;
import com.jy.day01.model.bean.ShopBean;

import java.util.List;

public class HotAdapter extends BaseAdapter {
    Context context;

    public HotAdapter(List mData, Context context) {
        super(mData, context);
        this.context = context;
    }

    @Override
    protected int getLayout() {
        return R.layout.item_hot;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        ShopBean.DataBean.HotGoodsListBean bean = (ShopBean.DataBean.HotGoodsListBean) data;
        ImageView img = (ImageView) vh.getViewByid(R.id.img);
        TextView tvTitle = (TextView) vh.getViewByid(R.id.tv_title);
        TextView tvType = (TextView) vh.getViewByid(R.id.tv_type);
        TextView tvMoney = (TextView) vh.getViewByid(R.id.tv_money);

        Glide.with(context).load(bean.getList_pic_url()).into(img);
        tvTitle.setText(bean.getName());
        tvType.setText(bean.getGoods_brief());
        tvMoney.setText("￥" + bean.getRetail_price());
    }
}
