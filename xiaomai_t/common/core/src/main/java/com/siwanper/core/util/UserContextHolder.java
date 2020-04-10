package com.siwanper.core.util;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Optional;

/**
 * 描述:
 * 用户上文
 *
 * @outhor ios
 * @create 2020-03-26 2:04 PM
 */
public class UserContextHolder {

    private ThreadLocal<Map<String, String>> threadLocal;

    private UserContextHolder(){
        this.threadLocal = new ThreadLocal<>();
    }

    public static UserContextHolder getInstance(){
        return SingletonHolder.instance;
    }

    private static class SingletonHolder{
        private static final UserContextHolder instance = new UserContextHolder();
    }

    public void setContext(Map<String, String> context){
        threadLocal.set(context);
    }

    public Map<String, String> getContext(){
        return threadLocal.get();
    }

    /**
     * 获取上下文中的用户名称
     *
     * @return
     */
    public String getUsername(){
        return Optional.ofNullable(threadLocal.get()).orElse(Maps.newHashMap()).get("user_name");
    }

    /**
     * 清除
     */
    public void clean(){
        threadLocal.remove();;
    }

}
