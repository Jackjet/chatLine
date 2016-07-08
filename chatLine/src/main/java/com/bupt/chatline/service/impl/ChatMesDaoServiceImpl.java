package com.bupt.chatline.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bupt.chatline.dao.ChatMesDao;
import com.bupt.chatline.entity.ChatMes;
import com.bupt.chatline.service.ChatMesDaoService;

@Service("chatMesDaoService")
public class ChatMesDaoServiceImpl implements ChatMesDaoService {
	@Autowired
	private ChatMesDao chatMesDao;

	public ChatMesDao getChatMesDao() {
		return chatMesDao;
	}

	public void setChatMesDao(ChatMesDao chatMesDao) {
		this.chatMesDao = chatMesDao;
	}

	@Override
	public Integer save(ChatMes o) {
		// TODO Auto-generated method stub
		return chatMesDao.save(o);
	}

	@Override
	public void update(ChatMes o) {
		// TODO Auto-generated method stub
		chatMesDao.update(o);
	}

	@Override
	public void saveOrUpdate(ChatMes o) {
		// TODO Auto-generated method stub
		chatMesDao.saveOrUpdate(o);
	}

	@Override
	public ChatMes merge(ChatMes o) {
		// TODO Auto-generated method stub
		return chatMesDao.merge(o);
	}

	@Override
	public void delete(ChatMes o) {
		// TODO Auto-generated method stub
		chatMesDao.delete(o);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		chatMesDao.deleteById(id);
	}

	@Override
	public ChatMes findById(Integer id) {
		// TODO Auto-generated method stub
		return chatMesDao.findById(id);
	}

	@Override
	public List<ChatMes> findAll() {
		// TODO Auto-generated method stub
		return chatMesDao.findAll();
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		chatMesDao.flush();
	}

	@Override
	public void evict(ChatMes o) {
		// TODO Auto-generated method stub
		chatMesDao.evict(o);
	}

	@Override
	public Integer findNearestChatMesID(int sid, int did) {
		// TODO Auto-generated method stub
		return chatMesDao.findNearestChatMesID(sid, did);
	}

	@Override
	public int updateContent(int sid, int did, String content) {
		// TODO Auto-generated method stub
		return chatMesDao.updateContent(sid, did, content);
	}
	

	public List<ChatMes> findBySidOrDid(int sdid){
		return chatMesDao.findBySidOrDid(sdid);
	}
}
