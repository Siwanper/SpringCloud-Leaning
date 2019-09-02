package com.swp.cloud.common.core.util;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Optional;

/**
 * 描述: 用户上下文
 *
 * @outhor ios
 * @create 2019-09-02 4:42 PM
 */
public class UserContextHolder {

    ThreadLocal<Map<String, String>> threadLocal;

    private UserContextHolder(){
        this.threadLocal = new ThreadLocal<>();
    }

    public static UserContextHolder getInstance(){
         return SingletomContext.instance;
    }

    private static class SingletomContext {
        private static final UserContextHolder instance = new UserContextHolder();
    }

    /**
     * 存入用户信息
     * @param map
     */
    public void setContext(Map<String ,String> map) {
        threadLocal.set(map);
    }

    /**
     * 读取用户信息
     * @return
     */
    public Map<String, String> getContext(){
        return threadLocal.get();
    }

    /**
     * 读取存在上下文中的用户名
     * @return
     */
    public String getUsername(){
        return Optional.ofNullable(threadLocal.get()).orElse(Maps.newHashMap()).get("user_name");
    }

    /**
     * 清空用户上下文
     */
    public void clear(){
        threadLocal.remove();
    }


}
