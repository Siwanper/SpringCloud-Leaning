package com.siwanper.test;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 描述: 通过反射技术，设置成员变量的值，调用私有方法。
 *
 * @outhor ios
 * @create 2020-03-28 9:29 AM
 */

public class PrivateHelper {

    private PrivateHelper(){

    }

    public static PrivateHelper getInstance(){
        return SingletPrivateHelper.instance;
    }

    private static class SingletPrivateHelper {
        private static final PrivateHelper instance = new PrivateHelper();
    }

    /**
     * 设置实例的成员变量
     *
     * @param instance
     * @param fieldName
     * @param value
     */
    public void setPrivateField(Object instance, String fieldName, Object value) {
        Field field = ReflectionUtils.findField(instance.getClass(), fieldName);
        ReflectionUtils.makeAccessible(field);
        ReflectionUtils.setField(field, instance, value);
    }

    /**
     * 查找方法，无参数
     *
     * @param instance
     * @param methodName
     * @return
     */
    public Method findMethod(Object instance, String methodName){
        Method method = ReflectionUtils.findMethod(instance.getClass(), methodName);
        return method;
    }

    /**
     * 查找方法，有参数
     *
     * @param instance
     * @param methodName
     * @param paramTypes
     * @return
     */
    public Method findMethod(Object instance, String methodName, Class<?>... paramTypes){
        Method method = ReflectionUtils.findMethod(instance.getClass(), methodName, paramTypes);
        return method;
    }

    /**
     * 将私有方法设置为可访问，并调用
     *
     * @param instance
     * @param method
     * @param args
     * @return
     */
    public Object invokePrivateMethod(Object instance, Method method, Object... args){
        ReflectionUtils.makeAccessible(method);
        return ReflectionUtils.invokeMethod(method, instance, args);
    }


}
