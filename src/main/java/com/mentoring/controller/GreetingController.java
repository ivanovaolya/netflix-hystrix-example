package com.mentoring.controller;

import com.mentoring.service.GreetingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ivanovaolyaa
 * @version 10/18/2017
 */
@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greeting/{username}")
    public String greeting(@PathVariable("username") String username) {
        return String.format("Hello %s!\n", username);
    }

    @GetMapping("/service/{username}")
    public String serviceGreeting(@PathVariable("username") String username) {
        return greetingService.getGreeting(username);
    }

}
