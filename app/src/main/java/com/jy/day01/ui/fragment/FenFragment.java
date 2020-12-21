package com.jy.day01.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

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
import com.jy.day01.ui.adapter.FragTabAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import q.rorbin.verticaltablayout.VerticalTabLayout;

public class FenFragment extends BaseFragment<ShopPersenter> implements IShop.View {


    @BindView(R.id.tab)
    VerticalTabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;

    @Override
    public int getLatout() {
        return R.layout.fragment_fen;
    }

    @Override
    public void initView() {

    }

    @Override
    public ShopPersenter createPresenter() {
        return new ShopPersenter(this);
    }

    @Override
    public void initData() {
        presenter.getcategory();
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
        final ArrayList<String> tabName = new ArrayList<>();
        final ArrayList<Fragment> fragments = new ArrayList<>();
        List<CategoryBean.DataBean.CategoryListBean> categoryList = categoryBean.getData().getCategoryList();

        for (int i = 0; i < categoryList.size(); i++) {
            CategoryTabFragment categoryTabFragment = new CategoryTabFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("id", (int) categoryList.get(i).getId());
            categoryTabFragment.setArguments(bundle);
            fragments.add(categoryTabFragment);
            tabName.add(categoryList.get(i).getName());
        }
        FragTabAdapter fragTabAdapter = new FragTabAdapter(getChildFragmentManager(), fragments,
                tabName);
        vp.setAdapter(fragTabAdapter);
        tab.setupWithViewPager(vp);
    }

    @Override
    public void getcurrent(CurrentBean currentBean) {

    }
}