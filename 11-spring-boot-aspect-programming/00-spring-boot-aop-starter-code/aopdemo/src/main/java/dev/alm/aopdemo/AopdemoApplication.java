package dev.alm.aopdemo;

import dev.alm.aopdemo.dao.AccountDAOImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopdemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAOImpl accountDAO) {

        return runner -> demoTheBeforeAdvice(accountDAO);
    }

    private void demoTheBeforeAdvice(AccountDAOImpl accountDAO) {

        // call the business method
        accountDAO.addAccount();


    }
}
