package com.swp.swagger.controller;

import com.swp.swagger.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-08-28 3:57 PM
 */
@Api(value = "UserController", description = "用户文档",tags = {"用户操作接口说明"})
@RestController
@RequestMapping(value = "/user")
public class UserController {

    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    @ApiOperation(value = "添加用户", notes = "添加用户信息")
    @ApiImplicitParam(value = "用户实体", name = "user", required = true, dataType = "User")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postUser(@RequestBody User user){
        users.put(user.getId(),user);
        return "SUCCESS";
    }

    @ApiOperation(value = "删除用户", notes = "根据用户ID删除用户信息")
    @ApiImplicitParam(value = "用户ID", name = "id", required = true, dataType = "Long" ,paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id){
        users.remove(id);
        return "SUCCESS";
    }

    @ApiOperation(value = "更新用户", notes = "更新用户信息")
    @ApiImplicitParam(value = "用户实体", name = "user", required = true )
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@RequestParam User user){
        users.replace(user.getId(), user);
        return "SUCCESS";
    }

    @ApiOperation(value = "获取用户", notes = "获取用户信息")
    @ApiImplicitParam(value = "用户ID", name = "id", required = true)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id){
        User user = users.get(id);
        return user;
    }

    @ApiOperation(value = "获取用户列表", notes = "获取用户列表信息")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList(){
        List<User> userList = new ArrayList<>(users.values());
        return userList;
    }


}
