package com.jy.day01.model.login;

import com.jy.day01.base.BaseModel;
import com.jy.day01.interfaces.CallBack;
import com.jy.day01.interfaces.login.ILogin;
import com.jy.day01.interfaces.shop.IShop;
import com.jy.day01.model.bean.Bean;
import com.jy.day01.model.bean.LoginBean;
import com.jy.day01.net.CommonSubscriber;
import com.jy.day01.net.HttpManager;
import com.jy.day01.utils.RxUtils;

import java.util.HashMap;
import java.util.Map;

public class LoginModel extends BaseModel implements ILogin.Model {

    @Override
    public void getlogin(CallBack callBack, String username, String pw) {
        addDisposable(
                HttpManager.getHttpManager().getShopApi().getlogin(username,pw)
                        .compose(RxUtils.rxScheduler())
                        .subscribeWith(new CommonSubscriber<LoginBean>(callBack) {
                            @Override
                            public void onNext(LoginBean loginBean) {
                                callBack.onSuccess(loginBean);
                            }
                        })
        );
    }
}
