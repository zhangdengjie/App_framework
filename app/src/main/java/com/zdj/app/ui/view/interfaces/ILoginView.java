package com.zdj.app.ui.view.interfaces;


import com.zdj.app.base.IBaseView;
import com.zdj.app.vo.response.UserInfoBean;

/**
 * 用户登录View接口
 */
public interface ILoginView extends IBaseView {
    /**
     * 登录成功视图回调
     * @param userInfoBean
     */
    void loginCallback(UserInfoBean userInfoBean);
}
