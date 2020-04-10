package com.siwanper.organization;


import com.siwanper.organization.entity.vo.UserVo;
import com.siwanper.organization.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrganizationApplicationTests {

	@Autowired
	private IUserService userService;

	@Test
	public void contextLoads() {
		UserVo user = userService.get("101");
		System.out.println(user);
	}

}
