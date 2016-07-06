package com.bupt.chatline.dao;

import com.bupt.chatline.entity.ChatMes;

public interface ChatMesDao extends GenericDao<ChatMes,Integer>{
	public Integer findNearestChatMesID(int sid,int did);
	public int updateContent(int sid,int did,String content);
}
