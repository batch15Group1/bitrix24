package com.automation.bitrix24.tests.activityStream;

import com.automation.bitrix24.pages.LoginPage;
import com.automation.bitrix24.pages.activityStream.DesktopClient;
import com.automation.bitrix24.tests.AbstractTestBase;
import com.automation.bitrix24.utilities.BrowserUtils;
import com.automation.bitrix24.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DesktopClientTests extends AbstractTestBase {
    /**
     *  As a PC user, I should be able to download ,Desktop version of the application."
     *  1. User should be able to click on Mac Os icon under Desktop Client to downloan Mac version of Bitrix.
     * 2. User should be able to click on Windows icon under Desktop Client to downloan Windows version of Bitrix.
     * 3. User should be able to click on Linux icon under Desktop Client to downloan Linux version of Bitrix.
     */


    private WebDriver driver;

    @Test
    public void clientDownload_DesktopVersion(){
        test=report.createTest("Mac user Should be able to download desktop version of the Application Btrix24");
        LoginPage loginPage =new LoginPage();
        loginPage.loginAsMarketing();
        test.info("User login");
        DesktopClient desktopClient = new DesktopClient();
        desktopClient.ChooseTheIconclickAndDownload("linuxIcon");
        BrowserUtils.wait(10);
        String expected = "GitHub - buglloc/brick: An open source Bitrix24 messenger client.";
        List<String> tabs = new ArrayList<>(Driver.getDriver().getWindowHandles());
        String actual = Driver.getDriver().switchTo().window(tabs.get(1)).getTitle();
        Assert.assertEquals(actual, expected);
        test.pass("user successfully Downloadad to Desktop version of the Application on your computer");

    }
}
