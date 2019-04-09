package com.figo.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
  切面类
 */
@Aspect
@Component
public class LogOfAspect {

    @Pointcut("execution(public int com.figo.aop.MathCaculator.*(..))")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName()+"运行。。。参数列表是:"+ Arrays.asList(args) );
    }

    @After("pointCut()")
    public void logEnd(){
        System.out.println("除法结束");
    }

    @AfterReturning(value = "pointCut()",returning = "o")
    public void logReturn(Object o){
        System.out.println("除法正常返回。。。运行结果：{"+o+"}");
    }

    @AfterThrowing(value = "pointCut()",throwing = "e")
    public void logException(Exception e){
        System.out.println("除法异常。。。异常信息：{"+e.getMessage()+"}");
    }
}
