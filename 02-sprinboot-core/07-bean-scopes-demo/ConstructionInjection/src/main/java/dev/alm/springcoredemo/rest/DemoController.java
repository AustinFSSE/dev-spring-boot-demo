package dev.alm.springcoredemo.rest;


import dev.alm.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController  {

    // define a private field for the dependency
    private Coach myCoach;
    private Coach anotherCoach;
    @Autowired
    public DemoController(@Qualifier(value = "baseballCoach") Coach coach,
                          @Qualifier(value = "baseballCoach") Coach anotherCoach) {
        this.myCoach = coach;
        this.anotherCoach = anotherCoach;
        System.out.println("In constructor -> " + this.getClass().getSimpleName());
    }
//    public void setCoach(Coach coach) {
//        myCoach = coach;
//    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        return "These two coaches are the same instance ---> " + (myCoach == anotherCoach);
    }
}
