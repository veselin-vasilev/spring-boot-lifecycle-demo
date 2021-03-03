package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SimpleCustomBean {
    private final static String SOMETHING = "A secret";

    public String someMethod() {
        return SOMETHING;
    }
}
