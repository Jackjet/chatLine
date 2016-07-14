package com.bupt.chatline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;

import com.bupt.chatline.service.ChatMesDaoService;
import com.bupt.chatline.service.UserDaoService;
import com.bupt.chatline.entity.ChatMes;
import com.bupt.chatline.entity.User;
import com.bupt.chatline.mes.MesHolder;

@Controller
public class MesController implements ApplicationListener<SessionDisconnectEvent>{
	@Autowired
	ChatMesDaoService chatMesDaoService;
	@Autowired
	private SimpMessagingTemplate template;
	@Autowired
	private UserDaoService userDaoService;


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
	
    @RequestMapping("findLog")
	public @ResponseBody List<ChatMes> findLog(@RequestParam(value="sid",required=true)int sid) throws Exception
	{
		List<ChatMes> chatMesList = chatMesDaoService.findBySidOrDid(sid);
		return chatMesList;
		
	}
    
    @RequestMapping("*/meslog")
	public String indexOfMeslogr(){
		return "meslog";
	}

	
	@MessageMapping("/cMes")
    public void sendMes(@RequestBody Map<String,Object> map) throws Exception {
		String content = (String) map.get("content").toString();
		int sid = Integer.parseInt(map.get("sid").toString());
		int did = Integer.parseInt(map.get("did").toString());
		ChatMes chatMes = new ChatMes(sid,did,content);
		int id = chatMesDaoService.save(chatMes);
		chatMes = chatMesDaoService.findById(id);
        template.convertAndSend(MesHolder.sendToUri + chatMes.getDid(), chatMes);
    }
	@SubscribeMapping("/init")
    public void sendInitMes(@RequestBody Map<String,Object> map) throws Exception {
		int sid = Integer.parseInt(map.get("sid").toString());
		List<ChatMes> ls = chatMesDaoService.findBySidOrDid(sid); 
		for(ChatMes chatMes:ls){
			template.convertAndSend(MesHolder.sendToUri + sid, chatMes);
        }
    }
	@SuppressWarnings({ "rawtypes"})
	@Override
	public void onApplicationEvent(SessionDisconnectEvent e) {
		ConcurrentHashMap mp =  (ConcurrentHashMap) e.getMessage().getHeaders().get("simpSessionAttributes");
		if(!mp.containsKey("id")){
		}else{
			int id = Integer.parseInt(mp.get("id").toString());
			User u = userDaoService.findById(id);
			u.setOnLine(false);
			userDaoService.save(u);
			List<User> ls = userDaoService.findByDid(u.getId());
	    	JSONObject o = new JSONObject();
	    	try {
	        	o.accumulate("id", u.getId());
				o.accumulate("result", "DISCONNECTED");
				for(User u2 :ls){
					template.convertAndSend(MesHolder.sendToUri + u2.getId(), o.toString());
				}
				template.convertAndSend(MesHolder.sendToUri + u.getDid(), o.toString());
	    	} catch (JSONException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
		
	}

}