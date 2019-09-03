package com.swp.cloud.common.test;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-03 4:42 PM
 */
public class PrivateTest {

    private PrivateHelper privateHelper = PrivateHelper.getInstance();

    @Test
    public void test_修改实体私有成员变量的值(){
        PrivateObject object = new PrivateObject();
        privateHelper.setPrivateField(object, "code", "10068");
        System.out.println(object.getCode());
    }

    @Test
    public void test_调用实体私有方法(){
        PrivateObject object = new PrivateObject();
        Method method = privateHelper.findMethod(object, "changeCode");
        Object o = privateHelper.invokePrivateMethod(object, method);
        System.out.println(o);
    }
}
