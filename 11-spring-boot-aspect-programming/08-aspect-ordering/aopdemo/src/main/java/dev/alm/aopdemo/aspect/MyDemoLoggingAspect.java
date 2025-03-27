package dev.alm.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {


    @Before("dev.alm.aopdemo.aspect.PointcutExpressions.forDaoPackageExcludingGettersAndSetters()")
    public void beforeAddAccount() {
        System.out.println("before addAccount");
    }



}
