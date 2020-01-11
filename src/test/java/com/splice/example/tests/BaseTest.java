package com.splice.example.tests;

import com.splice.example.config.PageObjectConfig;
import com.splice.example.config.TestConfig;
import com.splice.example.pages.CommunityPage;
import com.splice.example.pages.HomePage;
import com.splice.example.pages.PluginsPage;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

@ContextConfiguration(classes = {TestConfig.class, PageObjectConfig.class})
public abstract class BaseTest extends AbstractTestNGSpringContextTests {

    @Autowired
    public WebDriver driver;

    @Autowired
    protected HomePage homePage;

    @Autowired
    protected CommunityPage communityPage;

    @Autowired
    protected PluginsPage pluginsPage;

    @BeforeSuite(alwaysRun = true)
    public void setup(ITestContext testContext) throws Exception {
        this.springTestContextPrepareTestInstance();
        testContext.setAttribute("WebDriver", this.driver);
        driver.manage().window().maximize();
    }

    @AfterSuite(alwaysRun = true)
    public void cleanUp() {
        driver.close();
        driver.quit();
    }
}
