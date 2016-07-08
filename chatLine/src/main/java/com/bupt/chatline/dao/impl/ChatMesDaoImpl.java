package com.bupt.chatline.dao.impl;


import java.util.List;

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
	@SuppressWarnings("unchecked")
	public List<ChatMes> findBySidOrDid(int sdid){
		String str = "from ChatMes c where c.sid = " + sdid + " or c.did = " + sdid + " order by c.time asc";
		return (List<ChatMes>)sessionFactory.openSession().createQuery(str).list();
		
	}
}
