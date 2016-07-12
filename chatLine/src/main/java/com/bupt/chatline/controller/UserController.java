package com.bupt.chatline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @RequestMapping("/chats")
	public String indexOfSales(){
		return "chats";
	}
    @RequestMapping("/chatc")
	public String indexOfCustomer(){
		return "chatc";
	}

}
