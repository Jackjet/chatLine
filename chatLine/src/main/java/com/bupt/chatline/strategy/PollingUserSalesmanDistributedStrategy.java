package com.bupt.chatline.strategy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bupt.chatline.entity.Salesman;
import com.bupt.chatline.entity.User;
import com.bupt.chatline.service.SalesmanDaoService;
import com.bupt.chatline.service.UserDaoService;

@Component
public class PollingUserSalesmanDistributedStrategy extends UserSalesmanDistributedStrategy {
	@Autowired
	private SalesmanDaoService salesmanDaoService;
	@Autowired
	private UserDaoService userDaoService;
	
	public SalesmanDaoService getSalesmanDaoService() {
		return salesmanDaoService;
	}

	public void setSalesmanDaoService(SalesmanDaoService salesmanDaoService) {
		this.salesmanDaoService = salesmanDaoService;
	}

	@Override
	public int distributed(User u) {
		List<Salesman> ls = salesmanDaoService.findAll();
		int dsalesmanid = ls.get(u.getId()%ls.size()).getId();
		int did = -1;
		if(userDaoService.findByEid(dsalesmanid) != null && (u.getEid() == -1 || salesmanDaoService.findById(u.getEid()) == null)){
			did = userDaoService.findByEid(dsalesmanid).getId();
		}
		return did;
	}

}
