package com.jy.day01.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.jy.day01.R;
import com.jy.day01.base.BaseAdapter;
import com.jy.day01.model.bean.GoodsDetailBean;

import java.util.ArrayList;
import java.util.List;

public class InfoAdapter extends BaseAdapter {
Context context;
    public InfoAdapter(List mData, Context context) {
        super(mData, context);
        this.context=context;
    }

    @Override
    protected int getLayout() {
        return R.layout.item_info;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        GoodsDetailBean.DataBeanX.InfoBean bean = (GoodsDetailBean.DataBeanX.InfoBean) data;
        TextView tvTitle = (TextView) vh.getViewByid(R.id.tv_title);
        TextView tvType = (TextView) vh.getViewByid(R.id.tv_type);
        TextView tvMoney = (TextView) vh.getViewByid(R.id.tv_money);

        tvTitle.setText(bean.getName());
        tvType.setText(bean.getGoods_brief());
        tvMoney.setText("￥"+bean.getRetail_price());
    }
}
