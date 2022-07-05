package com.example.demo.api;

import com.example.demo.bean.SecretBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private SecretBean secretBean;

    private String notAutowired;

    @GetMapping("/secret")
    public String sampleEndpoint() {
        return "I was configured to tell you this: " + secretBean.getSecret();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        LOGGER.info("I'm an overly curious bean and I know stuff about the context that created me, like its id! It's: {}",
                applicationContext.getId());
    }

    @PostConstruct
    public void postConstruct() {
        LOGGER.info("Hello there!");
        notAutowired = "I was created in postConstruct!";
    }

    @PreDestroy
    public void preDestroy() {
        LOGGER.info("May the force be with you!");
    }
}
