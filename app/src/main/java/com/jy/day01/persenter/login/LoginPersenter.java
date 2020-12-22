package com.jy.day01.persenter.login;

import com.jy.day01.base.BasePresenter;
import com.jy.day01.interfaces.CallBack;
import com.jy.day01.interfaces.list.IList;
import com.jy.day01.interfaces.login.ILogin;
import com.jy.day01.model.ListModel;
import com.jy.day01.model.bean.Bean;
import com.jy.day01.model.bean.CarBean;
import com.jy.day01.model.bean.LoginBean;
import com.jy.day01.model.login.LoginModel;

public class LoginPersenter extends BasePresenter<ILogin.View> implements ILogin.Persenter {
    ILogin.Model model;
    ILogin.View view;

    public LoginPersenter(ILogin.View view) {
        this.model = new LoginModel();
        this.view = view;
    }

    @Override
    public void getlogin(String username, String pw) {
        model.getlogin(new CallBack() {
            @Override
            public void onFaile(String msg) {
                if (view != null) {
                    view.tips(msg);
                }
            }

            @Override
            public void onSuccess(Object o) {
                if (view != null) {
                    view.getlogin((LoginBean) o);
                }
            }
        }, username, pw);
    }

    @Override
    public void getCarList() {
        model.getCarList(new CallBack() {
            @Override
            public void onFaile(String msg) {
                if (view != null) {
                    view.tips(msg);
                }
            }

            @Override
            public void onSuccess(Object o) {
                if (view != null) {
                    view.getCarList((CarBean) o);
                }
            }
        });
    }
}
