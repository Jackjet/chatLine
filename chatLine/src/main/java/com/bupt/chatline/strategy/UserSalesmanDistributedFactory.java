package com.bupt.chatline.strategy;

import com.bupt.chatline.entity.User;

public class UserSalesmanDistributedFactory {
	private static UserSalesmanDistributedFactory factory = null;
	private static UserSalesmanDistributedStrategy strategy = null;
    public static  UserSalesmanDistributedFactory getInstance(){
        if(factory==null){
            synchronized( UserSalesmanDistributedFactory.class){
                if(factory==null){
                    factory=new  UserSalesmanDistributedFactory();
                    strategy = new PollingUserSalesmanDistributedStrategy();
                }
            }
        }
        return factory;
    }
    public int distributed(User u){
    	return strategy.distributed(u);
    }
}
