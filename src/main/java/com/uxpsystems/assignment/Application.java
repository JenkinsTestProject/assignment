package com.uxpsystems.assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.endpoint.HealthEndpoint;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.boot.logging.log4j2.Log4J2LoggingSystem;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan(basePackages = {"com.uxpsystems.assignment"})
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
    
    public static void main(String[] args) {
        System.setProperty(LoggingSystem.class.getName(), Log4J2LoggingSystem.class.getName());

        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        checkApplicationHealth(applicationContext);
    }

    /**
     * This will call the application's to retrieve the health status. If the overall health status is not 'UP', it will
     * 1. print an error providing the health resource details
     * 2. shutdown the application
     *
     * @param applicationContext the context to validate against
     */
    static void checkApplicationHealth(ConfigurableApplicationContext applicationContext) {
        // check if system health is UP, otherwise shutdown
        LOGGER.info("System is up and running");
        Health systemHealth = applicationContext.getBean(HealthEndpoint.class).invoke();
        if (Status.DOWN.equals(systemHealth.getStatus())) {
            LOGGER.error("System health not stable");
            applicationContext.close();
            return;
        }
    }
}
