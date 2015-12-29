package com.zdj.app.model.interfaces;


import com.zdj.app.common.net.TransactionListener;
import com.zdj.app.vo.request.LoginRequest;

/**
 * 用户模型接口
 */
public interface IUserModel {
    void login(LoginRequest loginRequest, TransactionListener transactionListener);
}
