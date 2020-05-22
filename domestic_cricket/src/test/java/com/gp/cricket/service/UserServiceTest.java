package com.gp.cricket.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.gp.cricket.DomesticCricketApplication;
import com.gp.cricket.repository.UserRepository;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = DomesticCricketApplication.class)
public class UserServiceTest {
	
	@MockBean
	private UserRepository userRepository;
	
	@Test
	public void getUserTest() {
		
		
	}
}
