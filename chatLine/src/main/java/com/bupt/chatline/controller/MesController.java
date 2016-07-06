package com.bupt.chatline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import com.bupt.chatline.dao.ChatMesDao;
import com.bupt.chatline.entity.ChatMes;
import com.bupt.chatline.mes.MesHolder;

@Controller
public class MesController {
	@Autowired
	ChatMesDao chatMesDao;
	@Autowired
	private SimpMessagingTemplate template;
	
	
	public ChatMesDao getChatMesDao() {
		return chatMesDao;
	}


	public void setChatMesDao(ChatMesDao chatMesDao) {
		this.chatMesDao = chatMesDao;
	}


	public SimpMessagingTemplate getTemplate() {
		return template;
	}


	public void setTemplate(SimpMessagingTemplate template) {
		this.template = template;
	}


	@MessageMapping("/cMes")
    public void sendMes(@RequestBody Map<String,Object> map) throws Exception {
		String content = (String) map.get("content");
		int sid = Integer.parseInt((String)map.get("sid"));
		int did = Integer.parseInt((String)map.get("did"));
		ChatMes chatMes = new ChatMes(sid,did,content);
		int id = chatMesDao.save(chatMes);
		chatMes = chatMesDao.findById(id);
        template.convertAndSend(MesHolder.sendToUri + chatMes.getDid(), chatMes);
    }

}