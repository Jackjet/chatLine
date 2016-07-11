package com.bupt.chatline.service;


import com.bupt.chatline.entity.User;

public interface UserDaoService extends GenericDaoService<User,Integer>{
	public User findByEid(int eid);

}
