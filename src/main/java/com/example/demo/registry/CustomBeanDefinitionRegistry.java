package com.example.demo.registry;

import com.example.demo.bean.JsonConfiguredBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
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
        final var jsonConfiguredBeanDefinition = new RootBeanDefinition(JsonConfiguredBean.class);
        registry.registerBeanDefinition("jsonConfiguredBean", jsonConfiguredBeanDefinition);
        LOGGER.info("I just registered a new Bean Definition for: {}", jsonConfiguredBeanDefinition.getBeanClass().getSimpleName());
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        final var sampleResourceDefinition = beanFactory.getBeanDefinition("sampleResource");
        sampleResourceDefinition.setDependsOn("sampleApplicationRunner");
        LOGGER.info("I can manipulate the bean definitions! Here, this is the bean definition of my friend the SampleResource: {}.",
                sampleResourceDefinition);
    }
}
