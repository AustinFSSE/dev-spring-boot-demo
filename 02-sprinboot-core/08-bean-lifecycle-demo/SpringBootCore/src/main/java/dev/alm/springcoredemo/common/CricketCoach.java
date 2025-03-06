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

    // define our init method
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("In doMyStartupStuff -> " + this.getClass().getSimpleName());
    }
    // define our destroy method
    @PreDestroy
    public void doMyShutdownStuff() {
        System.out.println("In doMyShutdownStuff -> " + this.getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "do 20 cricket push-ups";
    }
}
