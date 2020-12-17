package com.jy.day01.interfaces;

public interface CallBack<T> {
    void onFaile(String msg);
    void onSuccess(T t);
}
