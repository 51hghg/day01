package com.jy.day01.api;

import com.jy.day01.model.bean.ShopBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface ShopApi {
    String BASE_URL = "https://cdplay.cn/";

    @GET("api/index")
    Flowable<ShopBean> getshop();
}
