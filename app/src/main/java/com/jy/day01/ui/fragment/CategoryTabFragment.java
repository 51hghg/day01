package com.jy.day01.ui.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jy.day01.HomeActivity;
import com.jy.day01.R;
import com.jy.day01.base.BaseFragment;
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
import com.jy.day01.ui.adapter.CurrentAdapter;
import com.jy.day01.ui.adapter.CurrentImgAdapter;
import com.jy.day01.ui.adapter.TitleBrandAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class CategoryTabFragment extends BaseFragment<ShopPersenter> implements IShop.View {
    @BindView(R.id.recycler_img)
    RecyclerView recyclerImg;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    private int id;
    private ArrayList<CurrentBean.DataBean.CurrentCategoryBean> currentlist;
    private CurrentAdapter currentAdapter;
    private CurrentImgAdapter currentImgAdapter;
    private ArrayList<CurrentBean.DataBean.CurrentCategoryBean.SubCategoryListBean> sublist;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        id = getArguments().getInt("id");
    }

    @Override
    public int getLatout() {
        return R.layout.fragment_category_tab;
    }

    @Override
    public void initView() {
        currentlist = new ArrayList<>();
        sublist = new ArrayList<>();

        recycler.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        currentAdapter = new CurrentAdapter(sublist, getActivity());
        recycler.setAdapter(currentAdapter);

        recyclerImg.setLayoutManager(new LinearLayoutManager(getActivity()));
        currentImgAdapter = new CurrentImgAdapter(currentlist, getActivity());
        recyclerImg.setAdapter(currentImgAdapter);
    }

    @Override
    public ShopPersenter createPresenter() {
        return new ShopPersenter(this);
    }

    @Override
    public void initData() {
        presenter.getcurrent(id);
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
        CurrentBean.DataBean.CurrentCategoryBean currentCategory = currentBean.getData().getCurrentCategory();
        currentlist.add(currentCategory);
        currentImgAdapter.notifyDataSetChanged();

        List<CurrentBean.DataBean.CurrentCategoryBean.SubCategoryListBean> subCategoryList = currentBean.getData().getCurrentCategory().getSubCategoryList();
        sublist.addAll(subCategoryList);
        currentAdapter.notifyDataSetChanged();

        currentAdapter.setOnItemClickListener(new TitleBrandAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Intent intent = new Intent(getActivity(), HomeActivity.class);
                intent.putExtra("id", sublist.get(pos).getId());
                intent.putExtra("name", sublist.get(pos).getName());
                startActivity(intent);
            }
        });
    }
}
