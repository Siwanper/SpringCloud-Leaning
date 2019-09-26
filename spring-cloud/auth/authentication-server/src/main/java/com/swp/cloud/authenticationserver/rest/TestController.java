package com.swp.cloud.authenticationserver.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-19 5:13 PM
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/role")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String role(){
        return "role system";
    }

    @RequestMapping("/group")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String group(){
        return "group system";
    }

    @RequestMapping("/admin")
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public String admin(){
        return "admin system";
    }

}
