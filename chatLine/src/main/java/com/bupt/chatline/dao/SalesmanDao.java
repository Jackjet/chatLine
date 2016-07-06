package com.bupt.chatline.dao;

import com.bupt.chatline.entity.Salesman;

public interface SalesmanDao extends GenericDao<Salesman, Integer> {
	public boolean authenticate(String name,String psw);
	public Salesman findByName(String name);
}
