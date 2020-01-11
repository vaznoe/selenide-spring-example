package com.splice.example.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.apache.commons.lang3.RandomUtils;
import org.testng.annotations.Test;

@Epic("QA automation task")
@Feature("Community | Sidebar | Contest: Past Context")
public class PastContestTest extends BaseTest {

    @Test(groups = "regression")
    public void payMusicCardTest()  {
        int index = RandomUtils.nextInt(0, 14);
        homePage.openPage().verifyHomePageOpened()
                .openFromHeaderNavMenu("Community")
                .verifyCommunityPageOpened()
                .selectRandomMusicCard(index)
                .verifyMusicIsPlaying()
                .clickPauseMusicButton()
                .verifyMusicIsNotPlaying()
                .clickPlayMusicButton(index)
                .verifyMusicIsPlaying()
                .clickPauseMusicButton();
    }
}