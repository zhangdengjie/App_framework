package com.zdj.app.base;

/**
 * 公共View接口
 * IBaseView中封装了常用的View操作,如Toast,进度条等等,并通过BaseActivity实现了,
 * 所以建议所有Activity都继承自BaseActivity以便更好的使用本框架
 *
 * @author Ht
 */
public interface IBaseView {

    /**
     * 显示进度条
     *
     * @param flag    是否可取消
     * @param message 要显示的信息
     */
     void showProgress(boolean flag, String message);

    /**
     * 显示可取消的进度条
     *
     * @param message 要显示的信息
     */
    void showProgress(String message);

    /**
     * 显示可取消的无文字进度条
     */
    void showProgress();

    /**
     * 显示无文字进度条
     *
     * @param flag 是否可取消
     */
    void showProgress(boolean flag);

    /**
     * 隐藏进度条
     */
    void hideProgress();

    /**
     * 根据资源文件id弹出toast
     *
     * @param resId 资源文件id
     */
    void showToast(int resId);

    /**
     * 根据字符串弹出toast
     *
     * @param msg 提示内容
     */
    void showToast(String msg);

    /**
     * 结束当前页面
     */
    void close();
}
