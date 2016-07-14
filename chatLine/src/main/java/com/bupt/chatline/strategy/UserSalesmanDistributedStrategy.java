package com.bupt.chatline.strategy;

import com.bupt.chatline.entity.User;

public abstract class UserSalesmanDistributedStrategy {
	//-2:no salesman is available
	public abstract int distributed(User u);
}
