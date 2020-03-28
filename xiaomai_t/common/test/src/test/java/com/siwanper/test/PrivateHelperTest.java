package com.siwanper.test;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2020-03-28 10:08 AM
 */
public class PrivateHelperTest {

    private PrivateHelper instance = PrivateHelper.getInstance();

    @Test
    public void testPrivateFeild_设置对象的私有成员变量的值(){
        PrivateObject object = new PrivateObject();
        instance.setPrivateField(object, "code", "1234");
        String code = object.getCode();
        Assert.assertEquals("1234", code);
    }

    @Test
    public void testPrivateMethod_查找带参数有返回值的私有方法_调用私有方法(){
        PrivateObject object = new PrivateObject();
        Method method = instance.findMethod(object, "changeCode", String.class);
        Object code = instance.invokePrivateMethod(object, method, "qqqq");
        Assert.assertEquals("qqqq", code);
    }

    @Test
    public void testPrivateMethod_查找不带参数没有返回值的私有方法_调用私有方法(){
        PrivateObject object = new PrivateObject();
        Method method = instance.findMethod(object, "changeCode");
        instance.invokePrivateMethod(object, method, null);
        Assert.assertEquals("aaaa", object.getCode());

    }
}
