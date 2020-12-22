package com.jy.day01.api;

import com.jy.day01.model.bean.BrandBean;
import com.jy.day01.model.bean.CategBean;
import com.jy.day01.model.bean.CategoryBean;
import com.jy.day01.model.bean.CurrentBean;
import com.jy.day01.model.bean.DetailBean;
import com.jy.day01.model.bean.GoodsDetailBean;
import com.jy.day01.model.bean.GoodslistBean;
import com.jy.day01.model.bean.LoginBean;
import com.jy.day01.model.bean.NewBean;
import com.jy.day01.model.bean.ShopBean;
import com.jy.day01.model.bean.SubBean;

import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleUnaryOperator;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
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

    @GET("catalog/index")
    Flowable<CategoryBean> getcategory();

    @GET("catalog/current")
    Flowable<CurrentBean> getcurrent(@Query("id") int id);

    @POST("api/auth/login")
    @FormUrlEncoded
    Flowable<LoginBean> getlogin(@Field("username") String username, @Field("password") String pw);

    //添加到购物车
    @POST("api/cart/add")
    @FormUrlEncoded
    Flowable<LoginBean> addCar(@FieldMap HashMap<String,String> map);
}
