package com.douzone.container.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.douzone.container.user.Friend;
import com.douzone.container.user.User;
import com.douzone.container.user.User1;

public class XmlConfig {

	public static void main(String[] args) {
//XML AutoConfiguration(Annotation Scanner)
//		testBeanFactory01();

//XML Bean Configuration(exmplicit Configuration) => User1에서 @Component어노테이션 필요없음	
//		testBeanFactory02();

//XML AutoConfiguration(Annotation Scanner)	
//		testApplicationContext01();
		
//XML Bean Configuration(explicit Configuration) => User1에서 @Component어노테이션 필요없음		
		testApplicationContext02();

	}

	//XML Bean Configuration(Explicit Configuration) => User1에서 @Component어노테이션 필요없음
	public static void testApplicationContext02() {
		ApplicationContext appContext 
			= new ClassPathXmlApplicationContext("config/user/applicationContext02.xml");
	
		//id로 빈 가져오기
		User user = (User)appContext.getBean("user");
		System.out.println(user);

		//name로 빈 가져오기
		user = (User)appContext.getBean("usr");
		System.out.println(user);		
		
		//1.type으로 가져오기
		//같은 타입의 객체가 2개 이상 있는 경우 type으로만 가져오면 에러
		// type + id 또는 type + name
		//2.1개 파라미터로 생성된 빈 가져오기
		user = appContext.getBean("user2", User.class);
		System.out.println(user);
		
		
		//2개 파라미터 생성자로 생성된 빈 가져오기
		user = appContext.getBean("user3", User.class);
		System.out.println(user);
		
		//2개 파라미터 생성자로 생성된 빈 가져오기2
		user = appContext.getBean("user4", User.class);
		System.out.println(user);		
		
		//setter를 사용한 빈 가져오기
		user = appContext.getBean("user5", User.class);
		System.out.println(user);				

		//User 객체를 생성하면서 friend 객체를 바로 DI하기
		user = appContext.getBean("user6", User.class);
		System.out.println(user);

		//setter를 사용한 빈 가져오기
		user = appContext.getBean("user7", User.class);
		System.out.println(user);		

		//자원정리
		((ClassPathXmlApplicationContext)appContext).close();
	}		
	
	//XML AutoConfiguration(Annotation Scanner)
	public static void testApplicationContext01() {
		ApplicationContext appContext 
			= new ClassPathXmlApplicationContext("config/user/applicationContext01.xml");
		
		//XML Auto-Configuration(Annotation Scanning)
		User1 user1 = appContext.getBean(User1.class);
		System.out.println(user1.getName());
		
		//Bean의 id가 자동으로 설정됨
		user1 = (User1)appContext.getBean("user1");
		System.out.println(user1.getName());		
		
		((ClassPathXmlApplicationContext)appContext).close();
	}


	
	
	
	
	
	
	
	
	
	
	
	//XML AutoConfiguration(Annotation Scanner)
	public static void testBeanFactory01() {
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("config/user/applicationContext01.xml"));
		
		//XML Auto-Configuration(Annotation Scanning)
		User1 user1 = bf.getBean(User1.class);
		System.out.println(user1.getName());
		
		//Bean의 id가 자동으로 설정됨
		user1 = (User1)bf.getBean("user1");
		System.out.println(user1.getName());		
	}

	//XML Bean Configuration(explicit Configuration) => User1에서 @Component어노테이션 필요없음
	public static void testBeanFactory02() {
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("config/user/applicationContext02.xml"));
		
		//XML Auto-Configuration(Annotation Scanning)
		User1 user1 = bf.getBean(User1.class);
		System.out.println(user1.getName());
		
		//Bean 설정에서는 의 Bean의 id가 자동으로 설정되지 않음.
		//applicationContext02.xml에서 id를 암시적으로 설정필요
		user1 = (User1)bf.getBean("user1");
		System.out.println(user1.getName());		
		

	}
}
