package com.jy.day01.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.jy.day01.R;
import com.jy.day01.base.BaseActivity;
import com.jy.day01.interfaces.login.ILogin;
import com.jy.day01.model.bean.LoginBean;
import com.jy.day01.persenter.login.LoginPersenter;
import com.jy.day01.utils.SpUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPersenter> implements ILogin.View {

    @BindView(R.id.input_username)
    EditText inputUsername;
    @BindView(R.id.input_pw)
    EditText inputPw;
    @BindView(R.id.img_pw)
    ImageView imgPw;
    @BindView(R.id.layout_pw)
    FrameLayout layoutPw;
    @BindView(R.id.btn_login)
    Button btnLogin;

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        imgPw.setTag(1);
    }

    @Override
    protected LoginPersenter createPersenter() {
        return new LoginPersenter(this);
    }

    @Override
    protected void initData() {

    }

    private void login() {
        String username = inputUsername.getText().toString();
        String pw = inputPw.getText().toString();
        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(pw)) {
            presenter.getlogin(username, pw);
        } else {
//            ToastUtils.s(this,getString(R.string.tips_login));
        }
    }

    @Override
    public void getlogin(LoginBean loginBean) {
        if (!TextUtils.isEmpty(loginBean.getData().getToken())) {
            SpUtils.getInstance().setValue("token", loginBean.getData().getToken());
            SpUtils.getInstance().setValue("uid", loginBean.getData().getUserInfo().getUid());
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.img_pw, R.id.btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_pw:
                int tag = (int) imgPw.getTag();
                if(tag == 1){
                    imgPw.setImageResource(R.mipmap.ic_pw_open);
                    imgPw.setTag(2);
                    inputPw.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    imgPw.setImageResource(R.mipmap.ic_pw_close);
                    imgPw.setTag(1);
                    inputPw.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                break;
            case R.id.btn_login:
                login();
                break;
        }
    }
}