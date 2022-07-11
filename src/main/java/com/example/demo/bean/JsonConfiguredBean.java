package com.example.demo.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

@Data
@ToString
public class JsonConfiguredBean {

    @Value("${feedbackUrl}")
    private String feedbackUrl;
}
