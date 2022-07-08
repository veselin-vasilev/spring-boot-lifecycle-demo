package com.example.demo;

import com.example.demo.initializer.CustomContextInitializer;
import com.example.demo.listener.ApplicationPreparedListener;
import com.example.demo.listener.ContextInitializedListener;
import com.example.demo.listener.EnvironmentPreparedListener;
import com.example.demo.listener.ApplicationStartingListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication demo = new SpringApplication(DemoApplication.class);
    demo.addInitializers(new CustomContextInitializer());
    demo.addListeners(
        new ApplicationStartingListener(),
        new EnvironmentPreparedListener(),
        new ContextInitializedListener(),
        new ApplicationPreparedListener());
    demo.run(args);
  }
}
