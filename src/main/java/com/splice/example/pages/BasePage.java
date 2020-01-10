package com.splice.example.pages;

import com.splice.example.config.PageObjectConfig;
import com.splice.example.config.TestConfig;
import com.splice.example.config.properties.TestProperty;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = { TestConfig.class, PageObjectConfig.class })
public abstract class BasePage {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected TestProperty property;

    public abstract <T> T openPage();
}