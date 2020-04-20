package com.automation.bitrix24.tests.activityStream;

import com.automation.bitrix24.pages.LoginPage;
import com.automation.bitrix24.pages.activityStream.EventTab;
import com.automation.bitrix24.tests.AbstractTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EventTabTests extends AbstractTestBase {

    @Test(description = "User should be able to click on upload files icon to upload files and pictures from local disks")
    public void verifyUploadFromLocal() {

        test = report.createTest("Verify upload file from local disk");

        LoginPage loginPage = new LoginPage();
        EventTab eventTab = new EventTab();
        loginPage.loginAsHr();

        test.info("Login as HR");
        eventTab.navigateTo("Event");
        eventTab.clickUploadFilesIcon();
        eventTab.uploadFilesFromLocal();
        Assert.assertTrue(eventTab.getAttachedFiles().isDisplayed());

        test.pass("Upload file from local disk is verified");
    }

    @Test(description = "User should be able to click select documents from Btrix24")
    public void verifySelectDocumentFromBtrix24() {

        test = report.createTest("Verify select documents from Btrix24");

        LoginPage loginPage = new LoginPage();
        EventTab eventTab = new EventTab();
        loginPage.loginAsHr();

        test.info("Login as HR");
        eventTab.navigateTo("Event");
        eventTab.clickUploadFilesIcon();
        eventTab.selectDocumentsFromBtrix24();
        Assert.assertTrue(eventTab.getAttachedFiles().isDisplayed());

        test.pass("select documents from Btrix24 is verified");
    }
    ///
}
