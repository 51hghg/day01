package com.jy.day01.ui;

import android.content.Intent;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jy.day01.R;
import com.jy.day01.base.BaseActivity;
import com.jy.day01.interfaces.shop.IShop;
import com.jy.day01.model.bean.BrandBean;
import com.jy.day01.model.bean.CategBean;
import com.jy.day01.model.bean.DetailBean;
import com.jy.day01.model.bean.GoodsDetailBean;
import com.jy.day01.model.bean.GoodslistBean;
import com.jy.day01.model.bean.NewBean;
import com.jy.day01.model.bean.ShopBean;
import com.jy.day01.model.bean.SubBean;
import com.jy.day01.persenter.ShopPersenter;
import com.jy.day01.ui.adapter.DetailAdapter;
import com.jy.day01.ui.adapter.GoodsAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class DetailActivity extends BaseActivity<ShopPersenter> implements IShop.View {

    @BindView(R.id.recycler_detail)
    RecyclerView recyclerDetail;
    @BindView(R.id.recycler_goods)
    RecyclerView recyclerGoods;
    private int id;
    private ArrayList<DetailBean.DataBean.BrandBean> detaillist;
    private DetailAdapter detailAdapter;
    private ArrayList<GoodslistBean.DataBeanX.DataBean> goodslist;
    private GoodsAdapter goodsAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_detail;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1);

        detaillist = new ArrayList<>();
        goodslist = new ArrayList<>();

        recyclerDetail.setLayoutManager(new LinearLayoutManager(this));
        detailAdapter = new DetailAdapter(detaillist, this);
        recyclerDetail.setAdapter(detailAdapter);

        recyclerGoods.setLayoutManager(new GridLayoutManager(this, 2));
        goodsAdapter = new GoodsAdapter(goodslist, this);
        recyclerGoods.setAdapter(goodsAdapter);
    }

    @Override
    protected ShopPersenter createPersenter() {
        return new ShopPersenter(this);
    }

    @Override
    protected void initData() {
        presenter.getdetail(id);
        presenter.getgoodslist(id);
    }

    @Override
    public void getshop(ShopBean shopBean) {

    }

    @Override
    public void getcateg(CategBean categBean) {

    }

    @Override
    public void getsub(SubBean subBean) {

    }

    @Override
    public void getbrand(BrandBean brandBean) {

    }

    @Override
    public void getnew(NewBean newBean) {

    }

    @Override
    public void getdetail(DetailBean detailBean) {
        DetailBean.DataBean.BrandBean brand = detailBean.getData().getBrand();
        detaillist.add(brand);
        detailAdapter.notifyDataSetChanged();
    }

    @Override
    public void getgoodlist(GoodslistBean goodslistBean) {
        List<GoodslistBean.DataBeanX.DataBean> data = goodslistBean.getData().getData();
        goodslist.addAll(data);
        goodsAdapter.notifyDataSetChanged();
    }

    @Override
    public void getgoodsdetail(GoodsDetailBean goodsDetailBean) {

    }
}