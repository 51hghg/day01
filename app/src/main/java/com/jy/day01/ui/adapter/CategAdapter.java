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

public class CategAdapter extends BaseAdapter {
    Context context;

    public CategAdapter(List mData, Context context) {
        super(mData, context);
        this.context = context;
    }

    @Override
    protected int getLayout() {
        return R.layout.item_categ;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        ShopBean.DataBean.CategoryListBean.GoodsListBean bean = (ShopBean.DataBean.CategoryListBean.GoodsListBean) data;

        ImageView img = (ImageView) vh.getViewByid(R.id.img);
        TextView tvTitle = (TextView) vh.getViewByid(R.id.tv_title);
        TextView tvMoney = (TextView) vh.getViewByid(R.id.tv_money);

        Glide.with(context).load(bean.getList_pic_url()).into(img);
        tvTitle.setText(bean.getName());
        tvMoney.setText("￥" + bean.getRetail_price());

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
