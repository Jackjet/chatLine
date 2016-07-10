package com.bupt.chatline.service;

import com.bupt.chatline.service.GenericDaoService;

import java.util.List;

import com.bupt.chatline.entity.ChatMes;

public interface ChatMesDaoService extends GenericDaoService<ChatMes,Integer>{
	public List<ChatMes> findBySidOrDid(int sdid);
}
