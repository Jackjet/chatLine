package com.bupt.chatline.dao;

import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.bupt.chatline.config.HibernateConfig;
import com.bupt.chatline.entity.ChatMes;
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { HibernateConfig.class })
public class TestChatMesDao {
	@Autowired
	private ChatMesDao chatMesDao;
	
	@Transactional
	@Test
	public void test(){

		List<ChatMes> ls = chatMesDao.findAll();
		for(ChatMes m:ls){
			chatMesDao.evict(m);
			chatMesDao.deleteById(m.getId());
		}
		ls = chatMesDao.findAll();
		for(ChatMes m:ls){
			System.out.println(m);
		}
		ChatMes mes = new ChatMes(1,232,"hello!!");
		chatMesDao.save(mes);
		mes = new ChatMes(232,1,"hi!!");
		chatMesDao.saveOrUpdate(mes);
		mes = new ChatMes(2,232,"how are you?");
		mes = chatMesDao.merge(mes);
		System.out.println(mes);
		
		ls = chatMesDao.findBySidOrDid(1);
		
		for(ChatMes m:ls){
			System.out.println("findBySidOrDid" + m);
		}
		
		ls = chatMesDao.findAll();
		
		for(ChatMes m:ls){
			m.setContent("END!"+new Date());
			chatMesDao.update(m);
			m = chatMesDao.findById(m.getId());
			System.out.println(m);
			chatMesDao.evict(m);
			chatMesDao.deleteById(m.getId());
		}
		chatMesDao.flush();
	}
	
}
