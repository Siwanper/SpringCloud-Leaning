package com.siwanper.authentication;

import com.siwanper.authentication.service.IResourceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthenticationApplicationTests {

	@Autowired
	private IResourceService resourceService;

	void contextLoads() {
	}

	@Test
	public void resource(){
		resourceService.loadResource();
	}

}
