package com.jy.day01.api;

import com.jy.day01.model.bean.Bean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface ServiceApi {
    String BASE_URL = "http://cdwan.cn:7000/";

    @GET("tongpao/list.json")
    Flowable<Bean> getlist();
}
