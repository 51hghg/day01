package com.jy.day01.interfaces.list;

import com.jy.day01.model.bean.Bean;
import com.jy.day01.interfaces.CallBack;
import com.jy.day01.interfaces.IBasePresenter;
import com.jy.day01.interfaces.IBaseView;
import com.jy.day01.interfaces.IModel;

public interface IList {
    interface View extends IBaseView {
        //定义一个被推荐页实现的View层接口方法
        void getlist(Bean bean);
    }

    interface Persenter extends IBasePresenter<View> {
        //定义一个首页推荐页面V层调用的接口
        void getlist();
    }

    interface Model extends IModel {
        //定义一个加载推荐数据的接口方法 被P层
        void getlist(CallBack callBack);
    }

}
