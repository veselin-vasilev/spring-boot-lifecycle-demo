package com.example.demo.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Order(0)
public class SampleCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("I'm running a task on startup!");
        Thread.sleep(1000);
        LOGGER.info("I'm done with my task!");
    }
}
