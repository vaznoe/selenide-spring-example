package com.splice.example.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestProperty {

    @Value("${base.url}")
    private String baseUrl;

    public String getBaseUrl() {
        return baseUrl;
    }
}
