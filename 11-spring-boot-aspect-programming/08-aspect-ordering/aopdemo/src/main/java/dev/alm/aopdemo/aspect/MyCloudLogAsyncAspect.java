package dev.alm.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyCloudLogAsyncAspect {

    @Before("dev.alm.aopdemo.aspect.PointcutExpressions.forDaoPackageExcludingGettersAndSetters()")
    public void logToCloudAsync() {
        System.out.println("logging to Cloud Async");
    }
}
