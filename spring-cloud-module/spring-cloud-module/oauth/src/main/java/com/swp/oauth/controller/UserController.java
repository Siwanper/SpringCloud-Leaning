package com.swp.oauth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-07-26 5:52 PM
 */
@RestController
@RequestMapping("/")
public class UserController {

    @GetMapping(value = "/current")
    public Principal getUser(Principal principal) {
        return principal;
    }
}

