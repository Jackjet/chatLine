package com.bupt.chatline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;

import com.bupt.chatline.service.ChatMesDaoService;
import com.bupt.chatline.entity.ChatMes;
import com.bupt.chatline.mes.MesHolder;

@Controller
public class MesController {
	@Autowired
	ChatMesDaoService chatMesDaoService;
	@Autowired
	private SimpMessagingTemplate template;
	


	public ChatMesDaoService getChatMesDaoService() {
		return chatMesDaoService;
	}


	public void setChatMesDaoService(ChatMesDaoService chatMesDaoService) {
		this.chatMesDaoService = chatMesDaoService;
	}


	public SimpMessagingTemplate getTemplate() {
		return template;
	}


	public void setTemplate(SimpMessagingTemplate template) {
		this.template = template;
	}

	
	@SubscribeMapping("/cMes")
    public void sendMes(@RequestBody Map<String,Object> map) throws Exception {
		String content = (String) map.get("content").toString();
		int sid = Integer.parseInt(map.get("sid").toString());
		int did = Integer.parseInt(map.get("did").toString());
		ChatMes chatMes = new ChatMes(sid,did,content);
		int id = chatMesDaoService.save(chatMes);
		chatMes = chatMesDaoService.findById(id);
        template.convertAndSend(MesHolder.sendToUri + chatMes.getDid(), chatMes);
    }
	@MessageMapping("/init")
    public void sendInitMes(@RequestBody Map<String,Object> map) throws Exception {
		int sid = Integer.parseInt(map.get("sid").toString());
		List<ChatMes> ls = chatMesDaoService.findBySidOrDid(sid); 
		for(ChatMes chatMes:ls){
			template.convertAndSend(MesHolder.sendToUri + sid, chatMes);
        }
    }

}