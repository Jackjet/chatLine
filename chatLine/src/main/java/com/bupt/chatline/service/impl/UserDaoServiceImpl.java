package com.bupt.chatline.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bupt.chatline.dao.UserRepository;
import com.bupt.chatline.entity.User;
import com.bupt.chatline.service.UserDaoService;

@Service("userDaoService")
public class UserDaoServiceImpl implements UserDaoService {
	@Autowired
	private UserRepository userRepository;

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Integer save(User o) {
		if(o.getEid()>0){
			User u = this.findByEid(o.getEid());
			if(u!=null){
				o.setId(u.getId());
			}
		}
		return userRepository.save(o).getId();
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		userRepository.delete(id);
	}

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		Iterable<User> itr = userRepository.findAll();
		List<User> ans= new ArrayList<User>();
		for(User c:itr){
			ans.add(c);
		}
		return ans;
	}

	

	public User findByEid(int eid){
		List<User> ls = userRepository.findByEid(eid);
		if(ls.isEmpty())return null;
		return ls.get(0);
	}
}
