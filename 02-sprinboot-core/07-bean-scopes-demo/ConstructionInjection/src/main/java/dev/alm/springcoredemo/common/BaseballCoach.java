package dev.alm.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.beans.BeanProperty;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BaseballCoach implements Coach {

    public BaseballCoach() {
        System.out.println("In constructor -> " + this.getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "20 baseball push ups! Now!";
    }
}
