package com.example.demo.api;

import com.example.demo.bean.JsonConfiguredBean;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/sample")
@Slf4j
public class SampleResource implements ApplicationContextAware {

    @Autowired
    private JsonConfiguredBean jsonConfiguredBean;

    private String someTruth;

    @GetMapping("/truth")
    public String truth() {
        return "I was configured to tell you this: " + someTruth;
    }

    @GetMapping("/feedback")
    public String feedback() {
        return "Help me improve! -> " + jsonConfiguredBean.getFeedbackUrl();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        LOGGER.info("I'm an overly curious bean and I know stuff about the context that created me, like its id! It's: {}",
                applicationContext.getId());
    }

    @PostConstruct
    public void postConstruct() {
        LOGGER.info("I can influence the way I was initialized - pineapple doesn't go on pizza!");
        someTruth = "Pineapple is not allowed on pizza!";
    }

    @PreDestroy
    public void preDestroy() {
        LOGGER.info("Pineapple doesn't go on pizza is a hill I'll die on!");
    }

    public void setSomeTruth(String someTruth) {
        this.someTruth = someTruth;
    }
}
