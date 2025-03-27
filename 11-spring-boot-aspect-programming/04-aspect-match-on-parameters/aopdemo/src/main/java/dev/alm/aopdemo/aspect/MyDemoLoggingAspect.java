package dev.alm.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging
    // match any addAccount() method in any class
    // .. means match on any number of parameters
    //
    @Before("execution(* add*(dev.alm.aopdemo.Account, ..))")
    public void beforeAddAccount() {
        System.out.println("before addAccount");
    }


}
