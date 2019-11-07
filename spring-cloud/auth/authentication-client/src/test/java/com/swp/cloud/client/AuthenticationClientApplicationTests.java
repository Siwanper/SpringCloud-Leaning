package com.swp.cloud.client;


import com.swp.cloud.client.provider.AuthProvider;
import com.swp.cloud.client.service.IAuthService;
import com.swp.cloud.client.service.impl.AuthServiceImpl;
import com.swp.cloud.common.core.entity.vo.Result;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Field;

import static org.mockito.Mockito.when;

public class AuthenticationClientApplicationTests {


    @InjectMocks
    private IAuthService authService;

    @Mock
    private AuthProvider authProvider;

    private static final String BEARER = "bearer ";

    private static final String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbInJlYWQiXSwib3JnYW5pemF0aW9uIjoiYWRtaW4iLCJleHAiOjE1NzMxMTU5NDMsImF1dGhvcml0aWVzIjpbIkFETUlOIl0sImp0aSI6IjFlOWNiYmYzLTk3YWMtNDRmMy04OWJlLTQ2ZWNmM2U0NTJhOSIsImNsaWVudF9pZCI6InRlc3RfY2xpZW50In0.E62UG61u1_KAsalyOl5pA6loX7YO5TQNVNfPqn7d9d0";

    @Before
    public void before() throws NoSuchFieldException, IllegalAccessException {
        authService = new AuthServiceImpl();
        setInstanceFeild(authService, "signingKey", "testKey");
        setInstanceFeild(authService, "ignorlUrls", "/oauth,/open");
        MockitoAnnotations.initMocks(this);
    }

    public void setInstanceFeild(Object object, String fieldName, Object value) throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(object, value);
    }

    @Test
    public void testInvalideJwtAccessToken_授权服务器通过密码生成的token_输入改token组成的authentication_返回false表示token有效(){
        Assert.assertFalse(authService.invalideJwtAccessToken(BEARER + token));
    }

    @Test
    public void testInvalideJwtAccessToken_授权服务器通过密码生成的token_输入改token但是缺少Bearer头的authentication_返回true表示token无效(){
        Assert.assertTrue(authService.invalideJwtAccessToken(token));
    }

    @Test
    public void testInvalideJwtAccessToken_假如输入随机字符串_返回true表示token无效(){
        Assert.assertTrue(authService.invalideJwtAccessToken("i'm random string"));
    }

    @Test
    public void testInvalideJwtAccessToken_假如修改token的playload信息_返回true表示token无效(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.J1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbInJlYWQiXSwib3JnYW5pemF0aW9uIjoiYWRtaW4iLCJleHAiOjE1NzMxMDcyNjEsImF1dGhvcml0aWVzIjpbIkFETUlOIl0sImp0aSI6ImMwYWU2N2JkLWRhZGYtNDJkNC1iY2IzLWRlYmIxZjU0NzMyNyIsImNsaWVudF9pZCI6InRlc3RfY2xpZW50In0.3-GTMvVIHvLKl2gf768JyUmh6FgDWkqOQAdvuB5rCEs";
        Assert.assertTrue(authService.invalideJwtAccessToken(BEARER + token));
    }

    @Test
    public void testInvalideJwtAccessToken_假如删除token中的signatrue信息_返回true表示token无效(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbInJlYWQiXSwib3JnYW5pemF0aW9uIjoiYWRtaW4iLCJleHAiOjE1NzMxMDcyNjEsImF1dGhvcml0aWVzIjpbIkFETUlOIl0sImp0aSI6ImMwYWU2N2JkLWRhZGYtNDJkNC1iY2IzLWRlYmIxZjU0NzMyNyIsImNsaWVudF9pZCI6InRlc3RfY2xpZW50In0";
        Assert.assertTrue(authService.invalideJwtAccessToken(BEARER + token));
    }

    @Test
    public void testAuthentication_假如输入正确的authentication且有url的访问权限_返回true表示有权限访问(){
        System.out.println(authService.auth(BEARER + token, "/users", "POST"));
//        when(authProvider.auth(BEARER + token, "/users", "POST")).thenReturn(Result.success(true));
//        Assert.assertTrue((Boolean) authService.auth(BEARER + token, "/users", "POST").getData());
    }

}
