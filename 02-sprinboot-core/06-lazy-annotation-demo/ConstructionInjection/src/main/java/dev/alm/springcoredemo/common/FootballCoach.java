package dev.alm.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class FootballCoach implements Coach {

    public FootballCoach() {
        System.out.println("In constructor -> " + this.getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "50 football push-ups! Now!";
    }
}
