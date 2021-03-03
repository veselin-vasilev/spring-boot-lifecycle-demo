package com.example.demo.registry;

import com.example.demo.bean.SimpleCustomBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomBeanDefinitionRegistry implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        LOGGER.info("I can manipulate the registries!");
        final var customBeanDefinition = new RootBeanDefinition(SimpleCustomBean.class);
        registry.registerBeanDefinition("simpleCustomBean", customBeanDefinition);
        LOGGER.info("I just registered a new Bean Definition for: {}", customBeanDefinition.getBeanClass().getSimpleName());
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        final var sampleResourceDefinition = beanFactory.getBeanDefinition("sampleResource");
        LOGGER.info("I can manipulate the bean definitions! Here, this is the bean definition of my friend the SampleResource: {}.",
                sampleResourceDefinition);
    }
}
