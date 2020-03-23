package com.douzone.container.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.douzone.container.user.User;

import config.user.AppConfig01;

public class JavaConfig {

	public static void main(String[] args) {
//		testJavaConfig01();
		testJavaConfig02();

	}
	

	//JavaConfig01
	//직접 자바설정 클래스를 전달
	public static void testJavaConfig01() {
		ApplicationContext appContext 
			= new AnnotationConfigApplicationContext(AppConfig01.class);//클래스이름을 넣음
		
		User user = appContext.getBean(User.class);
		System.out.println(user);
		
		((ConfigurableApplicationContext)appContext).close();
	}
	

	//베이스 패키지를 넣음 - @Configuration 어노테이션이 붙어있어야한다
	public static void testJavaConfig02() {
		ApplicationContext appContext
			= new AnnotationConfigApplicationContext("config.user"); //패키지이름을 넣음
		
		User user = appContext.getBean(User.class);
		System.out.println(user);
		
		((ConfigurableApplicationContext)appContext).close();		
	}

}
