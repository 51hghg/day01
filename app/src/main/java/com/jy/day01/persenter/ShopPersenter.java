package com.jy.day01.persenter;

import com.jy.day01.base.BasePresenter;
import com.jy.day01.interfaces.CallBack;
import com.jy.day01.interfaces.shop.IShop;
import com.jy.day01.model.ShopModel;
import com.jy.day01.model.bean.BrandBean;
import com.jy.day01.model.bean.CategBean;
import com.jy.day01.model.bean.DetailBean;
import com.jy.day01.model.bean.GoodsDetailBean;
import com.jy.day01.model.bean.GoodslistBean;
import com.jy.day01.model.bean.NewBean;
import com.jy.day01.model.bean.ShopBean;
import com.jy.day01.model.bean.SubBean;

import java.util.Map;

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
                if (view != null) {
                    view.tips(msg);
                }
            }

            @Override
            public void onSuccess(Object o) {
                if (view != null) {
                    view.getshop((ShopBean) o);
                }
            }
        });
    }

    @Override
    public void getcateg(int id) {
        model.getcateg(new CallBack() {
            @Override
            public void onFaile(String msg) {
                if (view != null) {
                    view.tips(msg);
                }
            }

            @Override
            public void onSuccess(Object o) {
                if (view != null) {
                    view.getcateg((CategBean) o);
                }
            }
        }, id);
    }

    @Override
    public void getsub(int cid) {
        model.getsub(new CallBack() {
            @Override
            public void onFaile(String msg) {
                if (view != null) {
                    view.tips(msg);
                }
            }

            @Override
            public void onSuccess(Object o) {
                if (view != null) {
                    view.getsub((SubBean) o);
                }
            }
        }, cid);
    }

    @Override
    public void getbrand(int page) {
        model.getbrand(new CallBack() {
            @Override
            public void onFaile(String msg) {
                if (view != null) {
                    view.tips(msg);
                }
            }

            @Override
            public void onSuccess(Object o) {
                if (view != null) {
                    view.getbrand((BrandBean) o);
                }
            }
        }, page);
    }

    @Override
    public void getnew(Map<String, String> map) {
        model.getnew(new CallBack() {
            @Override
            public void onFaile(String msg) {
                if (view != null) {
                    view.tips(msg);
                }
            }

            @Override
            public void onSuccess(Object o) {
                if (view != null) {
                    view.getnew((NewBean) o);
                }
            }
        }, map);
    }

    @Override
    public void getdetail(int id) {
        model.getdetail(new CallBack() {
            @Override
            public void onFaile(String msg) {
                if (view != null) {
                    view.tips(msg);
                }
            }

            @Override
            public void onSuccess(Object o) {
                if (view != null) {
                    view.getdetail((DetailBean) o);
                }
            }
        }, id);
    }

    @Override
    public void getgoodslist(int id) {
        model.getgoodslist(new CallBack() {
            @Override
            public void onFaile(String msg) {
                if (view != null) {
                    view.tips(msg);
                }
            }

            @Override
            public void onSuccess(Object o) {
                if (view != null) {
                    view.getgoodlist((GoodslistBean) o);
                }
            }
        }, id);
    }

    @Override
    public void getgoodsdetail(int id) {
        model.getgoodsdetail(new CallBack() {
            @Override
            public void onFaile(String msg) {
                if (view != null) {
                    view.tips(msg);
                }
            }

            @Override
            public void onSuccess(Object o) {
                if (view != null) {
                    view.getgoodsdetail((GoodsDetailBean) o);
                }
            }
        }, id);
    }
}
