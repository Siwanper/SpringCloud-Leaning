package com.swp.cloud.authenticationserver.rest;

import com.swp.cloud.authenticationserver.service.IAuthenticationService;
import com.swp.cloud.common.core.entity.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-29 3:01 PM
 */
@RestController
@RequestMapping
public class AuthenticationController {

    @Autowired
    private IAuthenticationService authenticationService;

    @RequestMapping(value = "/auth/permission", method = RequestMethod.POST)
    public Result decide(@RequestParam String url, @RequestParam String method, HttpServletRequest request){
        boolean decide = authenticationService.decide(new HttpServletRequestAuthWrapper(request, url, method));
        System.out.println("decide == " + decide);
        return Result.success(decide);
    }

}
