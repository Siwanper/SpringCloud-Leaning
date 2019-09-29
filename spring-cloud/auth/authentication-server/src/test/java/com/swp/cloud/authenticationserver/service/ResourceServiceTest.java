package com.swp.cloud.authenticationserver.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-29 12:16 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ResourceServiceTest {

    @Autowired
    private IResourceService resourceService;

    @Test
    public void resource(){
        Map<RequestMatcher, ConfigAttribute> resources = resourceService.loadAllResources();
        System.out.println(resources);
    }
}
