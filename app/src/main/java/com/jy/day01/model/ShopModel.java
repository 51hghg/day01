package com.jy.day01.model;

import com.jy.day01.base.BaseModel;
import com.jy.day01.interfaces.CallBack;
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
import com.jy.day01.net.CommonSubscriber;
import com.jy.day01.net.HttpManager;
import com.jy.day01.utils.RxUtils;

import java.util.Map;

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

    @Override
    public void getcateg(CallBack callBack, int id) {
        addDisposable(
                HttpManager.getHttpManager().getShopApi().getcateg(id)
                        .compose(RxUtils.rxScheduler())
                        .subscribeWith(new CommonSubscriber<CategBean>(callBack) {
                            @Override
                            public void onNext(CategBean categBean) {
                                callBack.onSuccess(categBean);
                            }
                        })
        );
    }

    @Override
    public void getsub(CallBack callBack, int cid) {
        addDisposable(
                HttpManager.getHttpManager().getShopApi().getsub(cid)
                        .compose(RxUtils.rxScheduler())
                        .subscribeWith(new CommonSubscriber<SubBean>(callBack) {
                            @Override
                            public void onNext(SubBean subBean) {
                                callBack.onSuccess(subBean);
                            }
                        })
        );
    }

    @Override
    public void getbrand(CallBack callBack, int page) {
        addDisposable(
                HttpManager.getHttpManager().getShopApi().getbrand(page)
                        .compose(RxUtils.rxScheduler())
                        .subscribeWith(new CommonSubscriber<BrandBean>(callBack) {
                            @Override
                            public void onNext(BrandBean brandBean) {
                                callBack.onSuccess(brandBean);
                            }
                        })
        );
    }

    @Override
    public void getnew(CallBack callBack, Map<String, String> map) {
        addDisposable(
                HttpManager.getHttpManager().getShopApi().getnew(map)
                        .compose(RxUtils.rxScheduler())
                        .subscribeWith(new CommonSubscriber<NewBean>(callBack) {
                            @Override
                            public void onNext(NewBean newBean) {
                                callBack.onSuccess(newBean);
                            }
                        })
        );
    }

    @Override
    public void getdetail(CallBack callBack, int id) {
        addDisposable(
                HttpManager.getHttpManager().getShopApi().getdetail(id)
                        .compose(RxUtils.rxScheduler())
                        .subscribeWith(new CommonSubscriber<DetailBean>(callBack) {
                            @Override
                            public void onNext(DetailBean detailBean) {
                                callBack.onSuccess(detailBean);
                            }
                        })
        );
    }

    @Override
    public void getgoodslist(CallBack callBack, int id) {
        addDisposable(
                HttpManager.getHttpManager().getShopApi().getgoodslist(id)
                        .compose(RxUtils.rxScheduler())
                        .subscribeWith(new CommonSubscriber<GoodslistBean>(callBack) {
                            @Override
                            public void onNext(GoodslistBean goodslistBean) {
                                callBack.onSuccess(goodslistBean);
                            }
                        })
        );
    }

    @Override
    public void getgoodsdetail(CallBack callBack, int id) {
        addDisposable(
                HttpManager.getHttpManager().getShopApi().getgoodsdetail(id)
                        .compose(RxUtils.rxScheduler())
                        .subscribeWith(new CommonSubscriber<GoodsDetailBean>(callBack) {
                            @Override
                            public void onNext(GoodsDetailBean goodsDetailBean) {
                                callBack.onSuccess(goodsDetailBean);
                            }
                        })
        );
    }

    @Override
    public void getcategory(CallBack callBack) {
        addDisposable(
                HttpManager.getHttpManager().getShopApi().getcategory()
                        .compose(RxUtils.rxScheduler())
                        .subscribeWith(new CommonSubscriber<CategoryBean>(callBack) {
                            @Override
                            public void onNext(CategoryBean categoryBean) {
                                callBack.onSuccess(categoryBean);
                            }
                        })
        );
    }

    @Override
    public void getcurrent(CallBack callBack, int id) {
        addDisposable(
                HttpManager.getHttpManager().getShopApi().getcurrent(id)
                        .compose(RxUtils.rxScheduler())
                        .subscribeWith(new CommonSubscriber<CurrentBean>(callBack) {
                            @Override
                            public void onNext(CurrentBean currentBean) {
                                callBack.onSuccess(currentBean);
                            }
                        })
        );
    }
}
