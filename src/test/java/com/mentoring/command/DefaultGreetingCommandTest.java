package com.mentoring.command;

import com.netflix.config.ChainedDynamicProperty;
import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicIntProperty;
import com.netflix.config.DynamicPropertyFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class DefaultGreetingCommandTest {

    @Test
    void run() throws InterruptedException {
        DefaultGreetingCommand command = new DefaultGreetingCommand("Olha");
        assertEquals(command.execute(), "Hello Olha!");
        Thread.sleep(1000);
        ConfigurationManager.getConfigInstance().setProperty("hystrixdemo.sleep", 22);
        assertEquals(new DefaultGreetingCommand("Vasya").execute(), "Hello Vasya!");
    }

    @Test
    public void testInteger() throws Exception {
        /**
         * Do not declare 'defaultInt' parameter (which is going to be changed) in config.properties
         * https://github.com/Netflix/archaius/issues/424
         */
        DynamicIntProperty pInt = DynamicPropertyFactory.getInstance().getIntProperty("defaultInt", -1);
        ConfigurationManager.getConfigInstance().setProperty("defaultInt", -1);
        ChainedDynamicProperty.IntProperty fInt = new ChainedDynamicProperty.IntProperty("overrideInt", pInt);

        assertTrue(-1 == fInt.get());

        ConfigurationManager.getConfigInstance().setProperty("defaultInt", 10);
        assertTrue(10 == fInt.get());

        ConfigurationManager.getConfigInstance().setProperty("overrideInt", 11);
        assertTrue(11 == fInt.get());

        ConfigurationManager.getConfigInstance().clearProperty("overrideInt");
        assertTrue(10 == fInt.get());

        ConfigurationManager.getConfigInstance().clearProperty("defaultInt");
        assertTrue(-1 == fInt.get());

        assertEquals(Integer.valueOf(-1), fInt.getDefaultValue());
    }

}