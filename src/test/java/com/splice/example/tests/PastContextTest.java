package com.splice.example.tests;

import org.apache.commons.lang3.RandomUtils;
import org.testng.annotations.Test;

public class PastContextTest extends BaseTest {

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