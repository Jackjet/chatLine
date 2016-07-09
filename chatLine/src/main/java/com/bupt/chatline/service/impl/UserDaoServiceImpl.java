package com.bupt.chatline.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bupt.chatline.dao.UserDao;
import com.bupt.chatline.entity.User;
import com.bupt.chatline.service.UserDaoService;


@Service("userDaoService")
public class UserDaoServiceImpl implements UserDaoService{
	
	@Autowired
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public Integer save(User o) {
		// TODO Auto-generated method stub
		return userDao.save(o);
	}

	@Override
	public void update(User o) {
		// TODO Auto-generated method stub
		userDao.update(o);
	}

	@Override
	public void saveOrUpdate(User o) {
		// TODO Auto-generated method stub
		userDao.saveOrUpdate(o);
	}

	@Override
	public User merge(User o) {
		// TODO Auto-generated method stub
		return userDao.merge(o);
	}

	@Override
	public void delete(User o) {
		// TODO Auto-generated method stub
		userDao.delete(o);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		userDao.deleteById(id);
	}

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		userDao.flush();
	}

	@Override
	public void evict(User o) {
		// TODO Auto-generated method stub
		userDao.evict(o);
	}
	
	public List<User> findUsersBySID(int sid){
		return userDao.findUsersBySID(sid);
	}
	

}
