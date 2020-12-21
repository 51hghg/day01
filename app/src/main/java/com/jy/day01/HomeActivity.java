package com.jy.day01;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
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
import com.jy.day01.ui.MyViewPager;
import com.jy.day01.ui.fragment.SubFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity<ShopPersenter> implements IShop.View {
    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.viewpager)
    MyViewPager viewpager;
    private int id;

    @Override
    protected int getLayout() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected ShopPersenter createPersenter() {
        return new ShopPersenter(this);
    }

    @Override
    protected void initData() {
        presenter.getshop();
        id = getIntent().getIntExtra("id", 0);
        presenter.getcateg(id);
    }

    @Override
    public void getshop(ShopBean shopBean) {
        initCateg(shopBean.getData().getCategoryList());
    }

    @Override
    public void getcateg(CategBean categBean) {
        List<CategBean.DataBean.BrotherCategoryBean> brotherCategory = categBean.getData().getBrotherCategory();
        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < brotherCategory.size(); i++) {
            SubFragment subFragment = new SubFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("id", (int) brotherCategory.get(i).getId());
            subFragment.setArguments(bundle);
            fragments.add(subFragment);
        }

        viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });

        tablayout.setupWithViewPager(viewpager);

        for (int i = 0; i < brotherCategory.size(); i++) {
            tablayout.getTabAt(i).setText(brotherCategory.get(i).getName());
            Intent intent = getIntent();
            String name = intent.getStringExtra("name");
            if (name.equals(brotherCategory.get(i).getName())) {
                tablayout.getTabAt(i).select();
            }
        }
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

    }

    private void initCateg(List<ShopBean.DataBean.CategoryListBean> list) {
//        List<Fragment> fragments = new ArrayList<>();
//        for (int i = 0; i < list.size(); i++) {
//            SubFragment subFragment = new SubFragment();
//            Bundle bundle = new Bundle();
//            bundle.putInt("id", (int) list.get(i).getId());
//            subFragment.setArguments(bundle);
//            fragments.add(subFragment);
//        }
//
//        viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
//            @NonNull
//            @Override
//            public Fragment getItem(int position) {
//                return fragments.get(position);
//            }
//
//            @Override
//            public int getCount() {
//                return fragments.size();
//            }
//        });
//
//        tablayout.setupWithViewPager(viewpager);
//
//        for (int i = 0; i < list.size(); i++) {
//            tablayout.getTabAt(i).setText(list.get(i).getName());
//            Intent intent = getIntent();
//            String name = intent.getStringExtra("name");
//            if (name.equals(list.get(i).getName())) {
//                tablayout.getTabAt(i).select();
//            }
//        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}