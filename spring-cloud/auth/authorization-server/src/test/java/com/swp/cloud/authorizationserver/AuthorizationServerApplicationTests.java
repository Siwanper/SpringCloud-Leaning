package com.swp.cloud.authorizationserver;

import com.swp.cloud.authorizationserver.entity.Role;
import com.swp.cloud.authorizationserver.entity.User;
import com.swp.cloud.authorizationserver.service.impl.RoleService;
import com.swp.cloud.authorizationserver.service.impl.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorizationServerApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void user(){
		User user = userService.getByUniqueId("admin");
		System.out.println("user ====== " + user);
	}

	@Test
	public void role(){
		Set<Role> roles = roleService.getRoleByUserId(101);
		System.out.println("role ====== " + roles);
	}
}
