package com.bupt.chatline.dao.impl;


import org.springframework.stereotype.Repository;

import com.bupt.chatline.dao.ChatMesDao;
import com.bupt.chatline.entity.ChatMes;


@Repository("chatMesDao")
public class ChatMesDaoImpl extends GenericDaoImpl<ChatMes, Integer>implements ChatMesDao {
	public Integer findNearestChatMesID(int sid, int did) {
		return (Integer) sessionFactory.openSession()
				.createQuery("select max(id) from ChatMes where sid = " + sid + " and did = " + did)
				.uniqueResult();
	}

	public int updateContent(int sid,int did,String content){
		int id = findNearestChatMesID(sid,did);
		ChatMes mes = (ChatMes) findById(id);
		mes.setContent(mes.getContent() + content);
		update(mes);
		return id;
	}
}
