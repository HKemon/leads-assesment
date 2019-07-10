package com.leads.assesment.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.leads.assesment.*")
@SpringBootApplication
public class AssesmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssesmentApplication.class, args);
    }

}
