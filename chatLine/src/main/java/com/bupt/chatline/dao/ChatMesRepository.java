package com.bupt.chatline.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bupt.chatline.entity.ChatMes;


@Repository("chatMesRepository")
public interface ChatMesRepository extends CrudRepository<ChatMes, Integer> {
	List<ChatMes> findBySidOrDidOrderByTimeAsc(int sid,int did);
}
