package snippet;

public class Snippet {
	<?xml version="1.0" encoding="UTF-8"?>
	<beans xmlns="http://www.springframework.org/schema/beans"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context"
		xsi:schemaLocation="http://www.springframework.org/schema/beans
				http://www.springframework.org/schema/beans/spring-beans-4.1.xsd
				http://www.springframework.org/schema/context
				http://www.springframework.org/schema/context/spring-context-4.1.xsd">
		<!-- 加载配置文件 -->
		
		<context:property-placeholder location="classpath:config.properties"/>
		<!-- 扫描service自动注入为bean -->
		<context:component-scan base-package="org.shopbook.service.impl,org.shopbook.dao.impl" />
	
	</beans>
}

