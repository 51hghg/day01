package com.jy.day01.interfaces.shop;

import com.jy.day01.interfaces.CallBack;
import com.jy.day01.interfaces.IBasePresenter;
import com.jy.day01.interfaces.IBaseView;
import com.jy.day01.interfaces.IModel;
import com.jy.day01.model.bean.ShopBean;

public interface IShop {
    interface View extends IBaseView {
        //定义一个被推荐页实现的View层接口方法
        void getshop(ShopBean shopBean);
    }

    interface Persenter extends IBasePresenter<View> {
        //定义一个首页推荐页面V层调用的接口
        void getshop();
    }

    interface Model extends IModel {
        //定义一个加载推荐数据的接口方法 被P层
        void getshop(CallBack callBack);
    }
}
