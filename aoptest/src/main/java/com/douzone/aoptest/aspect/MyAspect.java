package com.douzone.aoptest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	
	@Before("execution(public com.douzone.aoptest.vo.ProductVO com.douzone.aoptest.service.ProductService.find(String))")
	public void beforeAdvice() {
		System.out.println("---- before Advice ----");
	}
	
	@After("execution(* *..*.service.ProductService.*(..))")
	public void afterAdvice() {
		System.out.println("---- after Advice ----");
	}
	
	@AfterReturning("execution(* *..*.service.ProductService.*(..))")
	public void afterReturningAdvice() {
		System.out.println("---- afterReturningAdvice ----");
	}
	
	@AfterThrowing(value = "execution(* *..*.*.*(..))",throwing="ex")  //global exception
	public void afterThrowingAdvice(Throwable ex) {
		System.out.println("---- afterThrowingAdvice ----"+ex);
	}
	
	@Around("execution(* *..*.service.ProductService.*(..))")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		//before advice
		System.out.println("---- @Around(before) Advice ----");

//		pointCut 메소드 실행				
//		파라미터 가로채기(바꿔버리기)
//		Object[] params = {"Camera"};
//		Object result = pjp.proceed(params);
		
		Object result = pjp.proceed();

		//after advice
		System.out.println("---- @Around(after) Advice ----");
		
		return result;
	}
}
