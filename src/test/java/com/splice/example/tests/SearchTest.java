package com.splice.example.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import static com.splice.example.utils.TestUtils.randomMusicStyle;

@Epic("QA automation task")
@Feature("Community | Sidebar | Explore: Search on Splice by keywords")
public class SearchTest extends BaseTest {

    @DisplayName("Positive test: Search songs by keyword")
    @Test(groups = "regression")
    public void searchSongByKeywordTest() {
        String musicStyle = randomMusicStyle();
        homePage.openPage().verifyHomePageOpened()
                .openFromHeaderNavMenu("Community")
                .verifyCommunityPageOpened()
                .clickExploreFromSidebarListMenu("Explore")
                .findSongBy(musicStyle)
                .verifyResult(musicStyle);
    }
}