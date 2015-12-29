package com.zdj.app.base;

import android.content.Context;

import com.squareup.okhttp.internal.http.HttpStream;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

import cz.msebera.android.httpclient.protocol.HTTP;

/**
 * 基于第三方网络框架封装的网络访问类
 * 网络访问控制中心 用于统一管理网络访问及初始化网络相关配置
 *
 * @author
 */
public abstract class BaseNetCenter {
    protected final static String HOST = "zdj.ngrok.natapp.cn";
    protected static String API_URL = "http://zdj.ngrok.natapp.cn/%s";

    protected static final int GET = 1;
    protected static final int POST = 2;
    protected static final int PUT = 3;
    protected static final int DELETE = 4;

    protected Map<String, String> baseHeader;

    // 连接超时时间
    protected static final int CONNECT_TIMEOUT = 15 * 1000;
    // 最大连接数
    protected static final int MAX_CONNECTIONS = 15;
    // 失败重连次数
    protected static final int MAX_RETRIES = 3;
    // 失败重连间隔时间
    protected static final int RETRIES_TIMEOUT = 5 * 1000;
    // 响应超时时间
    protected static final int RESPONSE_TIMEOUT = 15 * 1000;
    // 默认编码
    public static final String CONTENT_ENCODING = "UTF-8";
    // 默认Content-Type
    public static final String DEFAULT_CONTENT_TYPE = "application/json";

    protected BaseNetCenter() {
        initBaseHeaders();
        initHttpClient();
    }

    /**
     * 初始化网络请求工具类
     */
    protected abstract void initHttpClient();

    /**
     * 移除所有请求头
     */
    protected abstract void removeAllHeaders();

    /**
     * 初始化公共请求头
     */
    protected void initBaseHeaders() {
        baseHeader = new HashMap<>();
        BaseRequestHeader baseRequestHeader = new BaseRequestHeader();
        Map<String, String> mapParams = baseRequestHeader.getMapParams();
        if(mapParams != null){
            baseHeader = mapParams;
        }
    }

    /**
     * 设置一个请求头(如果存在则覆盖)
     *
     * @param header
     * @param value
     */
    public void setHeader(String header, String value) {
        baseHeader.put(header, value);
    }

    /**
     * 移除指定请求头
     *
     * @param header
     */
    public void removeHeader(String header) {
        baseHeader.remove(header);
    }

    /**
     * 取消指定Context的请求队列
     */
    public abstract void clearRequestQueue(Context context);
}
