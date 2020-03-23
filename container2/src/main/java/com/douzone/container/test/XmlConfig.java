package com.douzone.container.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.douzone.container.user.User;
import com.douzone.container.user.User1;

public class XmlConfig {
	public static void main(String[] args) {

//		testBeanFactory01();	
//		testBeanFactory02();
		
		testApplicationContext01();
//		testApplicationContext02();
	}
	
	public static void testApplicationContext02() {
		ApplicationContext appContext
			= new ClassPathXmlApplicationContext("config/user/applicationContext02.xml");
// --------------- 기본생성자 -------------------//		
		//id로 빈 가져오기
		User user = (User)appContext.getBean("user");
		System.out.println(user);
		
		//name으로 빈 가져오기
		user = (User)appContext.getBean("usr");
		System.out.println(user);
		
// --------------- 기본생성자 -------------------//
		
// --------------- 기본생성자 -------------------//		
		//type으로 가져오기
		//같은타입의 객체가 2개 이상 있는 경우 type으로만 가져오면 에러가 난다
// 		<bean id="user"  name="usr" class="com.douzone.container.user.User"/>
//		<bean id="user2"  name="usr2" class="com.douzone.container.user.User">  타입 2개
		
		//type+id 또는 type+name으로 가져와 줘야 한다.
		//1개 파라미터로 생성된 빈 가져오기
		user = appContext.getBean("user2",User.class);
// 혹은	user = appContext.getBean("usr2",User.class);		
		System.out.println(user);
// --------------- 파라미터 생성자 -------------------//		
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
		
	}
	
	
	public static void testApplicationContext01() {
		ApplicationContext appContext
			= new ClassPathXmlApplicationContext("config/user/applicationContext01.xml");
		
		User1 user1 = appContext.getBean(User1.class);
		System.out.println(user1.getName());
		
		user1 = (User1)appContext.getBean("user1");
		System.out.println(user1.getName());
		
		((ClassPathXmlApplicationContext)appContext).close();
	}
	

	// xml 암시적 설정방법
	public static void testBeanFactory01() {
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("config/user/applicationContext01.xml"));
		
		User1 user1 = bf.getBean(User1.class); // => User1에 @Component 어노테이션 필요
		System.out.println(user1.getName());
		
		//Bean의 id가 자동으로 설정됨 => User1.java를 id로 소문자 user1로 받음
		user1 =(User1)bf.getBean("user1");
		System.out.println(user1.getName());
	}
	
	// xml 명시적 설정방법
	public static void testBeanFactory02() {
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("config/user/applicationContext02.xml"));
		
		User1 user1 = bf.getBean(User1.class); // => <bean class="com.douzone.container.user.User1"/> 명시적으로 설정 필요
		System.out.println(user1.getName());
		
		user1 = (User1)bf.getBean("user1"); // => <bean id="user1" class="com.douzone.container.user.User1"/> 명시적으로 설정 필요
		System.out.println(user1.getName());
		// 명시적 방법에는 User1.java에 @Component이 필요없다(그러나 항상 붙여주는것이 좋다)
	}
}
