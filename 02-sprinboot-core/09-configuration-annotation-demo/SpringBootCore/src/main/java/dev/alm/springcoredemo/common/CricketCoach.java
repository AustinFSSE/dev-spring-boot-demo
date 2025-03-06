package dev.alm.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor -> " + this.getClass().getSimpleName());
    }


    @Override
    public String getDailyWorkout() {
        return "do 20 cricket push-ups";
    }
}
