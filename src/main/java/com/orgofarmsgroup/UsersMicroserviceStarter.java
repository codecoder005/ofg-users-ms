package com.orgofarmsgroup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableAutoConfiguration
@EnableDiscoveryClient
public class UsersMicroserviceStarter extends SpringBootServletInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsersMicroserviceStarter.class);
    public static void main(String[] args) {
        SpringApplication.run(UsersMicroserviceStarter.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(UsersMicroserviceStarter.class);
    }
    @PostConstruct
    public void postConstruct(){
        LOGGER.info("POST-CONSTRUCT initiated...");
    }
}
