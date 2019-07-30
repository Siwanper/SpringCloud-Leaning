package com.swp.oauth.repository;

import com.swp.oauth.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-07-30 10:47 AM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserJPATest {

    @Autowired
    private UserJPA userJPA;

    @Test
    public void user(){

        User user = userJPA.findByUsername("admin");
        System.out.println(user);
    }

    @Test
    public void password(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode("123456");
        System.out.println(encode);
    }

}
