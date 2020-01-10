package com.splice.example.config;

import com.splice.example.pages.CommunityPage;
import com.splice.example.pages.HomePage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"com.splice.example.pages"})
@PropertySource(value = "classpath:application.properties")
public class PageObjectConfig {

    @Bean
    public HomePage homePage() {
        return new HomePage();
    }

    @Bean
    public CommunityPage communityPage() {
        return new CommunityPage();
    }
}