package com.bupt.chatline.listener;

import java.util.LinkedList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;

import com.bupt.chatline.entity.User;
import com.bupt.chatline.service.UserDaoService;

@Component
public class WebSocketSessionConnectedListener implements ApplicationListener<SessionConnectedEvent> {
	@Autowired
	private UserDaoService userDaoService;
	
	@SuppressWarnings({ "rawtypes"})
	@Override
	public void onApplicationEvent(SessionConnectedEvent e) {
		MessageHeaders header = ((GenericMessage)(e.getMessage().getHeaders().get("simpConnectMessage"))).getHeaders();
		Map nativeHeaders = (Map)header.get("nativeHeaders");
		if(!nativeHeaders.containsKey("id") || Integer.parseInt(((LinkedList)nativeHeaders.get("id")).getFirst().toString()) == -1){
		}else{
			int id = Integer.parseInt(((LinkedList)nativeHeaders.get("id")).getFirst().toString());
			User u = userDaoService.findById(id);
			u.setOnLine(true);
			userDaoService.save(u);
		}
			
		
		
		
		
		
	}

}
