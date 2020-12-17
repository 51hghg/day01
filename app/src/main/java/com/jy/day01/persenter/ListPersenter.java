package com.jy.day01.persenter;

import com.jy.day01.model.bean.Bean;
import com.jy.day01.base.BasePresenter;
import com.jy.day01.interfaces.CallBack;
import com.jy.day01.interfaces.list.IList;
import com.jy.day01.model.ListModel;

public class ListPersenter extends BasePresenter<IList.View> implements IList.Persenter {

    IList.Model model;
    IList.View view;

    public ListPersenter(IList.View view) {
        this.view = view;
        model = new ListModel();
    }

    @Override
    public void getlist() {
        model.getlist(new CallBack() {
            @Override
            public void onFaile(String msg) {
                if (view != null) {
                    view.tips(msg);
                }

            }

            @Override
            public void onSuccess(Object o) {
                if (view != null) {
                    view.getlist((Bean) o);
                }
            }
        });
    }
}
