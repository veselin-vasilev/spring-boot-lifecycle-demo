package com.example.demo.listener;

import com.example.demo.event.RunnerReadyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.RequestHandledEvent;

@Slf4j
@Component
public class BeanListenerConfig {

    @EventListener
    public void appStarted(ApplicationStartedEvent event) {
        LOGGER.info("The ApplicationStartedEvent has been fired. The context was refreshed, but no command-line or application runners have been called yet.");
    }

    @EventListener
    public void availabilityChange(AvailabilityChangeEvent event) {
        LOGGER.info("An AvailabilityChangeEvent has been fired. The state is: {} of type: {}", event.getState(), event.getState().getClass().getSimpleName());
    }

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        LOGGER.info("The ApplicationReadyEvent has been fired. Command-line and application runners have been called and are completed.");
    }

    @EventListener
    public void contextRefreshed(ContextRefreshedEvent event) {
        LOGGER.info("The context was refreshed.");
    }

    @EventListener
    public void webServerInitialized(WebServerInitializedEvent event) {
        LOGGER.info("The WebServer is ready! It will listen on port: {}", event.getWebServer().getPort());
    }

    @EventListener
    public void contextClosed(ContextClosedEvent event) {
        LOGGER.info("The context with id = {} has been closed. Time to do shutdown operations.", event.getApplicationContext().getId());
    }

    @EventListener
    public void requestHandled(RequestHandledEvent event) {
        LOGGER.info("A request was handled: {}", event.getDescription());
    }

    @EventListener
    public void customRunnerReadyEvent(RunnerReadyEvent event) {
        LOGGER.info("A runner send a RunnerReadyEvent with a message: {}", event.getMessage());
    }

}
