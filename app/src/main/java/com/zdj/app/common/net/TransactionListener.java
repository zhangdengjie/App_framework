package com.zdj.app.common.net;

/**
 * 事务处理监听
 * TransactionListener该监听是Presenter用于监听Model的处理状态,可接受泛型后在onSuccess(T t)中接受处理结果
 */
public abstract class TransactionListener<T> {
    /**
     * 带数据的成功回调
     *
     * @param data
     */
    public void onSuccess(String data) {

    }

    /**
     * 带错误码的失败回调
     *
     * @param errorCode
     */
    public void onFailure(int errorCode) {
        switch (errorCode) {
            // TODO 自定义处理
        }
    }
}
