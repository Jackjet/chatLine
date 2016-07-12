package com.bupt.chatline.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bupt.chatline.entity.User;

@Component
public class UserSalesmanDistributedFactory {
	@Autowired
	private PollingUserSalesmanDistributedStrategy pollingUserSalesmanDistributedStrategy;
	
	
    public PollingUserSalesmanDistributedStrategy getPollingUserSalesmanDistributedStrategy() {
		return pollingUserSalesmanDistributedStrategy;
	}

	public void setPollingUserSalesmanDistributedStrategy(
			PollingUserSalesmanDistributedStrategy pollingUserSalesmanDistributedStrategy) {
		this.pollingUserSalesmanDistributedStrategy = pollingUserSalesmanDistributedStrategy;
	}

	public int distributed(User u){
    	return pollingUserSalesmanDistributedStrategy.distributed(u);
    }
}
