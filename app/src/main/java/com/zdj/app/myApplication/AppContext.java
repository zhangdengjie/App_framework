package com.zdj.app.myApplication;

import android.support.multidex.MultiDexApplication;

import com.zdj.app.BuildConfig;

/**
 * Application本身在一个应用中只会存在一个实例，所以它一般用来存储一些全局的变量和一些只需要处理一次的数据。
 * Created by dengjie on 2015/12/25.
 */
public class AppContext{

    /**
     * 在输出日志、错误消息的时候有用 <br/>
     * notice:BuildConfig类是自动生成的
     * created at 2015/12/25 16:26
     */
    public final static boolean DEBUG = BuildConfig.DEBUG;

    /**
     * TODO 初始化和记录一些app信息，例如app的版本信息、设备信息等等 <br/>
     * created at 2015/12/25 16:23
     */
    
    /**
     * TODO 初始化特定的业务需求，例如有盟统计类、分享SDK、推送等等 <br/>
     * created at 2015/12/25 16:24
     */
    
    /**
     * TODO 记录应用启动次数、是否第一次安装等等，如果在第一个版本不加，到后面版本使用次记录会很麻烦 <br/>
     * created at 2015/12/25 16:24
     */
}
