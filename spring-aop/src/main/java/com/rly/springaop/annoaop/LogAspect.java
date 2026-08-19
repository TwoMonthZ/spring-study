package com.rly.springaop.annoaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//切面类
@Component
@Aspect
public class LogAspect {

    //设置切入点和通知类型
    //切入点表达式 execution(访问修饰符 增强方法返回类型* 方法类全路径.方法名*(参数列表..))
    //通知类型 前置 @Before()
    @Before("execution(public int com.rly.springaop.annoaop.CalcutorImpl.add(int,int))")
    public void before(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("前置方法,方法"+name+"参数"+ Arrays.toString(args));
    }

    // 返回  @AfterReturning()
    @AfterReturning(value = "execution(* com.rly.springaop.annoaop.CalcutorImpl.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("返回方法,方法"+name+"参数"+ Arrays.toString(args)+"目标方法返回值"+result);
    }

    // 异常  @AfterThrowing()
    @AfterThrowing(value = "execution(* com.rly.springaop.annoaop.CalcutorImpl.*(..))", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Throwable exception){
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("异常方法,方法"+name+"参数"+ Arrays.toString(args)+"目标方法异常"+exception);
    }

    // 后置  @After()
    // @After(value = "com.rly.springaop.annoaop.LogAspect.pointcut()")
    @After(value = "pointcut()")
    public void after(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("后置方法,方法"+name+"参数"+ Arrays.toString(args));
    }

    // 环绕  @Around()
    @Around("execution(* com.rly.springaop.annoaop.CalcutorImpl.*(..))")
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


    @Pointcut("execution(* com.rly.springaop.annoaop.CalcutorImpl.*(..))")
    public void pointcut(){}


}
