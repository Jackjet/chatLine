package com.bupt.chatline.strategy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bupt.chatline.entity.Salesman;
import com.bupt.chatline.entity.User;
import com.bupt.chatline.service.SalesmanDaoService;

public class PollingUserSalesmanDistributedStrategy extends UserSalesmanDistributedStrategy {

	@Autowired
	private SalesmanDaoService salesmanDaoService;
	
	@Override
	public int distributed(User u) {
		List<Salesman> ls = salesmanDaoService.findAll();
		int did = ls.get(u.getId()%ls.size()).getId();
		return did;
	}

}
