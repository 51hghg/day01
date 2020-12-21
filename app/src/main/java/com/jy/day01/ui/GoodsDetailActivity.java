package com.jy.day01.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
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
import com.jy.day01.ui.adapter.InfoAdapter;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GoodsDetailActivity extends BaseActivity<ShopPersenter> implements IShop.View {

    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.txt_assess)
    TextView txtAssess;
    @BindView(R.id.webView)
    WebView webView;
    @BindView(R.id.scrollView)
    NestedScrollView scrollView;
    @BindView(R.id.img_collect)
    ImageView imgCollect;
    @BindView(R.id.layout_collect)
    FrameLayout layoutCollect;
    @BindView(R.id.img_car)
    ImageView imgCar;
    @BindView(R.id.txt_number)
    TextView txtNumber;
    @BindView(R.id.layout_car)
    FrameLayout layoutCar;
    @BindView(R.id.txt_buy)
    TextView txtBuy;
    @BindView(R.id.txt_addCar)
    TextView txtAddCar;
    @BindView(R.id.layout_shop)
    ConstraintLayout layoutShop;
    @BindView(R.id.recycler_info)
    RecyclerView recyclerInfo;

    private String h5 = "<html>\n" +
            "            <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\"/>\n" +
            "            <head>\n" +
            "                <style>\n" +
            "                    p{\n" +
            "                        margin:0px;\n" +
            "                    }\n" +
            "                    img{\n" +
            "                        width:100%;\n" +
            "                        height:auto;\n" +
            "                    }\n" +
            "                </style>\n" +
            "            </head>\n" +
            "            <body>\n" +
            "                word\n" +
            "            </body>\n" +
            "        </html>";
    private int id;
    private ArrayList<GoodsDetailBean.DataBeanX.InfoBean> infolist;
    private InfoAdapter infoAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_goodsdetail;
    }

    @Override
    protected void initView() {
        infolist = new ArrayList<>();

        recyclerInfo.setLayoutManager(new LinearLayoutManager(this));
        infoAdapter = new InfoAdapter(infolist, this);
        recyclerInfo.setAdapter(infoAdapter);
    }

    @Override
    protected ShopPersenter createPersenter() {
        return new ShopPersenter(this);
    }

    @Override
    protected void initData() {
        id = getIntent().getIntExtra("goodid", 0);
        presenter.getgoodsdetail(id);
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
        initGoodDetail(goodsDetailBean.getData().getInfo().getGoods_desc());
        initGallery(goodsDetailBean.getData().getGallery());
        initInfo(goodsDetailBean.getData().getInfo());
    }

    @Override
    public void getcategory(CategoryBean categoryBean) {

    }

    @Override
    public void getcurrent(CurrentBean currentBean) {

    }

    private void initInfo(GoodsDetailBean.DataBeanX.InfoBean list) {
        infolist.add(list);
        infoAdapter.notifyDataSetChanged();
    }

    private void initGallery(List<GoodsDetailBean.DataBeanX.GalleryBean> list) {
        banner.setImages(list).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                GoodsDetailBean.DataBeanX.GalleryBean bean = (GoodsDetailBean.DataBeanX.GalleryBean) path;
                Glide.with(context).load(bean.getImg_url()).into(imageView);
            }
        }).start();
    }

    private void initGoodDetail(String webData) {
//        getHtmlImgs(webData);
        String content = h5.replace("word", webData);
        Log.i("TAG", content);
        webView.loadDataWithBaseURL("about:blank", content, "text/html", "utf-8", null);
    }

//    private void getHtmlImgs(String content){
//        String img = "<img[\\s\\S]*?>";
//        Pattern pattern = Pattern.compile(img);
//        Matcher matcher = pattern.matcher(content);
//        List<String> list = new ArrayList<>();
//        while(matcher.find()){
//            String word = matcher.group();
//            int start = word.indexOf("\"")+1;
//            int end = word.indexOf(".jpg");
//            String url = word.substring(start,end);
//            url = url +".jpg";
//            list.add(url);
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}