package com.jy.day01.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jy.day01.R;
import com.jy.day01.base.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public class BigAdapter extends BaseAdapter {

    Context context;

    public BigAdapter(List mData, Context context) {
        super(mData, context);
        this.context = context;
    }

    @Override
    protected int getLayout() {
        return R.layout.item_img;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        String s= (String) data;
        ImageView img = (ImageView) vh.getViewByid(R.id.img);
        Glide.with(context).load(s).into(img);
        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener!= null){
                    onItemClickListener.onClick(vh.getLayoutPosition());
                }
            }
        });
    }

    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onClick(int pos);
    }
}
