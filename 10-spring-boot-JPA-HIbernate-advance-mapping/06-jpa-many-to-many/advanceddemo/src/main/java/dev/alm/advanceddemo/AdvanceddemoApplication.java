package dev.alm.advanceddemo;

import dev.alm.advanceddemo.dao.AppDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AdvanceddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdvanceddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDao appDao) {

        return runner -> {


        };
    }



}
