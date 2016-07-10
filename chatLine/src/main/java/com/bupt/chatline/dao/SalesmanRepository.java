package com.bupt.chatline.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bupt.chatline.entity.Salesman;


@Repository("salesmanRepository")
public interface SalesmanRepository extends CrudRepository<Salesman, Integer> {
	List<Salesman> findByName(String name);
}
