package com.bupt.chatline.service;

import java.util.List;

import com.bupt.chatline.entity.User;

public interface UserDaoService extends GenericDaoService<User,Integer>{
	public List<User> findUsersBySID(int sid);

}
