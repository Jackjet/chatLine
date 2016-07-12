package com.bupt.chatline.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bupt.chatline.entity.User;
import com.bupt.chatline.mes.MesHolder;
import com.bupt.chatline.service.UserDaoService;
import com.bupt.chatline.strategy.UserSalesmanDistributedFactory;

@Controller
public class UserController {

	@Autowired
	private UserDaoService userDaoService;
	@Autowired
	private UserSalesmanDistributedFactory factory;
	@Autowired
	private SimpMessagingTemplate template;
	
    public UserDaoService getUserDaoService() {
		return userDaoService;
	}
	public void setUserDaoService(UserDaoService userDaoService) {
		this.userDaoService = userDaoService;
	}
	public UserSalesmanDistributedFactory getFactory() {
		return factory;
	}
	public void setFactory(UserSalesmanDistributedFactory factory) {
		this.factory = factory;
	}
	public SimpMessagingTemplate getTemplate() {
		return template;
	}
	public void setTemplate(SimpMessagingTemplate template) {
		this.template = template;
	}
	
	@RequestMapping("/chats")
	public String indexOfSales(){
		return "chats";
	}
    @RequestMapping("/chatc")
	public String indexOfCustomer(){
		return "chatc";
	}

    @RequestMapping("/connect")
	public @ResponseBody User connect(@RequestParam(value="id", required=true)Integer id,
			@RequestParam(value="eid", required=true)Integer eid,
			@RequestParam(value="name", required=false)String name,
			HttpSession session){
    	if(id != null && id != -1 && userDaoService.findById(id)!= null){
    		User u = userDaoService.findById(id);
    		u.setOnLine(true);
    		userDaoService.save(u);
    		//reconnect
    	}else if(eid != -1 && userDaoService.findByEid(eid)!=null){
    		//has account
    		User u = userDaoService.findByEid(eid);
    		id = u.getId();
    		u.setOnLine(true);
    		
    		if(name != null && name.trim().length() > 0){
    			u.setName(name);
    			userDaoService.save(u);
    		}
    	}else{
    		User u = new User();
    		u.setEid(eid);
    		id = userDaoService.save(u);
    		if(name != null && name.trim().length() > 0){
    		}else{
    			if(eid==-1){
    				name="游客"+id;
    			}else{
    				name="用户"+eid;
    			}
    			u.setName(name);
    		}
    		int did = factory.distributed(u);
    		u.setDid(did);
    		u.setOnLine(true);
    		userDaoService.save(u);
    	}
    	session.setAttribute("id", id);
    	User u = userDaoService.findById(id);
		template.convertAndSend(MesHolder.sendToUri + u.getId(), u.getId()+" CONNECTED");
		template.convertAndSend(MesHolder.sendToUri + u.getDid(), u.getId()+" CONNECTED");
		return userDaoService.findById(id);
	}
}
