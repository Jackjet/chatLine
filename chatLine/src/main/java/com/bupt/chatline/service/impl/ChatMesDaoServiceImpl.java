package com.bupt.chatline.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bupt.chatline.dao.ChatMesRepository;
import com.bupt.chatline.entity.ChatMes;
import com.bupt.chatline.service.ChatMesDaoService;

@Service("chatMesDaoService")
public class ChatMesDaoServiceImpl implements ChatMesDaoService {
	@Autowired
	private ChatMesRepository chatMesRepository;

	public ChatMesRepository getChatMesRepository() {
		return chatMesRepository;
	}

	public void setChatMesRepository(ChatMesRepository chatMesRepository) {
		this.chatMesRepository = chatMesRepository;
	}

	@Override
	public Integer save(ChatMes o) {
		// TODO Auto-generated method stub
		return chatMesRepository.save(o).getId();
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		chatMesRepository.delete(id);
	}

	@Override
	public ChatMes findById(Integer id) {
		// TODO Auto-generated method stub
		return chatMesRepository.findOne(id);
	}

	@Override
	public List<ChatMes> findAll() {
		// TODO Auto-generated method stub
		Iterable<ChatMes> itr = chatMesRepository.findAll();
		List<ChatMes> ans= new ArrayList<ChatMes>();
		for(ChatMes c:itr){
			ans.add(c);
		}
		return ans;
	}

	

	public List<ChatMes> findBySidOrDid(int sdid){
		return chatMesRepository.findBySidOrDidOrderByTimeAsc(sdid, sdid);
	}

}
