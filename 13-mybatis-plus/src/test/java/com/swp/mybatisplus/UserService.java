package com.swp.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swp.mybatisplus.mapper.UserMapper;
import com.swp.mybatisplus.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-08-29 10:15 AM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void getUser(){
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

    @Test
    public void addUser(){
        User user = new User();
        user.setId(7l);
        user.setName("史万鹏");
        user.setAge(27);
        user.setEmail("15091631746@163.com");
        userMapper.insert(user);
        User user1 = userMapper.selectById(user.getId());
        System.out.println(user1);
    }
    
    @Test
    public void deleteUser(){
        int i = userMapper.deleteById(1166899113103646722l);
        Assert.assertEquals("删除失败", i, 1);
    }

    @Test
    public void updateUser(){
        User user = userMapper.selectById(2);
        user.setName("zhangsan");
        user.setAge(21);
        userMapper.updateById(user);

        System.out.println(userMapper.selectById(2));
    }

    @Test
    public void userList(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    public void userPages(){
        Page<User> page = new Page<>(1,2);
        /**
         * eq
         * ne
         * gt
         * ge
         * lt
         * le
         * between
         * like
         * isNull
         * in
         * orderBy
         * groupBy
         */
        IPage<User> userIPage = userMapper.selectPage(page, new QueryWrapper<User>().gt("age", 6));

        System.out.println("总条数total : " + userIPage.getTotal());
        System.out.println("当前页current : " + userIPage.getCurrent());
        System.out.println("总页数page : " + userIPage.getPages());
        System.out.println("一页条数size : " + userIPage.getSize());
        System.out.println("record : " + userIPage.getRecords());

    }



}
