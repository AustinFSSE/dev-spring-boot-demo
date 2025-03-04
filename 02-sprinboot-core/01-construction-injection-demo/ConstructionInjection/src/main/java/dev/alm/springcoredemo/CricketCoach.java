package dev.alm.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "do 20 cricket push-ups!!!!";
    }
}
