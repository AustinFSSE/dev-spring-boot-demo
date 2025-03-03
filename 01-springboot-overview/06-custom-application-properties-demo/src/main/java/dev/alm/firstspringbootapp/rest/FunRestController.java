package dev.alm.firstspringbootapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }
    @GetMapping("/admin")
    public String sayAdmin() {
        return "Hello Admin!!!";
    }

    @GetMapping("/teaminfo")
    public String sayTeamInfo() {
        return coachName + " " + teamName;
    }

}
