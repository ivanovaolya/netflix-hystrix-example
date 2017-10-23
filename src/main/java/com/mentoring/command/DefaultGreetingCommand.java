package com.mentoring.command;

import com.netflix.config.DynamicIntProperty;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class DefaultGreetingCommand extends HystrixCommand<String> {

    private final String name;

    DynamicIntProperty timeWait = DynamicPropertyFactory.getInstance().
            getIntProperty("hystrixdemo.sleep", 100);

    public DefaultGreetingCommand(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
        System.out.println("Default value <timeWait> = " + timeWait.getDefaultValue());
    }

    @Override
    protected String run() throws Exception {
        System.out.println("timeWait = " + timeWait.get() + "ms");

        return "Hello " + name + "!";
    }

}
