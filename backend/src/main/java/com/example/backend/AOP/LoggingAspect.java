package com.example.backend.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // BEFORE method
    @Before("execution(* com.example.backend.auth.controller.*.*(..))")
    public void logBefore(JoinPoint jp) {
        logger.info(" BEFORE "+jp.getSignature().getName());
    }

    // AFTER method (success or failure)
    @After("execution(* com.example.backend.auth.controller.*.*(..))")
    public void logAfter(JoinPoint jp) {
        logger.info("AFTER "+ jp.getSignature().getName());
    }

    // AFTER RETURNING (only if method succeeded)
    @AfterReturning(pointcut = "execution(* com.example.backend.auth.controller.*.*(..))",
                    returning = "result")
    public void logAfterReturning(JoinPoint jp, Object result) {
        logger.info("RETURNED: | Response:= "+jp.getSignature().getName()+"result:"+result);
    }

    // AFTER THROWING
    @AfterThrowing(pointcut = "execution(* com.example.backend.auth.controller.*.*(..))",
                   throwing = "ex")
    public void logAfterThrowing(JoinPoint jp, Exception ex) {
        logger.error("EXCEPTION in  | Error:"+jp.getSignature().getName(), ex.getMessage(), ex);
    }
}
