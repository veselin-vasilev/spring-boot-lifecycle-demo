package com.example.demo.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@RestController
@RequestMapping("/v1/sample")
@Slf4j
public class SampleResource implements ApplicationContextAware {

    @Value("${someProp}")
    private String configValue;

    @GetMapping("/parameterized-endpoint")
    public String sampleEndpoint(@RequestParam("someParam") final String param) {
        LOGGER.info("The param: {}", param);
        return "You have passed me a parameter and I logged it! I was also configured to tell you this: " + configValue;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        LOGGER.info("I'm an overly curious bean and I know stuff about the context that created me, like its id! It's: {}",
                applicationContext.getId());
    }

    @PostConstruct
    public void postConstruct() {
        LOGGER.info("Hello there!");
    }

    @PreDestroy
    public void preDestroy() {
        LOGGER.info("May the force be with you!");
    }
}
