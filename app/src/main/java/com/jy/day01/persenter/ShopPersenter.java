package com.jy.day01.persenter;

import com.jy.day01.base.BasePresenter;
import com.jy.day01.interfaces.CallBack;
import com.jy.day01.interfaces.shop.IShop;
import com.jy.day01.model.ShopModel;
import com.jy.day01.model.bean.ShopBean;

public class ShopPersenter extends BasePresenter<IShop.View> implements IShop.Persenter {

    IShop.Model model;
    IShop.View view;

    public ShopPersenter(IShop.View view) {
        this.view = view;
        model = new ShopModel();
    }

    @Override
    public void getshop() {
        model.getshop(new CallBack() {
            @Override
            public void onFaile(String msg) {
                if (view!=null){
                    view.tips(msg);
                }
            }

            @Override
            public void onSuccess(Object o) {
                if (view!=null){
                    view.getshop((ShopBean) o);
                }
            }
        });
    }
}
