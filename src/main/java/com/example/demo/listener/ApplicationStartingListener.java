package com.example.demo.listener;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

public class ApplicationStartingListener implements ApplicationListener<ApplicationStartingEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        System.out.println("Starting application with webApplicationType: " + event.getSpringApplication().getWebApplicationType());
        System.out.println("At this point even logging is not configured yet!");
    }
}
