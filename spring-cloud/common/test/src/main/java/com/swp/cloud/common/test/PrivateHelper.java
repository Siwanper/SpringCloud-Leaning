package com.swp.cloud.common.test;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Ref;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-03 3:43 PM
 */
public class PrivateHelper {

    private PrivateHelper(){

    }

    public static PrivateHelper getInstance(){
        return Singleton.privateHelper;
    }

    private static class Singleton {
        private static final PrivateHelper privateHelper = new PrivateHelper();
    }

    /**
     * 修改私有成员变量
     * @param object
     * @param fieldName
     * @param value
     */
    public void setPrivateField(Object object, String fieldName, String value){
        Field field = ReflectionUtils.findField(object.getClass(), fieldName);
        ReflectionUtils.makeAccessible(field);
        ReflectionUtils.setField(field,object,value);
    }

    /**
     * 查找实体内的无参方法
     * @param object
     * @param methodName
     * @return
     */
    public Method findMethod(Object object, String methodName) {
         return ReflectionUtils.findMethod(object.getClass(), methodName);
    }

    /**
     * 查找实体内代参数的方法
     * @param object
     * @param methodName
     * @param args
     * @return
     */
    public Method findMethod(Object object, String methodName, Class<?>... args){
        return ReflectionUtils.findMethod(object.getClass(), methodName, args);
    }

    /**
     * 将私有方法设置为可执行的，并执行相关方法
     * @param object
     * @param method
     * @param args
     * @return
     */
    public Object invokePrivateMethod(Object object, Method method ,Object... args){
        ReflectionUtils.makeAccessible(method);
        return ReflectionUtils.invokeMethod(method, object, args);
    }


}
