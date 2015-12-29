package com.zdj.app.utils;

import android.util.Log;

/**
 * 自定义 打印日志工具
 * <br />
 *  {@link #mIsAbleLog} 控制打印开关<br />
 * Created by Administrator on 2015/3/4.
 */
public  class MyLogUtil{

    /**
     * 默认日志tag <br/>
     * created at 2015/12/27 14:46
     */
    private static final String TAG = "zdj";

    /**
     *  默认提供打印服务
     */
    public  static boolean mIsAbleLog = true ;


    private static final int LEVEL_V = 1 ;
    private static final int LEVEL_I = 2 ;
    private static final int LEVEL_D = 3 ;
    private static final int LEVEL_W = 4 ;
    private static final int LEVEL_E = 5 ;
    private static  int level_flag = 0 ;


    /**
     * 打印 verbose级别
     * @param tag
     * @param msg
     */
    public static void v(String tag, String msg){
        if(mIsAbleLog && level_flag < LEVEL_V ){
            Log.v(tag,msg) ;
        }
    }

    /**
     * 打印 info级别
     * @param tag
     * @param msg
     */
    public static void i(String tag, String msg){
        if(mIsAbleLog && level_flag < LEVEL_I){
            Log.i(tag, msg) ;
        }
    }

    public static void i(String msg){
        if(mIsAbleLog && level_flag < LEVEL_I){
            Log.i(TAG, msg) ;
        }
    }

    /**
     * 打印 debug级别
     * @param tag
     * @param msg
     */
    public static void d(String tag, String msg){
        if(mIsAbleLog && level_flag < LEVEL_D){
            Log.d(tag, msg) ;
        }
    }

    /**
     * 打印 warn级别
     * @param tag
     * @param msg
     */
    public static void w(String tag, String msg){
        if(mIsAbleLog && level_flag < LEVEL_W){
            Log.w(tag, msg) ;
        }
    }

    /**
     * 打印 error级别
     * @param tag
     * @param msg
     */
    public static void e(String tag, String msg){
        if(mIsAbleLog && level_flag < LEVEL_E){
            Log.e(tag, msg) ;
        }
    }
    public static void e(String msg){
        if(mIsAbleLog && level_flag < LEVEL_E){
            Log.e(TAG,msg) ;
        }
    }

    /**
     * 设置打印等级
     * @param level
     */
    public void setLevelFlag(int level){
        level_flag = level ;
    }

}
