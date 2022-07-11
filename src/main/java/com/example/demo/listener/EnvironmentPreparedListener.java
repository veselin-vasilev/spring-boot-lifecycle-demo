package com.example.demo.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;

@Slf4j
public class EnvironmentPreparedListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        LOGGER.info("The ApplicationEnvironmentPreparedEvent has been fired. The Environment for the context is known at this stage.");
        LOGGER.info("We have successfully provided the custom property with value: \"{}\"", event.getEnvironment().getProperty("feedbackUrl"));
    }
}
