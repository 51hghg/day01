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

import java.util.List;

public class CurrentAdapter extends BaseAdapter {

    Context context;

    public CurrentAdapter(List mData, Context context) {
        super(mData, context);
        this.context = context;
    }

    @Override
    protected int getLayout() {
        return R.layout.item_cuttent;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        CurrentBean.DataBean.CurrentCategoryBean.SubCategoryListBean bean = (CurrentBean.DataBean.CurrentCategoryBean.SubCategoryListBean) data;
        TextView tvTitle = (TextView) vh.getViewByid(R.id.tv_title);
        ImageView img = (ImageView) vh.getViewByid(R.id.img);

        Glide.with(context).load(bean.getWap_banner_url()).into(img);
        tvTitle.setText(bean.getName());
        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onClick(vh.getLayoutPosition());
                }
            }
        });
    }

    TitleBrandAdapter.OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(TitleBrandAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onClick(int pos);
    }
}
