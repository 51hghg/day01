package com.jy.day01.ui.adapter;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.jy.day01.R;
import com.jy.day01.base.BaseAdapter;
import com.jy.day01.model.bean.Bean;

import java.util.List;

public class ListAdapter extends BaseAdapter {
    Context context;

    public ListAdapter(List mData, Context context) {
        super(mData, context);
        this.context = context;
    }

    @Override
    protected int getLayout() {
        return R.layout.item_chend;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        Bean.DataBean dataBean = (Bean.DataBean) data;
        CheckBox cb = (CheckBox) vh.getViewByid(R.id.cb);
        TextView tv = (TextView) vh.getViewByid(R.id.tv);

        tv.setText(dataBean.getName());
        cb.setChecked(dataBean.isSelect());

        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    cb.setChecked(b);
                    dataBean.setLv(b);
                } else {
                    cb.setChecked(b);
                    dataBean.setLv(b);
                }
            }
        });
    }
}
