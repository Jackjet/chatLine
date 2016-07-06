package com.bupt.chatline.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.lang.reflect.ParameterizedType;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.bupt.chatline.dao.GenericDao;

public class GenericDaoImpl<T,PK extends Serializable> implements GenericDao<T,PK>{
	@Autowired
	protected SessionFactory sessionFactory;
	protected Class<?> entity;
	
	public GenericDaoImpl() {
		super();
		this.entity = (Class<?>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Class<?> getEntity() {
		return entity;
	}

	public void setEntity(Class<T> entity) {
		this.entity = entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PK save(T o) {
		return (PK) sessionFactory.getCurrentSession().save(o);
	}

	@Override
	public void update(T o) {
		 sessionFactory.getCurrentSession().update(o);
		 sessionFactory.getCurrentSession().flush();
		
	}

	@Override
	public void saveOrUpdate(T o) {
		sessionFactory.getCurrentSession().saveOrUpdate(o);
		sessionFactory.getCurrentSession().flush();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T merge(T o) {
		o =  (T) sessionFactory.getCurrentSession().merge(o);
		sessionFactory.getCurrentSession().flush();
		return o;
	}

	@Override
	public void delete(T o) {
		sessionFactory.getCurrentSession().delete(o);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteById(Serializable id) {
		T o = (T) sessionFactory.getCurrentSession().get(entity,id);
		sessionFactory.getCurrentSession().delete(o);
		sessionFactory.getCurrentSession().flush();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(Serializable id) {
		return (T) sessionFactory.getCurrentSession().get(entity,id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return (List<T>)sessionFactory.getCurrentSession().
				createCriteria(entity).list();
	}

	@Override
	public void flush() {
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void evict(T o) {
		sessionFactory.getCurrentSession().evict(o);
	}
}