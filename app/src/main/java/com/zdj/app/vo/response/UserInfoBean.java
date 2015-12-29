package com.zdj.app.vo.response;

import java.util.List;

/**
 * 用户信息响应实体类
 */
public class UserInfoBean {
    /**
     * 解析的bean的变量名需要和json的key一致 <br/>
     * [] 扩起来的需要定义为public List<T> key(json的key)
     * {} 括起来的需要定义为public B key(自定义的实体类和json的key)
     * created at 2015/12/28 13:09
     */
    public int count;
    public List<UserInfo> users;

    /**
     * 内部嵌套的类必须是static的 <br/>
     * created at 2015/12/28 13:09
     */
    public static class UserInfo{
        public int id;
        public String username;
        public String password;
    }
}
