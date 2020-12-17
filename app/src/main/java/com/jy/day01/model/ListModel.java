package com.jy.day01.model;

import com.jy.day01.model.bean.Bean;
import com.jy.day01.base.BaseModel;
import com.jy.day01.interfaces.CallBack;
import com.jy.day01.interfaces.list.IList;
import com.jy.day01.net.CommonSubscriber;
import com.jy.day01.net.HttpManager;
import com.jy.day01.utils.RxUtils;

public class ListModel extends BaseModel implements IList.Model {

    @Override
    public void getlist(CallBack callBack) {
        addDisposable(
                HttpManager.getHttpManager().getServiceApi().getlist()
                        .compose(RxUtils.rxScheduler())
                        .subscribeWith(new CommonSubscriber<Bean>(callBack) {
                            @Override
                            public void onNext(Bean bean) {
                                callBack.onSuccess(bean);
                            }
                        })
        );
    }
}
