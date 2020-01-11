package com.splice.example.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

@Epic("QA automation task")
@Feature("Plugins | Sidebar | Purchase Type: Available Plugins for Rent-To-Own/Sale")
public class PluginsTest extends BaseTest {

    @DisplayName("Positive test: Check available plugins for Rent-To-Own")
    @Test(groups = "regression")
    public void availablePluginsForRentTest() {
        String purchaseType = "Rent-to-Own";
        homePage.openPage().verifyHomePageOpened()
                .openPluginsFromHeaderNavMenu("Plugins")
                .verifyCommunityPageOpened()
                .selectFromSidebar(purchaseType)
                .verifyRentToOwnOpened(purchaseType)
                .verifyPluginsResultAsExpected();
    }
}