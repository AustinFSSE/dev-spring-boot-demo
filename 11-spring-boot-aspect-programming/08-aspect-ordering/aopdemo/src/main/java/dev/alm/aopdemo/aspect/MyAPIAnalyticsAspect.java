package dev.alm.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyAPIAnalyticsAspect {
    @Before("dev.alm.aopdemo.aspect.PointcutExpressions.forDaoPackageExcludingGettersAndSetters()")
    public void performApiAnalytics() {
        System.out.println("performApiAnalytics");
    }
}
