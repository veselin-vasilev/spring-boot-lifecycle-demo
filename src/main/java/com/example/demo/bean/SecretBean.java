package com.example.demo.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

@Data
@ToString
public class SecretBean {

    @Value("${secret}")
    private String secret;

    public String getSecret() {
        return secret;
    }
}
