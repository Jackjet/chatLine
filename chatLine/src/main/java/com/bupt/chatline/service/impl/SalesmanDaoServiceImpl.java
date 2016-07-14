package com.bupt.chatline.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bupt.chatline.dao.ChatMesRepository;
import com.bupt.chatline.dao.SalesmanRepository;
import com.bupt.chatline.dao.UserRepository;
import com.bupt.chatline.entity.Salesman;
import com.bupt.chatline.service.SalesmanDaoService;


@Service("salesmanDaoService")
public class SalesmanDaoServiceImpl implements SalesmanDaoService {

	@Autowired
	private SalesmanRepository salesmanRepository;
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Integer save(Salesman o) {
		// TODO Auto-generated method stub
		return salesmanRepository.save(o).getId();
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		salesmanRepository.delete(id);
	}

	@Override
	public Salesman findById(Integer id) {
		// TODO Auto-generated method stub
		return salesmanRepository.findOne(id);
	}

	@Override
	public List<Salesman> findAll() {
		// TODO Auto-generated method stub
		Iterable<Salesman> itr = salesmanRepository.findAll();
		List<Salesman> ans = new ArrayList<Salesman>();
		for(Salesman s:itr){
			ans.add(s);
		}
		return ans;
	}

	@Override
	public boolean authenticate(String name, String psw) {
		Salesman s = this.findByName(name);
		return s.getPassword().equals(psw);
	}

	@Override
	public Salesman findByName(String name) {
		List<Salesman> ls = salesmanRepository.findByName(name);
		if(ls.size()==0)return null;
		return ls.get(0);
	}

	@Override
	public List<Salesman> findByOnLine(boolean onLine) {
		// TODO Auto-generated method stub
		Iterable<Salesman> ls = salesmanRepository.findAll();
		List<Salesman> ans = new ArrayList<Salesman>();
		for(Salesman s:ls){
			if(userRepository.findByEid(s.getId()).size() > 0 && userRepository.findByEid(s.getId()).get(0).isOnLine() == onLine){
				ans.add(s);
			}
		}
		return ans;
	}

}
