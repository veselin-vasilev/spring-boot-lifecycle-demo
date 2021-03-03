package com.example.demo.event;

import org.springframework.context.ApplicationEvent;

public class RunnerReadyEvent extends ApplicationEvent {

    private final String message;

    public RunnerReadyEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
