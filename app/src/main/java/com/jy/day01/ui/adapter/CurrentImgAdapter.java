package com.jy.day01.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.bumptech.glide.Glide;
import com.jy.day01.R;
import com.jy.day01.base.BaseAdapter;
import com.jy.day01.model.bean.CurrentBean;

import java.util.ArrayList;
import java.util.List;

public class CurrentImgAdapter extends BaseAdapter {
    Context context;

    public CurrentImgAdapter(List mData, Context context) {
        super(mData, context);
        this.context = context;
    }

    @Override
    protected int getLayout() {
        return R.layout.item_current;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        CurrentBean.DataBean.CurrentCategoryBean bean = (CurrentBean.DataBean.CurrentCategoryBean) data;
        TextView tvTitle = (TextView) vh.getViewByid(R.id.tv_title);
        ImageView img = (ImageView) vh.getViewByid(R.id.img);
        TextView tvType = (TextView) vh.getViewByid(R.id.tv_type);

        tvTitle.setText(bean.getFront_desc());
        Glide.with(context).load(bean.getWap_banner_url()).into(img);
        tvType.setText("——" + bean.getName() + "分类——");
    }
}
