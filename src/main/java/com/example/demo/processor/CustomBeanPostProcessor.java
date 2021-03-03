package com.example.demo.processor;

import com.example.demo.api.SampleResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof SampleResource) {
            LOGGER.info("Hey! I know this guy: {}. Nice to see you!", beanName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof SampleResource) {
            LOGGER.info("Hopefully we'll meet again, {}!", beanName);
        }
        return bean;
    }


}
