package com.jy.day01.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jy.day01.R;
import com.jy.day01.base.BaseFragment;
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
import com.jy.day01.ui.adapter.CategoryAdapter;
import com.jy.day01.ui.adapter.SubAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class SubFragment extends BaseFragment<ShopPersenter> implements IShop.View {

    private int id;
    private int cid;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        id = getArguments().getInt("id");
        cid = getArguments().getInt("id");
    }

    @BindView(R.id.recycler_categ)
    RecyclerView recyclerCateg;
    @BindView(R.id.recycler_sub)
    RecyclerView recyclerSub;
    private ArrayList<CategBean.DataBean.CurrentCategoryBean> categlist;
    private ArrayList<SubBean.DataBeanX.DataBean> sublist;
    private CategoryAdapter categoryAdapter;
    private SubAdapter subAdapter;

    @Override
    public int getLatout() {
        return R.layout.fragment_sub;
    }

    @Override
    public void initView() {
        categlist = new ArrayList<>();
        sublist = new ArrayList<>();

        recyclerCateg.setLayoutManager(new LinearLayoutManager(getActivity()));
        categoryAdapter = new CategoryAdapter(categlist, getActivity());
        recyclerCateg.setAdapter(categoryAdapter);

        recyclerSub.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        subAdapter = new SubAdapter(sublist, getActivity());
        recyclerSub.setAdapter(subAdapter);
    }

    @Override
    public ShopPersenter createPresenter() {
        return new ShopPersenter(this);
    }

    @Override
    public void initData() {
        presenter.getcateg(id);
        presenter.getsub(cid);
    }

    @Override
    public void getshop(ShopBean shopBean) {

    }

    @Override
    public void getcateg(CategBean categBean) {
        CategBean.DataBean.CurrentCategoryBean bean = categBean.getData().getCurrentCategory();
        categlist.add(bean);
        categoryAdapter.notifyDataSetChanged();
    }

    @Override
    public void getsub(SubBean subBean) {
        List<SubBean.DataBeanX.DataBean> data = subBean.getData().getData();
        sublist.addAll(data);
        subAdapter.notifyDataSetChanged();
    }

    @Override
    public void getbrand(BrandBean brandBean) {

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
}