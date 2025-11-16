package com.example.backend;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	@Before("execution(* com.example.backend.auth.controller.*.*(..))")
	public void logsBefore(JoinPoint jp) {
	    System.out.println("Before Method Started: " + jp.getSignature().getName());
	}

	@After("execution(* com.example.backend.auth.controller.*.*(..))")
	public void logsAfter(JoinPoint jp) {
	    System.out.println("Method End: " + jp.getSignature().getName());
	}

}
