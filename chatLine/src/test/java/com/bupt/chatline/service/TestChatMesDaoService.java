package com.bupt.chatline.service;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.bupt.chatline.entity.ChatMes;
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring.xml", "classpath*:spring-hibernate.xml" })
public class TestChatMesDaoService {

	@Autowired
	private ChatMesDaoService chatMesDaoService;
	
	@Test
	public void test(){
		List<ChatMes> ls = chatMesDaoService.findAll();
		for(ChatMes m:ls){
			System.out.println(m);
		}
		ChatMes mes = new ChatMes(1,232,"hello!!");
		chatMesDaoService.save(mes);
		mes = new ChatMes(1,232,"hi!!");
		chatMesDaoService.save(mes);
		mes = new ChatMes(2,232,"thx!!");
		chatMesDaoService.save(mes);
		
		ls = chatMesDaoService.findBySidOrDid(1);
		for(ChatMes m:ls){
			System.out.println("findBySidOrDid" + m);
		}
		
		ls = chatMesDaoService.findAll();
		
		for(ChatMes m:ls){
			m.setContent("END!"+new Date());
			chatMesDaoService.save(m);
			m = chatMesDaoService.findById(m.getId());
			System.out.println(m);
			chatMesDaoService.deleteById(m.getId());
		}
	}
	
}
