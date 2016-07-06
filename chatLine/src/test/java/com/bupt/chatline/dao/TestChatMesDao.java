package com.bupt.chatline.dao;

import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.bupt.chatline.entity.ChatMes;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring.xml", "classpath*:spring-hibernate.xml" })
public class TestChatMesDao {
	@Autowired
	private ChatMesDao chatMesDao;
	
	@Transactional
	@Test
	public void test(){
		ChatMes mes = new ChatMes(1,232,"hello!!");
		chatMesDao.save(mes);
		mes = new ChatMes(232,1,"hi!!");
		chatMesDao.saveOrUpdate(mes);
		mes = new ChatMes(1,232,"how are you?");
		mes = chatMesDao.merge(mes);
		System.out.println(mes);
		chatMesDao.evict(mes);
		System.out.println(mes);
		List<ChatMes> ls = chatMesDao.findAll();
		for(ChatMes m:ls){
			System.out.println(m);
			m.setContent("Changed!"+new Date());
			chatMesDao.update(m);
			m = chatMesDao.findById(m.getId());
			System.out.println(m);
			chatMesDao.deleteById(m.getId());
		}
		chatMesDao.flush();
	}
	
}
