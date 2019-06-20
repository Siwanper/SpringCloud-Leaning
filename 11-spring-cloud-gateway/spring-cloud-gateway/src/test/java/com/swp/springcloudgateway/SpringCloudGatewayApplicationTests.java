package com.swp.springcloudgateway;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.ZonedDateTime;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringCloudGatewayApplicationTests {

    @Test
    public void contextLoads() {
        System.out.println(ZonedDateTime.now());
    }

}
