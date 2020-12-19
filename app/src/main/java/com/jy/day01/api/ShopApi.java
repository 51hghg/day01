package com.jy.day01.api;

import com.jy.day01.model.bean.BrandBean;
import com.jy.day01.model.bean.CategBean;
import com.jy.day01.model.bean.DetailBean;
import com.jy.day01.model.bean.GoodsDetailBean;
import com.jy.day01.model.bean.GoodslistBean;
import com.jy.day01.model.bean.NewBean;
import com.jy.day01.model.bean.ShopBean;
import com.jy.day01.model.bean.SubBean;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ShopApi {
    String BASE_URL = "https://cdplay.cn/";

    @GET("api/index")
    Flowable<ShopBean> getshop();

    @GET("goods/category")
    Flowable<CategBean> getcateg(@Query("id") int id);

    @GET("api/goods/list")
    Flowable<SubBean> getsub(@Query("categoryId") int cid);

    @GET("api/brand/list")
    Flowable<BrandBean> getbrand(@Query("page") int page);

    @GET("api/goods/list")
    Flowable<NewBean> getnew(@QueryMap Map<String, String> map);

    @GET("api/brand/detail")
    Flowable<DetailBean> getdetail(@Query("id") int id);

    @GET("api/goods/list")
    Flowable<GoodslistBean> getgoodslist(@Query("brandId") int id);

    @GET("api/goods/detail")
    Flowable<GoodsDetailBean> getgoodsdetail(@Query("id") int id);
}
