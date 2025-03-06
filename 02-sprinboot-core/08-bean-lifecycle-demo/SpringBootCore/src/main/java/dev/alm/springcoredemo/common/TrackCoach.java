package dev.alm.springcoredemo.common;


import org.springframework.stereotype.Component;

@Component

public class TrackCoach implements Coach {

    public TrackCoach() {
        System.out.println("In constructor -> " + this.getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "35 Track push-ups! Now!";
    }
}
