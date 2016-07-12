package com.bupt.chatline.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bupt.chatline.entity.User;


@Repository("userRepository")
public interface UserRepository extends CrudRepository<User,Integer>{
	List<User> findByEid(int eid);
}
