package com.siwanper.authentication.rest;

import com.siwanper.authentication.service.IAuthenticationService;
import com.siwanper.core.entity.vo.Result;
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
 * @create 2020-04-28 4:26 PM
 */
@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {

    @Autowired
    private IAuthenticationService authenticationService;

    @RequestMapping(value = "/decide", method = RequestMethod.POST)
    public Result decide(@RequestParam String url, @RequestParam String method, HttpServletRequest request){
        boolean decide = authenticationService.decide(new HttpServletRequestNewWrapper(request, url, method));
        return Result.success(decide);
    }

}
