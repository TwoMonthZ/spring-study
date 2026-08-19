package com.rly.springaop.xmlaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//切面类
@Component
public class LogAspect {


    public void before(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("前置方法,方法"+name+"参数"+ Arrays.toString(args));
    }


    public void afterReturning(JoinPoint joinPoint, Object result){
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("返回方法,方法"+name+"参数"+ Arrays.toString(args)+"目标方法返回值"+result);
    }

    public void afterThrowing(JoinPoint joinPoint, Throwable exception){
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("异常方法,方法"+name+"参数"+ Arrays.toString(args)+"目标方法异常"+exception);
    }

    public void after(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("后置方法,方法"+name+"参数"+ Arrays.toString(args));
    }

    public Object around(ProceedingJoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        Object result = null;
        try {
            System.out.println("环绕方法，目标方法之前执行,方法"+name+"参数"+ Arrays.toString(args));
            //调用目标方法
            result = joinPoint.proceed();

            System.out.println("环绕方法，目标方法之后执行,方法"+name+"参数"+ Arrays.toString(args));
        } catch (Throwable e) {
            System.out.println("环绕方法，目标方法异常执行,方法"+name+"参数"+ Arrays.toString(args)+"异常"+e);
        } finally {
            System.out.println("环绕方法，目标方法结束执行,方法"+name+"参数"+ Arrays.toString(args));
        }
        return result;
    }


    public void pointcut(){}


}
