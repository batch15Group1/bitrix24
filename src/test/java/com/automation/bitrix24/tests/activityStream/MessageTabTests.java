package com.automation.bitrix24.tests.activityStream;

import com.automation.bitrix24.pages.LoginPage;
import com.automation.bitrix24.pages.activityStream.MessageTabPage;
import com.automation.bitrix24.tests.AbstractTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MessageTabTests extends AbstractTestBase {

    //peer review :
    //Nice and clean codes, proud of you.
    //Just FYI >> When you have more than one test in same class, if you have any issue
    // you may need to create page class object in every test method

    MessageTabPage messageTabPage = new MessageTabPage();

    @Test
    public void enterQuote() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsHelpDesk();
        messageTabPage.clickMessage();
        messageTabPage.clickQuoteIcon();
        String expected = "new quote";
        String actual = messageTabPage.getQuoteInputText("new quote");
        Assert.assertEquals(actual, expected);
    }
}
