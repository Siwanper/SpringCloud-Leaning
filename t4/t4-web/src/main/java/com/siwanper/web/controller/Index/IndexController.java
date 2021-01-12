package com.siwanper.web.controller.Index;

import com.siwanper.core.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 名称：IndexController
 * 描述：TODO
 *
 * @author chenjie
 * @date 2020/11/20  4:35 下午
 */
@Controller
public class IndexController extends BaseController {

    @RequestMapping("/login")
    public String login(){
        if (this.isNull(this.getHttpSession().getAttribute("user"))){
            return "login";
        } else {
            return "redirect:/";
        }
    }

}
