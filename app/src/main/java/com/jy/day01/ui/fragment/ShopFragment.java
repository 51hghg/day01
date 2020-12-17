package com.jy.day01.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jy.day01.HomeActivity;
import com.jy.day01.R;
import com.jy.day01.base.BaseFragment;
import com.jy.day01.interfaces.shop.IShop;
import com.jy.day01.model.bean.ShopBean;
import com.jy.day01.persenter.ShopPersenter;
import com.jy.day01.ui.adapter.BrandAdapter;
import com.jy.day01.ui.adapter.CategAdapter;
import com.jy.day01.ui.adapter.HotAdapter;
import com.jy.day01.ui.adapter.NewAdapter;
import com.jy.day01.ui.adapter.TopicAdapter;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ShopFragment extends BaseFragment<ShopPersenter> implements IShop.View {


    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.layout_tab)
    LinearLayout layoutTab;
    @BindView(R.id.recy_brand)
    RecyclerView recyBrand;
    @BindView(R.id.recy_newgood)
    RecyclerView recyNewgood;
    @BindView(R.id.txt_hotgood_title)
    TextView txtHotgoodTitle;
    @BindView(R.id.recy_hotgood)
    RecyclerView recyHotgood;
    @BindView(R.id.txt_topicgood_title)
    TextView txtTopicgoodTitle;
    @BindView(R.id.recy_topicgood)
    RecyclerView recyTopicgood;
    @BindView(R.id.recy_categgood)
    LinearLayout recyCateggood;
    @BindView(R.id.action_up_btn)
    LinearLayout actionUpBtn;
    private ArrayList<ShopBean.DataBean.NewGoodsListBean> newlist;
    private NewAdapter newAdapter;
    private ArrayList<ShopBean.DataBean.HotGoodsListBean> hotlist;
    private HotAdapter hotAdapter;
    private ArrayList<ShopBean.DataBean.BrandListBean> brandlist;
    private BrandAdapter channelAdapter;
    private ArrayList<ShopBean.DataBean.TopicListBean> topiclist;
    private TopicAdapter topicAdapter;
    private ArrayList<ShopBean.DataBean.CategoryListBean> categlist;
    private CategAdapter categAdapter;
    private static final String TAG = "ShopFragment";

    @Override
    public int getLatout() {
        return R.layout.fragment_shop;
    }

    @Override
    public void initView() {
        newlist = new ArrayList<>();
        hotlist = new ArrayList<>();
        brandlist = new ArrayList<>();
        topiclist = new ArrayList<>();
        categlist = new ArrayList<>();

        recyNewgood.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        newAdapter = new NewAdapter(newlist, getActivity());
        recyNewgood.setAdapter(newAdapter);

        recyHotgood.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyHotgood.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        hotAdapter = new HotAdapter(hotlist, getActivity());
        recyHotgood.setAdapter(hotAdapter);

        recyBrand.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        channelAdapter = new BrandAdapter(brandlist, getActivity());
        recyBrand.setAdapter(channelAdapter);

        recyTopicgood.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        topicAdapter = new TopicAdapter(topiclist, getActivity());
        recyTopicgood.setAdapter(topicAdapter);

//        recyCateggood.setLayoutManager(new GridLayoutManager(getActivity(), 2));
//        categAdapter = new CategAdapter(categlist, getActivity());
//        recyCateggood.setAdapter(categAdapter);
    }

    @Override
    public ShopPersenter createPresenter() {
        return new ShopPersenter(this);
    }

    @Override
    public void initData() {
        presenter.getshop();
    }

    @Override
    public void getshop(ShopBean shopBean) {
        if (shopBean.getData() != null) {
            initBanner(shopBean.getData().getBanner());
            initBrand(shopBean.getData().getBrandList());
            initNew(shopBean.getData().getNewGoodsList());
            initHot(shopBean.getData().getHotGoodsList());
            initTopic(shopBean.getData().getTopicList());
            initCateg(shopBean.getData().getCategoryList());
            initChannel(shopBean.getData().getChannel());
        }
    }

    private void initChannel(List<ShopBean.DataBean.ChannelBean> list) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
        for (int i = 0; i < list.size(); i++) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_tab, null);
            TextView text = view.findViewById(R.id.txt_home_title);
            text.setText(list.get(i).getName());
            ImageView image = view.findViewById(R.id.image);
            Glide.with(getActivity()).load(list.get(i).getIcon_url()).into(image);
            view.setLayoutParams(layoutParams);
            layoutTab.addView(view);

            int finalI = i;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getActivity(), HomeActivity.class));
                }
            });
        }
    }

    private void initCateg(List<ShopBean.DataBean.CategoryListBean> list) {
        for (int i = 0; i < list.size(); i++) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_category, null);
            TextView text = view.findViewById(R.id.txt_home_title);
            text.setText(list.get(i).getName());
            RecyclerView recy_home = view.findViewById(R.id.recy_home);
            List<ShopBean.DataBean.CategoryListBean.GoodsListBean> goodsList = list.get(i).getGoodsList();
            recy_home.setLayoutManager(new GridLayoutManager(getActivity(), 2));
            categAdapter = new CategAdapter(goodsList, getActivity());
            recy_home.setAdapter(categAdapter);
            recyCateggood.addView(view);
        }
    }

    private void initTopic(List<ShopBean.DataBean.TopicListBean> list) {
        topiclist.addAll(list);
        topicAdapter.notifyDataSetChanged();
    }

    private void initNew(List<ShopBean.DataBean.NewGoodsListBean> list) {
        newlist.addAll(list);
        newAdapter.notifyDataSetChanged();
    }

    private void initHot(List<ShopBean.DataBean.HotGoodsListBean> list) {
        hotlist.addAll(list);
        hotAdapter.notifyDataSetChanged();
    }

    private void initBrand(List<ShopBean.DataBean.BrandListBean> list) {
        brandlist.addAll(list);
        channelAdapter.notifyDataSetChanged();
    }

    private void initBanner(List<ShopBean.DataBean.BannerBean> list) {
        banner.setImages(list).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                ShopBean.DataBean.BannerBean bean = (ShopBean.DataBean.BannerBean) path;
                Glide.with(context).load(bean.getImage_url()).into(imageView);
            }
        }).start();
    }
}