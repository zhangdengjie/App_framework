package com.zdj.app.presenter.impl;

import android.text.TextUtils;

import com.zdj.app.base.BasePresenter;
import com.zdj.app.model.impl.UserModelImpl;
import com.zdj.app.model.interfaces.IUserModel;
import com.zdj.app.presenter.interfaces.ILoginPresenter;
import com.zdj.app.ui.view.interfaces.ILoginView;
import com.zdj.app.utils.CommonUtils;
import com.zdj.app.vo.request.LoginRequest;
import com.zdj.app.common.net.TransactionListener;
import com.zdj.app.vo.response.UserInfoBean;


public class LoginPresenterImpl extends BasePresenter<ILoginView> implements ILoginPresenter {

    IUserModel userModel;

    public LoginPresenterImpl(ILoginView view) {
        super(view);
    }

    @Override
    public void initModel() {
        userModel = new UserModelImpl();
    }

    @Override
    public void login(LoginRequest loginRequest) {
        if(TextUtils.isEmpty(loginRequest.username)){
            mView.showToast("用户名不能为空");
            return;
        }

        if(TextUtils.isEmpty(loginRequest.password)){
            mView.showToast("密码不能为空");
            return;
        }

        userModel.login(loginRequest, new TransactionListener() {
            @Override
            public void onSuccess(String data) {
                UserInfoBean userInfoBean = CommonUtils.getGson().fromJson(data, UserInfoBean.class);
                mView.loginCallback(userInfoBean);
            }
        });
    }
}
