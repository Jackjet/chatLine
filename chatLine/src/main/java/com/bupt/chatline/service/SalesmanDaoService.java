package com.bupt.chatline.service;

import com.bupt.chatline.entity.Salesman;

public interface SalesmanDaoService extends GenericDaoService<Salesman, Integer> {
	public boolean authenticate(String name,String psw);
	public Salesman findByName(String name);
}
