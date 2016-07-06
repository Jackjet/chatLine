package com.bupt.chatline.dao;

import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.bupt.chatline.entity.Salesman;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring.xml", "classpath*:spring-hibernate.xml" })
public class TestSalesmanDao {
	@Autowired
	private SalesmanDao salesmanDao;
	
	@Transactional
	@Test
	public void test(){
		Salesman mes = new Salesman("A","hello!!");
		int a = salesmanDao.save(mes);
		mes = salesmanDao.findById(a);
		System.out.println(mes);
		mes = new Salesman("B","hi!!");
		salesmanDao.saveOrUpdate(mes);
		mes = salesmanDao.findByName("A");
		System.out.println(mes);
		mes = new Salesman("C","how are you?");
		mes = salesmanDao.merge(mes);
		System.out.println(mes);
		salesmanDao.evict(mes);
		System.out.println(mes);
		salesmanDao.flush();
		List<Salesman> ls = salesmanDao.findAll();
		for(Salesman m:ls){
			System.out.println(m);
			m.setName("D");
			salesmanDao.update(m);
			Salesman m2 = salesmanDao.findById(m.getId());
			System.out.println(m2);
			m2.setPassword("Changed!" + new Date());
			m2 = salesmanDao.findById(m.getId());
			System.out.println(m2);
			salesmanDao.deleteById(m2.getId());
		}
		salesmanDao.flush();
	}
	
}
