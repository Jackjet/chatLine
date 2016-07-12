package com.bupt.chatline.service;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.bupt.chatline.entity.User;
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring.xml", "classpath*:spring-hibernate.xml" })
public class TestUserDaoService {

	@Autowired
	private UserDaoService userDaoService;
	
	@Test
	public void test(){
		List<User> ls = userDaoService.findAll();
		for(User m:ls){
			System.out.println(m);
		}
		User mes = new User(1,"A",false);
		userDaoService.save(mes);
		mes = new User(1,"B",true);
		userDaoService.save(mes);
		mes = new User(2,"C",false);
		userDaoService.save(mes);
		
		mes = userDaoService.findByEid(1);
		
		System.out.println("findByEid" + mes);
		ls = userDaoService.findAll();
		
		for(User m:ls){
			m.setName("END!"+new Date());
			userDaoService.save(m);
			m = userDaoService.findById(m.getId());
			System.out.println(m);
			userDaoService.deleteById(m.getId());
		}
	}
	
}
