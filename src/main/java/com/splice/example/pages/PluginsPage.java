package com.splice.example.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.splice.example.utils.TestUtils.waitTimeout;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;

public class PluginsPage extends BasePage {

    protected static final By PLUGINS_PAGE_TITLE = By.cssSelector(".subnav__page-title");
    protected static final By PLUGINS_SIDEBAR_LINKS = By.cssSelector(".global-sidebar.studio-sidebar a");
    protected static final By PLUGINS_SECTION_HEADER = By.cssSelector(".plugins-section-header h1");
    protected static final By PLUGINS_SECTION_RESULT = By.cssSelector(".plugins-section-header h2");
    protected static final By PLUGINS_CONTAINER = By.cssSelector(".m-plugin-card.sds-container");

    @Override
    public PluginsPage openPage() {
        open(property.getBaseUrl());
        return new PluginsPage();
    }

    @Step("Verify Plugins page is opened")
    public PluginsPage verifyCommunityPageOpened() {
        Wait().withTimeout(2, SECONDS);
        $(PLUGINS_PAGE_TITLE).isDisplayed();
        return new PluginsPage();
    }

    @Step("Select from Plugin sidebar: {linkValue}")
    public PluginsPage selectFromSidebar(String linkValue) {
        $$(PLUGINS_SIDEBAR_LINKS).filterBy(Condition.text(linkValue)).first().click();
        return this;
    }

    @Step("Verify Rent-to-Own opened")
    public PluginsPage verifyRentToOwnOpened(String linkValue) {
        Wait().withTimeout(2, SECONDS);
        assertThat($(PLUGINS_SECTION_HEADER).getText()).isEqualToIgnoringCase(linkValue);
        return this;
    }

    @Step("Verify Rent-to-Own plugins result value")
    public PluginsPage verifyPluginsResultAsExpected() {
        waitTimeout(2);
        String[] resultValues = $(PLUGINS_SECTION_RESULT).getText().split(" ");
        assertThat(Integer.valueOf(resultValues[0])).isEqualTo($$(PLUGINS_CONTAINER).size());
        return this;
    }
}
