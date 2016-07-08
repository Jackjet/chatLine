package com.bupt.chatline.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bupt.chatline.dao.SalesmanDao;
import com.bupt.chatline.entity.Salesman;
import com.bupt.chatline.service.SalesmanDaoService;


@Service("salesmanDaoService")
public class SalesmanDaoServiceImpl implements SalesmanDaoService {
	@Autowired
	SalesmanDao salesmanDao;
	
	@Override
	public Integer save(Salesman o) {
		// TODO Auto-generated method stub
		return salesmanDao.save(o);
	}

	@Override
	public void update(Salesman o) {
		// TODO Auto-generated method stub
		salesmanDao.update(o);
	}

	@Override
	public void saveOrUpdate(Salesman o) {
		// TODO Auto-generated method stub
		salesmanDao.saveOrUpdate(o);
	}

	@Override
	public Salesman merge(Salesman o) {
		// TODO Auto-generated method stub
		return salesmanDao.merge(o);
	}

	@Override
	public void delete(Salesman o) {
		// TODO Auto-generated method stub
		salesmanDao.delete(o);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		salesmanDao.deleteById(id);
	}

	@Override
	public Salesman findById(Integer id) {
		// TODO Auto-generated method stub
		return salesmanDao.findById(id);
	}

	@Override
	public List<Salesman> findAll() {
		// TODO Auto-generated method stub
		return salesmanDao.findAll();
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		salesmanDao.flush();
	}

	@Override
	public void evict(Salesman o) {
		// TODO Auto-generated method stub
		salesmanDao.evict(o);
	}

	@Override
	public boolean authenticate(String name, String psw) {
		// TODO Auto-generated method stub
		return salesmanDao.authenticate(name, psw);
	}

	@Override
	public Salesman findByName(String name) {
		return salesmanDao.findByName(name);
	}

}
