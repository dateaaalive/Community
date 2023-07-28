package com.example.community.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {

    @Pointcut("execution(* com.example.community.service.*.*(..))")
    public void pointcut(){
        System.out.println("pointcut...");
    }

    @Before("pointcut()")
    public void before(){
        System.out.println("before...");
    }

    @After("pointcut()")
    public void after(){
        System.out.println("after...");
    }

    @AfterReturning("pointcut()")
    public void afterReturn(){
        System.out.println("afterReturn...");
    }

    @AfterThrowing("pointcut()")
    public void afterThrow(){
        System.out.println("afterThrow...");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        Object proceed = joinPoint.proceed();
        System.out.println("around...");
        return proceed;
    }

}
