package com.bupt.chatline.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.bupt.chatline.config.JPAConfiguration;
import com.bupt.chatline.dao.ChatMesRepository;
import com.bupt.chatline.dao.SalesmanRepository;
import com.bupt.chatline.entity.ChatMes;
import com.bupt.chatline.entity.Salesman;
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={JPAConfiguration.class})
public class TestChatMesDaoService {

	@Autowired
	private ChatMesDaoService chatMesDaoService;
	@Autowired
	private ChatMesRepository chatMesRepository;

	@Autowired
	private SalesmanRepository salesmanRepository;
	
	@Test
	public void test(){
		//ConfigurableApplicationContext context =new AnnotationConfigApplicationContext(TestChatMesDaoService.class);
		Iterable<ChatMes> ls = chatMesRepository.findAll();
		for(ChatMes m:ls){
			System.out.println(m);
		}
		Iterable<Salesman> itr = salesmanRepository.findAll();
		for(Salesman s:itr){
			System.out.println(s);
		}
		/*
		List<ChatMes> ls = chatMesDaoService.findAll();
		for(ChatMes m:ls){
			chatMesDaoService.deleteById(m.getId());
		}
		ls = chatMesDaoService.findAll();
		for(ChatMes m:ls){
			System.out.println(m);
		}
		ChatMes mes = new ChatMes(1,232,"hello!!");
		chatMesDaoService.save(mes);
		mes = new ChatMes(232,1,"hi!!");
		chatMesDaoService.saveOrUpdate(mes);
		mes = new ChatMes(2,232,"how are you?");
		mes = chatMesDaoService.merge(mes);
		System.out.println(mes);
		
		ls = chatMesDaoService.findBySidOrDid(1);
		
		for(ChatMes m:ls){
			System.out.println("findBySidOrDid" + m);
		}
		
		ls = chatMesDaoService.findAll();
		
		for(ChatMes m:ls){
			m.setContent("END!"+new Date());
			chatMesDaoService.update(m);
			m = chatMesDaoService.findById(m.getId());
			System.out.println(m);
			chatMesDaoService.deleteById(m.getId());
		}*/
	}
	
}
