package com.igate.aop;

import org.aspectj.lang.ProceedingJoinPoint;

//@Aspect
public class MyAdvice {
	
	public void beforeMethod() {
		System.out.println("Before Method Call");
	}

	public void aroundMethod(ProceedingJoinPoint joinpoint) {
		System.out.println("Around (Before) Method Call");
		try{
		joinpoint.proceed();
		}catch(Throwable t){}
		System.out.println("In excepiton");
		System.out.println("Around (After) Method Call");
	}

	public void afterMethod() {
		System.out.println("After Method Call");
	}

	
}
