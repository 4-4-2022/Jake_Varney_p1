package com.revature.util;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component("loggingAspect")
public class LoggingAspect {

	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Pointcut("within(com.revature.controllers.*)")
	public void logWithinControllerPackage() {}
	
	@After("logWithinControllerPackage()")
	public void logAfter(JoinPoint jp) {
		logger.info("Logged after: " + jp.getSignature().getName());
	}
}
