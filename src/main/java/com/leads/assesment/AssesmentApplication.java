package com.leads.assesment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

//@EnableConfigurationProperties
@ComponentScan("com.leads.assesment.*")
@SpringBootApplication
public class AssesmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssesmentApplication.class, args);
    }

}
