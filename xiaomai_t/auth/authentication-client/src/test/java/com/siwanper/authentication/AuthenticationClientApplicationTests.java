package com.siwanper.authentication;


import com.siwanper.authentication.provider.AuthenticationProvider;
import com.siwanper.authentication.service.impl.AuthService;
import com.siwanper.core.entity.vo.Result;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.lang.reflect.Field;

import static org.mockito.Mockito.when;

//MockitoJUnitRunner 用于提供单元测试运行的容器环境
@RunWith(MockitoJUnitRunner.class)
public class AuthenticationClientApplicationTests {

	// 用于标识待测试组件
	@InjectMocks
	private AuthService authService;

	// 用于模拟待测试模块中依赖的外部组件, 也就是authService中 依赖bean
	@Mock
	private AuthenticationProvider authenticationProvider;

	private static final String VALID_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJzaXdhbnBlciIsInNjb3BlIjpbInJlYWQiXSwib3JnYW5pemF0aW9uIjoic2l3YW5wZXIiLCJleHAiOjE1ODg5OTk0NTUsImF1dGhvcml0aWVzIjpbIklUIl0sImp0aSI6Ijc2ZGExNTA2LTVhOWQtNDkzOS04ZWVkLTYwM2EzNTAxNzZjNSIsImNsaWVudF9pZCI6InRlc3RfY2xpZW50In0.VJdSzxIT-tZdtl6S3Ppd916pZTM9lae0RxjIlDFKo3E";
	private static final String BEARER = "Bearer ";

	@Before
	public void before() throws NoSuchFieldException, IllegalAccessException {

		authService = new AuthService();
		setInstancePrivateField(authService, "signingKey", "123456");
		setInstancePrivateField(authService, "ignoreUrls", "/oauth,/open");

		//用于初始化@Mock注解修饰的组件，注意需要先创建AuthService对象，否则会出现空指针异常。
		MockitoAnnotations.initMocks(this);
	}

	void setInstancePrivateField(Object instance, String fieldname, Object fielvalue) throws NoSuchFieldException, IllegalAccessException {
		Field field = instance.getClass().getDeclaredField(fieldname);
		field.setAccessible(true);
		field.set(instance, fielvalue);
	}

	// JWT 包含 header.payload.signature
	@Test
	public void testInvalidJwtAccessToken_假如授权服务器通过给定的密钥生成token_当输入该token组成的authentication_那么返回false表示token有效(){
		Assert.assertFalse(authService.invalidTokenAccess(BEARER + VALID_TOKEN));
	}

	@Test
	public void testInvalidJwtAccessToken_假如token是随机字符串_当输入该token_那么返回true表示token无效(){
		String authentication = "i'm random token";
		Assert.assertTrue(authService.invalidTokenAccess(authentication));
	}

	@Test
	public void testInvalidJwtAccessToken_假如有人获取了用户的token_当输入篡改过的payload信息_那么返回true表示token无效(){
		String authentication = BEARER + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.JzaXdhbnBlciIsInNjb3BlIjpbInJlYWQiXSwib3JnYW5pemF0aW9uIjoic2l3YW5wZXIiLCJleHAiOjE1ODg5Mzg1OTQsImF1dGhvcml0aWVzIjpbIklUIl0sImp0aSI6Ijc4MTdkMTI4LTE0NTYtNDdiYy05YzhkLTNiM2JjNDcyYmNlNyIsImNsaWVudF9pZCI6InRlc3RfY2xpZW50In0.NgCOFrL5Xwdp7F8xTEiNfk1cumNIeAxO7tfF8LwUq7k";
		Assert.assertTrue(authService.invalidTokenAccess(authentication));
	}

	@Test
	public void testInvalidJwtAccessToken_假如有人获取了用户token_当输入的token去掉了signature_那么返回true表示token无效(){
		String authentication = BEARER + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJzaXdhbnBlciIsInNjb3BlIjpbInJlYWQiXSwib3JnYW5pemF0aW9uIjoic2l3YW5wZXIiLCJleHAiOjE1ODg5Mzg1OTQsImF1dGhvcml0aWVzIjpbIklUIl0sImp0aSI6Ijc4MTdkMTI4LTE0NTYtNDdiYy05YzhkLTNiM2JjNDcyYmNlNyIsImNsaWVudF9pZCI6InRlc3RfY2xpZW50In0";
		Assert.assertTrue(authService.invalidTokenAccess(authentication));
	}

	@Test
	public void testAuthenticate_假如用户authenticate正确且有对请求url的POST权限_当用户请求url的POST_那么返回成功有权限(){
		// 模拟authenticationProvider，请求数据
		when(authenticationProvider.decide(BEARER + VALID_TOKEN, "/user/add", "POST")).thenReturn(Result.success(true));
		Assert.assertTrue((Boolean) authService.authentication(BEARER + VALID_TOKEN, "/user/add", "POST").getData());
	}

	@Test
	public void testAuthenticate_假如用户authentication正确且有对请求url的POST权限_当用户请求该url的GET_那么返回成功无权限() {
		// 模拟authenticationProvider，请求数据
		when(authenticationProvider.decide(BEARER + VALID_TOKEN, "/user/add", "GET")).thenReturn(Result.success(false));
		Assert.assertFalse((Boolean) authService.authentication(BEARER + VALID_TOKEN, "/user/add", "GET").getData());
	}

	@Test
	public void testHasPermission_假如传入无效的token_那么返回无权限(){
		Assert.assertFalse(authService.hasPermission("invalid token", "/user/add", "POST"));
	}

	@Test
	public void testHasPermission_假如用户authenticate正确且有对请求url的POST权限_当用户请求url的POST_那么返回成功有权限(){
		// 模拟authenticationProvider，请求数据
		when(authenticationProvider.decide(BEARER + VALID_TOKEN, "/user/add", "POST")).thenReturn(Result.success(true));
		Assert.assertTrue(authService.hasPermission(BEARER + VALID_TOKEN, "/user/add", "POST"));
	}

	@Test
	public void testHasPermission_假如用户authentication正确且有对请求url的POST权限_当用户请求该url的GET_那么返回成功无权限() {
		// 模拟authenticationProvider，请求数据
		when(authenticationProvider.decide(BEARER + VALID_TOKEN, "/user/add", "GET")).thenReturn(Result.success(false));
		Assert.assertFalse( authService.hasPermission(BEARER + VALID_TOKEN, "/user/add", "GET"));
	}

	@Test
	public void testIgnoreAuthentication_假如配置的忽略前缀为oauth和open_当用户请求以oauth开头的url_那么返回true(){
		Assert.assertTrue(authService.ignoreAuthentication("/oauth/decide"));
	}

	@Test
	public void testIgnoreAuthentication_假如配置的忽略前缀为oauth和open_当用户请求以open开头的url_那么返回true(){
		Assert.assertTrue(authService.ignoreAuthentication("/open"));
	}

	@Test
	public void testIgnoreAuthentication_假如配置的忽略前缀为oauth和open_当用户请求以test开头的url_那么返回false(){
		Assert.assertFalse(authService.ignoreAuthentication("/test"));
	}

	@Test
	public void testIgnoreAuthentication_假如配置的忽略前缀为oauth和open_当用户请求以open结尾的url_那么返回false(){
		Assert.assertFalse(authService.ignoreAuthentication("/test/open"));
	}
}
