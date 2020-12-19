package com.jy.day01.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jy.day01.R;
import com.jy.day01.base.BaseAdapter;
import com.jy.day01.model.bean.BrandBean;

import java.util.ArrayList;
import java.util.List;

public class TitleBrandAdapter extends BaseAdapter {
    Context context;

    public TitleBrandAdapter(List mData, Context context) {
        super(mData, context);
        this.context = context;
    }

    @Override
    protected int getLayout() {
        return R.layout.item_title_brand;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        BrandBean.DataBeanX.DataBean bean = (BrandBean.DataBeanX.DataBean) data;
        ImageView img = (ImageView) vh.getViewByid(R.id.img);
        TextView tvTitle = (TextView) vh.getViewByid(R.id.tv_title);
        TextView tvModel = (TextView) vh.getViewByid(R.id.tv_money);

        Glide.with(context).load(bean.getApp_list_pic_url()).into(img);
        tvTitle.setText(bean.getName());
        tvModel.setText(bean.getFloor_price() + "元起");

        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onClick(vh.getLayoutPosition());
                }
            }
        });
    }

    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onClick(int pos);
    }
}
