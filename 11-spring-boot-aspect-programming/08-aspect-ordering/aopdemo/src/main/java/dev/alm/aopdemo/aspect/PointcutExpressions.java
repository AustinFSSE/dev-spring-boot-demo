package dev.alm.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutExpressions {
    // this is where we add all of our related advices for logging
    // match any addAccount() method in any class
    // .. means match on any number of parameters
    //
    @Pointcut("execution(* dev.alm.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    // pointcut for getter methods
    @Pointcut("execution(* dev.alm.aopdemo.dao.*.get*(..))")
    public void getters(){}

    // pointcut for setter methods
    @Pointcut("execution(* dev.alm.aopdemo.dao.*.set*(..))")
    public void setters(){}

    // pointcut excluding getter and setter methods
    @Pointcut("forDaoPackage() && !(getters() || setters())")
    public void forDaoPackageExcludingGettersAndSetters() {}
}
