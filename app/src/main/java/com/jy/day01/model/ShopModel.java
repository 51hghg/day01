package com.jy.day01.model;

import com.jy.day01.base.BaseModel;
import com.jy.day01.interfaces.CallBack;
import com.jy.day01.interfaces.shop.IShop;
import com.jy.day01.model.bean.ShopBean;
import com.jy.day01.net.CommonSubscriber;
import com.jy.day01.net.HttpManager;
import com.jy.day01.utils.RxUtils;

public class ShopModel extends BaseModel implements IShop.Model {
    @Override
    public void getshop(CallBack callBack) {
        addDisposable(
                HttpManager.getHttpManager().getShopApi().getshop()
                        .compose(RxUtils.rxScheduler())
                        .subscribeWith(new CommonSubscriber<ShopBean>(callBack) {
                            @Override
                            public void onNext(ShopBean shopBean) {
                                callBack.onSuccess(shopBean);
                            }
                        })
        );
    }
}
