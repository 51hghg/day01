package com.jy.day01.ui;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
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
import com.jy.day01.ui.adapter.NewGoodsAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewGoodActivity extends BaseActivity<ShopPersenter> implements IShop.View {

    private static final String ASC = "asc";
    private static final String DESC = "desc";
    private static final String DEFAULT = "default";
    private static final String PRICE = "price";
    private static final String CATEGORY = "category";

    @BindView(R.id.img_hotgood)
    ImageView imgHotgood;
    @BindView(R.id.txt_info)
    TextView txtInfo;
    @BindView(R.id.layout_info)
    ConstraintLayout layoutInfo;
    @BindView(R.id.txt_all)
    TextView txtAll;
    @BindView(R.id.txt_price)
    TextView txtPrice;
    @BindView(R.id.img_arrow_up)
    ImageView imgArrowUp;
    @BindView(R.id.img_arrow_down)
    ImageView imgArrowDown;
    @BindView(R.id.layout_price)
    LinearLayout layoutPrice;
    @BindView(R.id.txt_sort)
    TextView txtSort;
    @BindView(R.id.layout_sort)
    ConstraintLayout layoutSort;
    @BindView(R.id.recy_goodList)
    RecyclerView recyGoodList;

    //是否是新品
    private int isNew = 1;
    private int page = 1;
    private int size = 100;
    private String order;
    private String sort;
    private int categoryId;
    private PopupWindow popupWindow;
    private List<NewBean.DataBeanX.FilterCategoryBean> filterCategory;
    private List<NewBean.DataBeanX.DataBean> data;
    private NewGoodsAdapter newGoodsAdapter;
    private List<NewBean.DataBeanX.GoodsListBean> goodsList;

    @Override
    protected int getLayout() {
        return R.layout.activity_new_good;
    }

    @SuppressLint("ResourceType")
    @Override
    protected void initView() {
        order = ASC;
        sort = DEFAULT;
        categoryId = 0;
        layoutPrice.setTag(0);  //
        txtAll.setTextColor(Color.parseColor(NewGoodActivity.this.getString(R.color.red)));
        data = new ArrayList<>();
        newGoodsAdapter = new NewGoodsAdapter(data, this);
        recyGoodList.setLayoutManager(new GridLayoutManager(this, 2));
        recyGoodList.setAdapter(newGoodsAdapter);
    }

    @Override
    protected ShopPersenter createPersenter() {
        return new ShopPersenter(this);
    }

    @Override
    protected void initData() {
        presenter.getnew(getParam());
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
        NewBean.DataBeanX data = newBean.getData();
        filterCategory = newBean.getData().getFilterCategory();
        this.data.clear();
        List<NewBean.DataBeanX.DataBean> data1 = data.getData();
        this.data.addAll(data1);
        newGoodsAdapter.notifyDataSetChanged();
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

    private HashMap<String, String> getParam() {
        HashMap<String, String> map = new HashMap<>();
        map.put("isNew", String.valueOf(isNew));
        map.put("page", String.valueOf(page));
        map.put("size", String.valueOf(size));
        map.put("order", order);
        map.put("sort", sort);
        map.put("category", String.valueOf(categoryId));
        return map;
    }

    /**
     * 按价格升序排序
     */
    @SuppressLint("ResourceType")
    private void priceStateUp() {
        imgArrowUp.setImageResource(R.drawable.ic_arrow_up_select);
        imgArrowDown.setImageResource(R.drawable.ic_arrow_down_normal);
        txtPrice.setTextColor(Color.parseColor(getString(R.color.red)));
    }

    /**
     * 价格的降序排列
     */
    @SuppressLint("ResourceType")
    private void priceStateDown() {
        imgArrowUp.setImageResource(R.drawable.ic_arrow_up_normal);
        imgArrowDown.setImageResource(R.drawable.ic_arrow_down_select);
        txtPrice.setTextColor(Color.parseColor(getString(R.color.red)));
    }

    /**
     * 重置条件选择的所有状态
     */
    @SuppressLint("ResourceType")
    private void resetPriceState() {
        imgArrowUp.setImageResource(R.drawable.ic_arrow_up_normal);
        imgArrowDown.setImageResource(R.drawable.ic_arrow_down_normal);
        txtPrice.setTextColor(Color.parseColor(getString(R.color.black)));
        txtAll.setTextColor(Color.parseColor(getString(R.color.black)));
        txtSort.setTextColor(Color.parseColor(getString(R.color.black)));
        layoutPrice.setTag(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @SuppressLint("ResourceType")
    @OnClick({R.id.txt_all, R.id.layout_price, R.id.txt_sort})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.txt_all:
                resetPriceState();
                txtAll.setTextColor(Color.parseColor(NewGoodActivity.this.getString(R.color.red)));
                sort = DEFAULT;
                categoryId = 0;
                presenter.getnew(getParam());
                if (popupWindow != null) {
                    popupWindow.dismiss();
                }
                break;
            case R.id.layout_price:
                int tag = (int) layoutPrice.getTag();
                if (tag == 0) {
                    resetPriceState();
                    priceStateUp();
                    layoutPrice.setTag(1);
                    order = ASC;
                } else if (tag == 1) {
                    resetPriceState();
                    priceStateDown();
                    layoutPrice.setTag(0);
                    order = DESC;
                }

                sort = PRICE;
                presenter.getnew(getParam());
                if (popupWindow != null) {
                    popupWindow.dismiss();
                }
                break;
            case R.id.txt_sort:
                resetPriceState();
                txtSort.setTextColor(Color.parseColor(NewGoodActivity.this.getString(R.color.red)));
                sort = CATEGORY;
                presenter.getnew(getParam());
                if (data != null && data.size() > 0) {
                    setPopw();
                }
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void setPopw() {
        Resources res = getResources();
        View inflate = LayoutInflater.from(this).inflate(R.layout.popw, null);
        popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout li1 = inflate.findViewById(R.id.li1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f);
        for (int i = 0; i < filterCategory.size(); i++) {
            View inflate1 = LayoutInflater.from(this).inflate(R.layout.popw_item, null);
            TextView tv = inflate1.findViewById(R.id.item_tv);
            tv.setText(filterCategory.get(i).getName());
            tv.setLayoutParams(layoutParams);
            tv.setGravity(Gravity.CENTER);
            int finalI = i;
            tv.setTag(i);
            inflate1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NewBean.DataBeanX.FilterCategoryBean filterCategoryBean = filterCategory.get(finalI);
                    categoryId = filterCategoryBean.getId();
                    HashMap<String, String> stringStringHashMap = new HashMap<>();
                    stringStringHashMap.put("categoryId", filterCategoryBean.getId() + "");
                    stringStringHashMap.put("isNew", 1 + "");
                    presenter.getnew(stringStringHashMap);
                    popupWindow.dismiss();
                }
            });
            Drawable drawable = res.getDrawable(R.drawable.stroke_black);
            tv.setBackground(drawable);
            li1.addView(tv);
        }
        popupWindow.showAsDropDown(layoutSort, 0, 10);
    }
}