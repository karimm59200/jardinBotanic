package com.example.application;

import com.example.application.config.ApiRestInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Collections;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication infra = new SpringApplication(org.application.config.InfrastructureConfig.class);
        infra.setDefaultProperties(Collections.singletonMap("server.port", "8082"));
        ConfigurableApplicationContext infraContext = infra.run();

        SpringApplication apiRest = new SpringApplication(org.application.config.ApiRestConfig.class);
        apiRest.setDefaultProperties(Collections.singletonMap("server.port", "8081"));
        apiRest.addInitializers(new ApiRestInitializer(infraContext));
        ConfigurableApplicationContext apiRestContext = apiRest.run();
    }

}
