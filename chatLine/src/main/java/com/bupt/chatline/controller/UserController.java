package com.bupt.chatline.controller;

import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bupt.chatline.entity.Salesman;
import com.bupt.chatline.entity.User;
import com.bupt.chatline.mes.MesHolder;
import com.bupt.chatline.service.PhoneMesSendService;
import com.bupt.chatline.service.SalesmanDaoService;
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
	@Autowired
	private PhoneMesSendService phoneMesSendService;
	@Autowired
	private SalesmanDaoService salesmanDaoService;

	
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
	public PhoneMesSendService getPhoneMesSendService() {
		return phoneMesSendService;
	}
	public void setPhoneMesSendService(PhoneMesSendService phoneMesSendService) {
		this.phoneMesSendService = phoneMesSendService;
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
    		}

			userDaoService.save(u);
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
    		u.setOnLine(true);
    		userDaoService.save(u);
    	}
    	
    	User u = userDaoService.findById(id);
    	User didu  = null;
    	if(u.getDid() == -1 || (didu = userDaoService.findById(u.getDid())) == null || !didu.isOnLine()){
    		int did = factory.distributed(u);
    		//-2:no salesman is available, try to phone the former salesman
    		if(did == -2){
    			if(u.getDid() != -1 && didu != null && didu.getEid() != -1){
    				Salesman s = salesmanDaoService.findById(didu.getEid());
    				if(s != null && MesHolder.pattern.matcher(s.getPhone()).matches()){
    					phoneMesSendService.send(s.getPhone(), "请客服上线");
    				}
    			}
    			u.setDid(-1);
    			return u;
    		}
    		u.setDid(did);
    		userDaoService.save(u);
    	}
    	session.setAttribute("id", id);
    	session.setAttribute("eid", eid);
    	JSONObject o = new JSONObject();
    	try {
        	o.accumulate("id", u.getId());
			o.accumulate("result", "CONNECTED");
			template.convertAndSend(MesHolder.sendToUri + u.getId(), o.toString());
			template.convertAndSend(MesHolder.sendToUri + u.getDid(), o.toString());
    	} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userDaoService.findById(id);
	}
}
