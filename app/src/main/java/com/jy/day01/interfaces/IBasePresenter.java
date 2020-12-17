package com.jy.day01.interfaces;

public interface IBasePresenter<V extends IBaseView> {
    void  attachView(V view);
    void unArrachView();
}
