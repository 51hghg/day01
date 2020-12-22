package com.jy.day01.ui.fragment;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.bumptech.glide.Glide;
import com.jy.day01.R;
import com.jy.day01.base.BaseAdapter;
import com.jy.day01.model.bean.CarBean;

import java.util.ArrayList;
import java.util.List;

public class CarAdapter extends BaseAdapter {

    Context context;

    private boolean inEdit;
    private boolean checked;

    public void setEditState(boolean bool) {
        inEdit = bool;
    }

    public void setChecked(boolean bool) {
        checked = bool;
    }

    public CarAdapter(List mData, Context context) {
        super(mData, context);
        this.context = context;
    }

    @Override
    protected int getLayout() {
        return R.layout.item_car;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        CarBean.DataBean.CartListBean bean = (CarBean.DataBean.CartListBean) data;
        ImageView imgItem = (ImageView) vh.getViewByid(R.id.img_item);
        TextView txtName = (TextView) vh.getViewByid(R.id.txt_name);
        TextView txtPrice = (TextView) vh.getViewByid(R.id.txt_price);
        TextView txtNumbar = (TextView) vh.getViewByid(R.id.txt_numbe);
        TextView txtEditTitle = (TextView) vh.getViewByid(R.id.txt_edit_title);
        LinearLayout linear = (LinearLayout) vh.getViewByid(R.id.linear);
        CheckBox checkbox = (CheckBox) vh.getViewByid(R.id.checkbox);
        TextView tvJia = (TextView) vh.getViewByid(R.id.tv_jia);
        TextView tvJian = (TextView) vh.getViewByid(R.id.tv_jian);
        TextView tvNum = (TextView) vh.getViewByid(R.id.tv_num);

//        String num = tvNum.getText().toString();
//        tvJia.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                num++;
//            }
//        });
//
//        tvJian.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                num--;
//            }
//        });


        Glide.with(context).load(bean.getList_pic_url()).into(imgItem);
        txtName.setText(bean.getGoods_name());
        txtPrice.setText("￥" + bean.getRetail_price());
        txtNumbar.setText("×" + bean.getNumber());

        if (inEdit) {
            txtNumbar.setVisibility(View.GONE);
            txtEditTitle.setVisibility(View.VISIBLE);
            linear.setVisibility(View.VISIBLE);
        } else {
            txtNumbar.setVisibility(View.VISIBLE);
            txtEditTitle.setVisibility(View.GONE);
            linear.setVisibility(View.GONE);
        }

        if (checked) {
            checkbox.isSelected();
        }
    }
}
