package com.siwanper.authorization;

import com.siwanper.authorization.entity.po.Role;
import com.siwanper.authorization.entity.po.User;
import com.siwanper.authorization.service.IRoleService;
import com.siwanper.authorization.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorizationApplicationTests {

	@Autowired
	private IUserService userService;

	@Autowired
	private IRoleService roleService;

	@Test
	public void getUser(){
		User user = userService.getUserByUniqueId("15091631746");
		System.out.println(user);

		List<Role> roles = roleService.getRolesByUserId(user.getId());
		System.out.println(roles);
	}

}
