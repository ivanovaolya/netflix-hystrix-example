package com.mentoring.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author ivanovaolyaa
 * @version 10/18/2017
 */
@Service
public class GreetingService {

    //@HystrixCommand(fallbackMethod = "defaultGreeting")
    public String getGreeting(String username) {
        return new RestTemplate()
                .getForObject("http://localhost:8086/greeting/{username}",
                        String.class, username);
    }

    private String defaultGreeting(String username) {
        return "Hello default user!";
    }
}
