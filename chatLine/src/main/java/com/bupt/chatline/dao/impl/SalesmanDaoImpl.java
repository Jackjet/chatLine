package com.bupt.chatline.dao.impl;

import org.springframework.stereotype.Repository;

import com.bupt.chatline.dao.SalesmanDao;
import com.bupt.chatline.entity.Salesman;


@Repository("salesmanDao")
public class SalesmanDaoImpl extends GenericDaoImpl<Salesman, Integer>implements SalesmanDao {
	public Salesman findByName(String name){
		return (Salesman)sessionFactory.openSession()
			.createQuery("from Salesman where name = '" + name +"'").uniqueResult();
	}
	public boolean authenticate(String name,String psw){
		return ((Salesman)this.findByName(name)).getPassword().equals(psw);
	}

}
