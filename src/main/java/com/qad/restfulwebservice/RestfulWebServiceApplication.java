package com.qad.restfulwebservice;

import com.qad.restfulwebservice.jwt.Users.JanCreator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RestfulWebServiceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RestfulWebServiceApplication.class, args);
        context.getBean(JanCreator.class).execute();

    }
}

