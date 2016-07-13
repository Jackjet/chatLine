package com.bupt.chatline.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

public class GeneralMesAroundAdvice implements MethodInterceptor {
	private static Logger logger = Logger.getLogger(GeneralMesAroundAdvice.class);  
	@Override
	/**
	 * 记录方法运行时间
	 */
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		long start = System.currentTimeMillis();
		Object result = methodInvocation.proceed();
		long end = System.currentTimeMillis();
		String args = "";
		for(int i = 0;i <  methodInvocation.getArguments().length;i++){
			args+=methodInvocation.getArguments()[i].toString() + " ";
		}
		logger.debug(methodInvocation.getMethod().toGenericString() + " Parameter: "+ args + " Return: " + result.toString() + " Runtime：" + (end - start));
		return result;
	}
}