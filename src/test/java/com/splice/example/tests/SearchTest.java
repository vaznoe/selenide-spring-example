package com.splice.example.tests;

import org.testng.annotations.Test;

import static com.splice.example.utils.TestUtils.randomMusicStyle;

public class SearchTest extends BaseTest {

    @Test(groups = "regression")
    public void searchSongTest() {
        String musicStyle = randomMusicStyle();
        homePage.openPage().verifyHomePageOpened()
                .openFromHeaderNavMenu("Community")
                .verifyCommunityPageOpened()
                .clickExploreFromSidebarListMenu("Explore")
                .findSongBy(musicStyle)
                .verifyResult(musicStyle);
    }
}