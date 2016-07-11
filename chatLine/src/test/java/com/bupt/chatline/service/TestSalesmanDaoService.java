package com.bupt.chatline.service;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.bupt.chatline.entity.Salesman;
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring.xml", "classpath*:spring-hibernate.xml" })
public class TestSalesmanDaoService {

	@Autowired
	private SalesmanDaoService salesmanDaoService;
	
	@Test
	public void test(){
		List<Salesman> ls2 = salesmanDaoService.findAll();
		for(Salesman m:ls2){
			m.setPassword("END!"+new Date());
			salesmanDaoService.save(m);
			m = salesmanDaoService.findById(m.getId());
			System.out.println(m);
			salesmanDaoService.deleteById(m.getId());
		}
		
		List<Salesman> ls = salesmanDaoService.findAll();
		for(Salesman m:ls){
			System.out.println(m);
		}
		Salesman mes = new Salesman("A","123456");
		salesmanDaoService.save(mes);
		mes = new Salesman("B","123456");
		salesmanDaoService.save(mes);
		
		mes = salesmanDaoService.findByName("A");
		System.out.println("findByName" + mes);
		
		ls = salesmanDaoService.findAll();
		
		for(Salesman m:ls){
			m.setPassword("END!"+new Date());
			salesmanDaoService.save(m);
			m = salesmanDaoService.findById(m.getId());
			System.out.println(m);
			salesmanDaoService.deleteById(m.getId());
		}
	}
	
}
