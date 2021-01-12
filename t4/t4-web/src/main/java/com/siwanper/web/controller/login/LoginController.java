package com.siwanper.web.controller.login;

import com.siwanper.api.user.SysUserService;
import com.siwanper.core.annotation.LogInject;
import com.siwanper.core.controller.BaseController;
import com.siwanper.dao.model.login.LoginModel;
import com.siwanper.dao.model.user.SysUser;
import com.siwanper.dao.model.user.SysUserExample;
import com.siwanper.dao.model.user.SysUserKey;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 名称：LoginController
 * 描述：TODO
 *
 * @author chenjie
 * @date 2020/11/20  4:32 下午
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

    @LogInject
    private static Logger logger;

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/signin" , method = RequestMethod.POST)
    @ResponseBody
    public LoginModel signin(String username, String password, boolean remember){
        logger.info("usercode : {}, password : {}" ,username, password);
        if (this.isNull(username) || this.isNull(password)){
            return new LoginModel(0, "用户名或密码为空");
        }
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserCodeEqualTo(username).andUserPasswordEqualTo(password);
        List<SysUser> sysUsers = sysUserService.selectByExample(example);
        if (sysUsers.size() > 0) {
            SysUser sysUser = sysUsers.get(0);
            this.getHttpSession().setAttribute("user", sysUser);
            return new LoginModel(1, "登录成功","/", remember);
        } else {
            return new LoginModel(0, "用户不存在");
        }
    }

    @RequestMapping(value = "/signout")
    public String signout(){
        this.getHttpSession().removeAttribute("user");
        this.getHttpSession().invalidate();
        return "redirect:/login";
    }

}
