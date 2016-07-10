package com.bupt.chatline.service;

import java.io.Serializable;
import java.util.List;

public interface GenericDaoService <T, PK extends Serializable> {
	public PK save(T  o);
	public void deleteById(PK id);
	public T  findById(PK id);
	public List<T> findAll();
	
}
