package com.jy.day01.interfaces.shop;

import com.jy.day01.interfaces.CallBack;
import com.jy.day01.interfaces.IBasePresenter;
import com.jy.day01.interfaces.IBaseView;
import com.jy.day01.interfaces.IModel;
import com.jy.day01.model.bean.BrandBean;
import com.jy.day01.model.bean.CategBean;
import com.jy.day01.model.bean.DetailBean;
import com.jy.day01.model.bean.GoodsDetailBean;
import com.jy.day01.model.bean.GoodslistBean;
import com.jy.day01.model.bean.NewBean;
import com.jy.day01.model.bean.ShopBean;
import com.jy.day01.model.bean.SubBean;

import java.util.Map;

public interface IShop {
    interface View extends IBaseView {
        //定义一个被推荐页实现的View层接口方法
        void getshop(ShopBean shopBean);

        void getcateg(CategBean categBean);

        void getsub(SubBean subBean);

        void getbrand(BrandBean brandBean);

        void getnew(NewBean newBean);

        void getdetail(DetailBean detailBean);

        void getgoodlist(GoodslistBean goodslistBean);

        void getgoodsdetail(GoodsDetailBean goodsDetailBean);
    }

    interface Persenter extends IBasePresenter<View> {
        //定义一个首页推荐页面V层调用的接口
        void getshop();

        void getcateg(int id);

        void getsub(int cid);

        void getbrand(int page);

        void getnew(Map<String, String> map);

        void getdetail(int id);

        void getgoodslist(int id);

        void getgoodsdetail(int id);
    }

    interface Model extends IModel {
        //定义一个加载推荐数据的接口方法 被P层
        void getshop(CallBack callBack);

        void getcateg(CallBack callBack, int id);

        void getsub(CallBack callBack, int cid);

        void getbrand(CallBack callBack, int page);

        void getnew(CallBack callBack, Map<String, String> map);

        void getdetail(CallBack callBack, int id);

        void getgoodslist(CallBack callBack, int id);

        void getgoodsdetail(CallBack callBack, int id);
    }
}
