package com.automation.bitrix24.tests.activityStream;

import com.automation.bitrix24.pages.LoginPage;
import com.automation.bitrix24.pages.activityStream.PollTab;
import com.automation.bitrix24.tests.AbstractTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PollTabTests extends AbstractTestBase {

    //peer review :
    //you have clean code which is great
    //but test is failed when I run, did not click the link icon
    // it has issue with the locator => pollTab.clickOnLinkIcon();
    //you can try to add wait on page class or you can check the locator :)


    /**
     * US 4. As a user, I should be able to create a
     * poll by clicking on Poll tab under Active Stream.
     */


    // AC 3. User should be able to attach link by clicking on the link icon.
    @Test
    public void attachLink() {

        test = report.createTest("Attach link by clicking on the link icon");

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsMarketing();

        PollTab pollTab = new PollTab();
        pollTab.navigateTo("Poll");

        pollTab.clickOnLinkIcon();

        String actual = pollTab.getPopupWindowHeader();
        String expected = "Link";
        Assert.assertEquals(expected, actual);

        pollTab.fillInTheFields();
        pollTab.clickOnSaveButton();

        pollTab.verifyIfLinkWasAttached();

        test.pass("Link was attached.");

    }

}