package com.mentoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ivanovaolyaa
 * @version 10/18/2017
 */
@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
