package dev.alm.springcoredemo.rest;


import dev.alm.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController  {

    // define a private field for the dependency
    private Coach myCoach;

    @Autowired
//    public DemoController(Coach coach) {
//        this.myCoach = coach;
//    }
    public void setCoach(Coach coach) {
        myCoach = coach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
