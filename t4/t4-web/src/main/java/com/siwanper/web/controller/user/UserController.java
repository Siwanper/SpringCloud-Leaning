package com.siwanper.web.controller.user;

import com.siwanper.api.user.SysUserService;
import com.siwanper.common.model.PageModel;
import com.siwanper.core.controller.BaseController;
import com.siwanper.dao.model.user.SysUser;
import com.siwanper.dao.model.user.SysUserExample;
import com.siwanper.dao.model.user.SysUserKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController extends BaseController {

    @Autowired
    private SysUserService sysUserService;

    @ResponseBody
    @RequestMapping("/count")
    public String countByExample(){
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdIsNotNull();
        long count = sysUserService.countByExample(example);
        return String.valueOf(count);
    }

    @ResponseBody
    @RequestMapping("/deleteByExample")
    public String deleteByExample(String name){
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(name);
        int i = sysUserService.deleteByExample(example);
        return String.valueOf(i);
    }

    @ResponseBody
    @RequestMapping("/deleteByPrimaryKey")
    public String deleteByPrimaryKey(String userId, String userCode){
        SysUserKey userKey = new SysUserKey();
        userKey.setUserId(userId);
        userKey.setUserCode(userCode);
        int i = sysUserService.deleteByPrimaryKey(userKey);
        return String.valueOf(i);
    }

    @ResponseBody
    @RequestMapping("/selectByExample")
    public String selectByExample(){
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameIsNotNull();
        List<SysUser> sysUsers = sysUserService.selectByExample(example);
        return sysUsers.toString();
    }

    @ResponseBody
    @RequestMapping("/selectByExampleStartPage")
    public PageModel selectByExampleStartPage(){
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameIsNotNull();
        PageModel<SysUser> pageModel = sysUserService.selectByExampleStartPage(example, 0, 10);
        return pageModel;
    }

    @ResponseBody
    @RequestMapping("/selectByExampleOffset")
    public String selectByExampleOffset(){
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameIsNotNull();
        PageModel<SysUser> pageModel = sysUserService.selectByExampleOffset(example, 0, 10);
        return pageModel.toString();
    }

    @ResponseBody
    @RequestMapping("/selectByPrimaryKey")
    public String selectByPrimaryKey(String userId, String userCode){
        SysUserKey userKey = new SysUserKey();
        userKey.setUserId(userId);
        userKey.setUserCode(userCode);
        SysUser sysUser = sysUserService.selectByPrimaryKey(userKey);
        return sysUser.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(SysUser sysUser){
        int i = sysUserService.insert(sysUser);
        return String.valueOf(i);
    }

    @ResponseBody
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public String updateByPrimaryKey(SysUser sysUser){
        System.out.println(sysUser.toString());
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(sysUser.getUserId());
        int i = sysUserService.updateByExample(sysUser, example);
        return String.valueOf(i);
    }




}
