package com.example.demo.processor;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class JsonPropertySourceProcessor implements EnvironmentPostProcessor {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @SneakyThrows
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        final var fileName = "config.json";
        final var jsonConfigResource = new ClassPathResource(fileName);
        final Map<String, String> customProperties = MAPPER.readValue(jsonConfigResource.getFile(), new TypeReference<>() {});
        final PropertySource<Map<String, String>> customPropertySource = new PropertySource<>("customPropertySource", customProperties) {
            @Override
            public Object getProperty(String name) {
                return getSource().get(name);
            }
        };
        environment.getPropertySources().addLast(customPropertySource);
        LOGGER.info("Configured the {} property source", fileName);
    }
}
