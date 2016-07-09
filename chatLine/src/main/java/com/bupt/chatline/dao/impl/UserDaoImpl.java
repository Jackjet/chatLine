package com.bupt.chatline.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bupt.chatline.dao.UserDao;
import com.bupt.chatline.entity.User;

@Repository("userDao")
public class UserDaoImpl extends GenericDaoImpl<User,Integer> implements UserDao{
	
	@SuppressWarnings("unchecked")
	public List<User> findUsersBySID(int sid){
		String str = "from ChatMes where sid = " + sid + " ordered by did";
		return (List<User>)sessionFactory.openSession().createQuery(str).list();
		
	}

}
