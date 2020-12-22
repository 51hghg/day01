package com.jy.day01.ui.fragment;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jy.day01.R;
import com.jy.day01.base.BaseFragment;
import com.jy.day01.interfaces.login.ILogin;
import com.jy.day01.model.bean.CarBean;
import com.jy.day01.model.bean.LoginBean;
import com.jy.day01.persenter.login.LoginPersenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class GoFragment extends BaseFragment<LoginPersenter> implements ILogin.View {

    @BindView(R.id.recy_good)
    RecyclerView recyGood;
    @BindView(R.id.scrollView)
    NestedScrollView scrollView;
    @BindView(R.id.checkbox_all)
    CheckBox checkboxAll;
    @BindView(R.id.txt_totalPrice)
    TextView txtTotalPrice;
    @BindView(R.id.txt_edit)
    TextView txtEdit;
    @BindView(R.id.txt_submit)
    TextView txtSubmit;
    @BindView(R.id.layout_common)
    ConstraintLayout layoutCommon;
    private ArrayList<CarBean.DataBean.CartListBean> list;
    private CarAdapter carAdapter;

    @Override
    public int getLatout() {
        return R.layout.fragment_go;
    }

    @Override
    public void initView() {
        list = new ArrayList<>();

        recyGood.setLayoutManager(new LinearLayoutManager(getActivity()));
        carAdapter = new CarAdapter(list, getActivity());
        recyGood.setAdapter(carAdapter);
    }

    @Override
    public LoginPersenter createPresenter() {
        return new LoginPersenter(this);
    }

    @Override
    public void initData() {
        presenter.getCarList();
    }

    @Override
    public void getlogin(LoginBean loginBean) {

    }

    @Override
    public void getCarList(CarBean carBean) {
        List<CarBean.DataBean.CartListBean> cartList = carBean.getData().getCartList();
        list.addAll(cartList);
        carAdapter.notifyDataSetChanged();
    }


    @OnClick({R.id.txt_edit, R.id.txt_submit, R.id.checkbox_all})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.txt_edit:
                changeEdit();
                break;
            case R.id.txt_submit:
                break;
            case R.id.checkbox_all:
                if (checkboxAll.isSelected()) {
                    carAdapter.setChecked(true);
                    carAdapter.notifyDataSetChanged();
                }
                break;
        }
    }

    private void changeEdit() {
        if ("编辑".equals(txtEdit.getText().toString())) {
            txtEdit.setText("完成");
            carAdapter.setEditState(true);
            txtSubmit.setText("删除所有");
            carAdapter.notifyDataSetChanged();
        } else if ("完成".equals(txtEdit.getText().toString())) {
            txtEdit.setText("编辑");
            carAdapter.setEditState(false);
            txtSubmit.setText("下单");
            carAdapter.notifyDataSetChanged();
        }
    }

}