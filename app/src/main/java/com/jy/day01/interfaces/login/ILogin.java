package com.jy.day01.interfaces.login;

import com.jy.day01.interfaces.CallBack;
import com.jy.day01.interfaces.IBasePresenter;
import com.jy.day01.interfaces.IBaseView;
import com.jy.day01.interfaces.IModel;
import com.jy.day01.interfaces.list.IList;
import com.jy.day01.model.bean.Bean;
import com.jy.day01.model.bean.CarBean;
import com.jy.day01.model.bean.LoginBean;

import java.util.HashMap;

public interface ILogin {
    interface View extends IBaseView {
        //定义一个被推荐页实现的View层接口方法
        void getlogin(LoginBean loginBean);

        void getCarList(CarBean carBean);
    }

    interface Persenter extends IBasePresenter<View> {
        //定义一个首页推荐页面V层调用的接口
        void getlogin(String username, String pw);

        void getCarList();
    }

    interface Model extends IModel {
        //定义一个加载推荐数据的接口方法 被P层
        void getlogin(CallBack callBack, String username, String pw);

        void getCarList(CallBack callBack);
    }
}
