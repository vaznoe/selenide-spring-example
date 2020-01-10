package com.splice.example.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.splice.example.utils.TestUtils.waitTimeout;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;

@Component
public class CommunityPage extends BasePage {

    protected static final By COMMUNITY_PAGE_TITLE = By.cssSelector(".subnav__page-title");
    private static final By MUSIC_CARDS = By.cssSelector(".contest-card");
    private static final By MUSIC_PLAY = By.cssSelector(".fa.ng-isolate-scope.fa-play");
    private static final By PAUSE_MUSIC = By.cssSelector(".fa.ng-isolate-scope.fa-pause");
    private static final By COMMUNITY_SIDEBAR = By.cssSelector(".global-sidebar__section a");
    private static final By SEARCH = By.cssSelector(".search-form input");
    private static final By RELEASE_PLAYER = By.cssSelector(".m-release-players li");
    private static final By RELEASE_PLAYER_TITLE = By.cssSelector(".release-player-project-title.ng-binding");

    @Override
    public CommunityPage openPage() {
        open(property.getBaseUrl() + "/explore/contests");
        return new CommunityPage();
    }

    @Step("Verify Community page is opened")
    public CommunityPage verifyCommunityPageOpened() {
        Wait().withTimeout(2, SECONDS);
        $(COMMUNITY_PAGE_TITLE).isDisplayed();
        return this;
    }

    @Step("Select music card {index} from Header nav menu")
    public CommunityPage selectRandomMusicCard(int index) {
        $$(MUSIC_CARDS).get(index).hover().$(By.tagName("button")).click();
        return this;
    }

    @Step("Verify a music card is playing")
    public CommunityPage verifyMusicIsPlaying() {
        waitTimeout(4);
        $(PAUSE_MUSIC).isEnabled();
        return this;
    }

    @Step("Click pause music button")
    public CommunityPage clickPauseMusicButton() {
        $(PAUSE_MUSIC).hover().click();
        return this;
    }

    @Step("Verify a music card is Not playing")
    public CommunityPage verifyMusicIsNotPlaying() {
        $(PAUSE_MUSIC).is(not(visible));
        $(MUSIC_PLAY).isEnabled();
        return this;
    }

    @Step("Click play button")
    public CommunityPage clickPlayMusicButton(int index) {
        waitTimeout(2);
        $$(MUSIC_CARDS).get(index).hover().$(By.tagName("button")).click();
        return this;
    }

    @Step("Click {tabValue} from sidebar list menu")
    public CommunityPage clickExploreFromSidebarListMenu(String tabValue) {
        $$(COMMUNITY_SIDEBAR).filterBy(Condition.text(tabValue)).first().click();
        return this;
    }

    @Step("Enter: {musicStyle} into the search field and click enter")
    public CommunityPage findSongBy(String musicStyle) {
        $(SEARCH).setValue(musicStyle).pressEnter();
        return this;
    }

    @Step("Verify result: music track size is greater than 0 and the first song title contains {textValue}")
    public CommunityPage verifyResult(String textValue) {
        waitTimeout(2);
        assertThat($$(RELEASE_PLAYER).size()).isGreaterThan(0);
        assertThat($$(RELEASE_PLAYER_TITLE).first().getText()).containsIgnoringCase(textValue);
        return this;
    }
}
