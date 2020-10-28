package com.siwanper.web.controller.user;

import com.siwanper.api.user.UserService;
import com.siwanper.dao.model.user.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/get/{id}")
    public String getUser(@PathVariable Integer id){
        SysUser user = userService.getUser(id);
        System.out.println(user.getUsername() + user.getPhone());
        return user.getUsername() + user.getPhone();
    }

}
