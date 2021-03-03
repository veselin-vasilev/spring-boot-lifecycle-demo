package com.example.demo.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomBeanDefinitionFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        final var sampleResourceDefinition = beanFactory.getBeanDefinition("beanListenerConfig");
        LOGGER.info("I can manipulate the bean definitions! Here, this is the bean definition of my friend the BeanListenerConfig: {}.",
                sampleResourceDefinition);
    }
}
