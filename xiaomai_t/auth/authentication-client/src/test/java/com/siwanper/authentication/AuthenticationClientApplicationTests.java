package com.siwanper.authentication;


import com.siwanper.authentication.provider.AuthenticationProvider;
import com.siwanper.authentication.service.impl.AuthService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.lang.reflect.Field;

//MockitoJUnitRunner 用于提供单元测试运行的容器环境
@RunWith(MockitoJUnitRunner.class)
public class AuthenticationClientApplicationTests {

	// 用于模拟待测试模块中依赖的外部组件, 也就是authService中 依赖bean
	@Mock
	private AuthenticationProvider authenticationProvider;

	// 用于标识待测试组件
	@InjectMocks
	private AuthService authService;

	private static final String VALID_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJzaXdhbnBlciIsInNjb3BlIjpbInJlYWQiXSwib3JnYW5pemF0aW9uIjoic2l3YW5wZXIiLCJleHAiOjE1ODg5Mzg1OTQsImF1dGhvcml0aWVzIjpbIklUIl0sImp0aSI6Ijc4MTdkMTI4LTE0NTYtNDdiYy05YzhkLTNiM2JjNDcyYmNlNyIsImNsaWVudF9pZCI6InRlc3RfY2xpZW50In0.NgCOFrL5Xwdp7F8xTEiNfk1cumNIeAxO7tfF8LwUq7k";
	private static final String BEARER = "Bearer ";

	@Before
	public void before() throws NoSuchFieldException, IllegalAccessException {
		//用于初始化@Mock注解修饰的组件
		MockitoAnnotations.initMocks(this);

		authService = new AuthService();
		setInstancePrivateField(authService, "signingKey", "123456");
		setInstancePrivateField(authService, "ignoreUrls", "/oauth,/open");
	}

	void setInstancePrivateField(Object instance, String fieldname, Object fielvalue) throws NoSuchFieldException, IllegalAccessException {
		Field field = instance.getClass().getDeclaredField(fieldname);
		field.setAccessible(true);
		field.set(instance, fielvalue);
	}

	@Test
	public void testInvalidJwtAccessToken_假如授权服务器通过给定的密钥生成token_当输入该token组成的authentication_那么返回false标识token有效(){
		Assert.assertFalse(authService.invalidTokenAccess(BEARER + VALID_TOKEN));
	}


}
