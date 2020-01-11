package com.splice.example.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.*;
import static java.util.concurrent.TimeUnit.SECONDS;

@Component
public class HomePage extends BasePage {

    private static final By HOME_PAGE = By.cssSelector(".main-container");
    private static final By HEADER_NAV_BUTTONS = By.cssSelector(".global-nav__main a");

    @Override
    public HomePage openPage() {
        open(property.getBaseUrl());
        return new HomePage();
    }

    @Step("Verify Home page opened")
    public HomePage verifyHomePageOpened() {
        Wait().withTimeout(2, SECONDS);
        $(HOME_PAGE).isDisplayed();
        return this;
    }

    @Step("Select {textValue} from Header nav menu")
    public PluginsPage openPluginsFromHeaderNavMenu(String textValue) {
        $$(HEADER_NAV_BUTTONS).filterBy(Condition.text(textValue)).first().click();
        return new PluginsPage();
    }

    @Step("Select {textValue} from Header nav menu")
    public CommunityPage openFromHeaderNavMenu(String textValue) {
        $$(HEADER_NAV_BUTTONS).filterBy(Condition.text(textValue)).first().click();
        return new CommunityPage();
    }
}