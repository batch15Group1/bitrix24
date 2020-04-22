package com.automation.bitrix24.tests.activityStream;

import com.automation.bitrix24.pages.LoginPage;
import com.automation.bitrix24.pages.activityStream.PollTab;
import com.automation.bitrix24.tests.AbstractTestBase;
import com.automation.bitrix24.utilities.BrowserUtils;
import com.automation.bitrix24.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PollTabTests extends AbstractTestBase {

    //peer review :
    //you have clean code which is great
    //but test is failed when I run, did not click the link icon
    // it has issue with the locator => pollTab.clickOnLinkIcon();
    //you can try to add wait on page class or you can check the locator :)


    /**
     *  US 4. As a user, I should be able to create a
     *  poll by clicking on Poll tab under Active Stream.
     */


    // AC 3. User should be able to attach link by clicking on the link icon.

    @Test
    public void attachLink(){

        test = report.createTest("Attach link by clicking on the link icon");

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsMarketing();

        PollTab pollTab = new PollTab();
        pollTab.navigateTo("Poll");

        BrowserUtils.wait(3);
        pollTab.clickOnLinkIcon();

        String actual = pollTab.getPopupWindowHeader();
        String expected = "Link";
        Assert.assertEquals(expected, actual);

        pollTab.fillInTheFields();
        pollTab.clickOnSaveButton();

        pollTab.switchToIFrame();
        Assert.assertTrue(pollTab.returnText().isDisplayed());
        pollTab.exitFromIFrame();

        test.pass("Link was attached.");

    }


    // 5. User should be able to create a quote by clicking on the Comma icon.

    @Test
    public void createAQuote(){

        test = report.createTest("Create a quote.");

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsMarketing();

        PollTab pollTab = new PollTab();
        pollTab.navigateTo("Poll");

        pollTab.sendQuote();
        String expected = "Everyone's journey is different.";
        String actual = pollTab.getPostedQuote().getText();
        Assert.assertEquals(expected, actual);

        test.pass("Quote posted.");
    }


    // 6. User should be able to add mention by clicking on the Add mention icon and select contacts from the lists provided in dropdown.

    @Test
    public void mentionContuct(){

        test = report.createTest("Mention contacts by clicking on the Add mention icon");

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsHr();

        PollTab pollTab = new PollTab();
        pollTab.navigateTo("Poll");

        pollTab.selectContuctFromTheList();
        Assert.assertTrue(pollTab.getMentionedContact().isDisplayed());

        test.pass("User able to mention contact");
    }



}