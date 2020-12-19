package com.jy.day01.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.jy.day01.R;
import com.jy.day01.base.BaseAdapter;
import com.jy.day01.model.bean.CategBean;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends BaseAdapter {
    Context context;

    public CategoryAdapter(List mData, Context context) {
        super(mData, context);
        this.context = context;
    }

    @Override
    protected int getLayout() {
        return R.layout.item_categ_sub;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        CategBean.DataBean.CurrentCategoryBean bean = (CategBean.DataBean.CurrentCategoryBean) data;
        TextView tvTitle = (TextView) vh.getViewByid(R.id.tv_title);
        TextView tvType = (TextView) vh.getViewByid(R.id.tv_type);

        tvTitle.setText(bean.getName());
        tvType.setText(bean.getFront_name());
    }
}
