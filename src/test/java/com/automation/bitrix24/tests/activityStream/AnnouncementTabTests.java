package com.automation.bitrix24.tests.activityStream;

import com.automation.bitrix24.pages.LoginPage;
import com.automation.bitrix24.pages.activityStream.AnnouncementTab;
import com.automation.bitrix24.tests.AbstractTestBase;
import com.automation.bitrix24.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AnnouncementTabTests extends AbstractTestBase {

    //peer review:
    //great working test method
    //only the point is; we need to find all elements in page class. And wrap that locators with methods
    //in this test class we use that methods, to verify our test.

    @Test
    public void uploadButtonsTest() throws InterruptedException {
        LoginPage login = new LoginPage();
        login.loginAsMarketing();
        AnnouncementTab announcement = new AnnouncementTab();
        announcement.navigateTo("Announcement");
        announcement.clickToUploadFilesButton();
        String actual = Driver.getDriver().findElement(
                By.xpath("(//td[@class='diskuf-selector wd-fa-add-file-light-cell wd-fa-add-file-from-main'])[1]")).getTagName();
        String expected = "td";
        Assert.assertEquals(actual, expected);
    }
}
