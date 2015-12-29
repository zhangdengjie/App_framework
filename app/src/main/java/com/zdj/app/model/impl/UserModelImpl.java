package com.zdj.app.model.impl;


import com.zdj.app.base.BaseModel;
import com.zdj.app.common.net.TransactionListener;
import com.zdj.app.common.net.URLs;
import com.zdj.app.model.interfaces.IUserModel;
import com.zdj.app.vo.request.LoginRequest;

/**
 * 用户模型实现类
 */
public class UserModelImpl extends BaseModel implements IUserModel {
    @Override
    public void login(LoginRequest loginRequest, TransactionListener transactionListener) {
        post(URLs.LOGIN, loginRequest, transactionListener);
    }
}
