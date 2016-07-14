package com.bupt.chatline.advice;

import java.lang.reflect.Method;

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
		Method method = methodInvocation.getMethod();
		Object result = methodInvocation.proceed();
		long end = System.currentTimeMillis();
		String mes = methodInvocation.getMethod().toGenericString();
		String args = "";
		for(int i = 0;i <  methodInvocation.getArguments().length;i++){
			args+=methodInvocation.getArguments()[i].toString() + " ";
		}
		mes += " Parameter: "+ args;
		if(result!=null)mes += " Return: " + result.toString();
		else mes += " Return: void ";
		mes += " Runtime：" + (end - start);
		logger.debug(mes);
		return result;
	}
}