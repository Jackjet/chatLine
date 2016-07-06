package com.bupt.chatline.dao;

import java.io.Serializable;
import java.util.List;


public interface GenericDao<T, PK extends Serializable> {
	public PK save(T  o);
	public void update(T  o);
	public void saveOrUpdate(T  o);
	public T  merge(T  o);
	public void delete(T  o);
	public void deleteById(PK id);
	public T  findById(PK id);
	public List<T> findAll();
	
	public void flush();
	public void evict(T o);
	//public List<T> findByAttr(Map<String,T> attrs);
}
