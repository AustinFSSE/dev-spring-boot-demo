package dev.alm.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

    public BaseballCoach() {
        System.out.println("In constructor -> " + this.getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "20 baseball push ups! Now!";
    }
}
