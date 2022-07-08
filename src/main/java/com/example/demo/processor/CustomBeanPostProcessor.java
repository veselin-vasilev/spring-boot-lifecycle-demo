package com.example.demo.processor;

import com.example.demo.api.SampleResource;
import com.example.demo.bean.SecretBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    private SecretBean secretBean;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof SampleResource) {
            LOGGER.info("Hey! I know this guy: {}. Let me tell you something, ", beanName);
            ((SampleResource) bean).setSomeTruth(secretBean.getSecret());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof SampleResource) {
            LOGGER.info("No, no, no! Pineapple does go on pizza, {}!", beanName);
            ((SampleResource) bean).setSomeTruth(secretBean.getSecret());
        }
        return bean;
    }


}
