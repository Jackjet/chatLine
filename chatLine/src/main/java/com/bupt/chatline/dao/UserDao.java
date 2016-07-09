package com.bupt.chatline.dao;

import java.util.List;

import com.bupt.chatline.entity.User;

public interface UserDao extends GenericDao<User,Integer> {
	
	public List<User> findUsersBySID(int sid);

}
