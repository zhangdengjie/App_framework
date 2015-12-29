package com.zdj.app.common.net;


import com.zdj.app.common.JsonResponse;

public class TransactionAsyncHttpJsonHandler extends TransactionAsyncHttpStringHandler {

    /**
     * 自定义http响应处理器json
     *
     * @param mTransactionListener
     */
    public TransactionAsyncHttpJsonHandler(TransactionListener mTransactionListener) {
        super(mTransactionListener);
    }

    @Override
    void sendResponse(String responseString) {
        JsonResponse response = JsonResponse.getResponse(responseString);
        if (response.getCode() == ResponseCode.SUCCESS) {
            super.sendResponse(response.getData());
        } else {
            mTransactionListener.onFailure(response.getCode());
        }
    }
}
