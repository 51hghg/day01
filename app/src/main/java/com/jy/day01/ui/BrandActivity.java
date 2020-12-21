package com.jy.day01.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jy.day01.R;
import com.jy.day01.base.BaseActivity;
import com.jy.day01.interfaces.shop.IShop;
import com.jy.day01.model.bean.BrandBean;
import com.jy.day01.model.bean.CategBean;
import com.jy.day01.model.bean.CategoryBean;
import com.jy.day01.model.bean.CurrentBean;
import com.jy.day01.model.bean.DetailBean;
import com.jy.day01.model.bean.GoodsDetailBean;
import com.jy.day01.model.bean.GoodslistBean;
import com.jy.day01.model.bean.NewBean;
import com.jy.day01.model.bean.ShopBean;
import com.jy.day01.model.bean.SubBean;
import com.jy.day01.persenter.ShopPersenter;
import com.jy.day01.ui.adapter.TitleBrandAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BrandActivity extends BaseActivity<ShopPersenter> implements IShop.View {

    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.smart)
    SmartRefreshLayout smart;
    private int page = 1;
    private ArrayList<BrandBean.DataBeanX.DataBean> brandlist;
    private TitleBrandAdapter titleBrandAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_brand;
    }

    @Override
    protected void initView() {
        brandlist = new ArrayList<>();

        recycler.setLayoutManager(new LinearLayoutManager(this));
        titleBrandAdapter = new TitleBrandAdapter(brandlist, this);
        recycler.setAdapter(titleBrandAdapter);



    }

    @Override
    protected ShopPersenter createPersenter() {
        return new ShopPersenter(this);
    }

    @Override
    protected void initData() {
        presenter.getbrand(page);
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
        List<BrandBean.DataBeanX.DataBean> data = brandBean.getData().getData();
        brandlist.addAll(data);
        titleBrandAdapter.notifyDataSetChanged();
        smart.finishRefresh();
        smart.finishLoadMore();

        smart.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                initData();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page = 1;
                brandlist.clear();
                initData();
            }
        });

        titleBrandAdapter.setOnItemClickListener(new TitleBrandAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Intent intent = new Intent(BrandActivity.this, DetailActivity.class);
                intent.putExtra("id", brandlist.get(pos).getId());
                startActivity(intent);
            }
        });
    }

    @Override
    public void getnew(NewBean newBean) {

    }

    @Override
    public void getdetail(DetailBean detailBean) {

    }

    @Override
    public void getgoodlist(GoodslistBean goodslistBean) {

    }

    @Override
    public void getgoodsdetail(GoodsDetailBean goodsDetailBean) {

    }

    @Override
    public void getcategory(CategoryBean categoryBean) {

    }

    @Override
    public void getcurrent(CurrentBean currentBean) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}