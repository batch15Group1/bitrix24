package com.automation.bitrix24.tests.activityStream;

import com.automation.bitrix24.pages.LoginPage;
import com.automation.bitrix24.pages.activityStream.EventTab;
import com.automation.bitrix24.tests.AbstractTestBase;
import static org.testng.Assert.*;
import com.automation.bitrix24.utilities.BrowserUtils;
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
        assertTrue(eventTab.getAttachedFiles().isDisplayed());

        test.pass("Upload file from local disk is verified");
    }


    @Test(description = "User should be able to click select documents from Btrix24")
    public void verifySelectDocumentFromBitrix24() {

        test = report.createTest("Verify select documents from Btrix24");

        LoginPage loginPage = new LoginPage();
        EventTab eventTab = new EventTab();
        loginPage.loginAsHr();

        test.info("Login as HR");
        eventTab.navigateTo("Event");
        eventTab.clickUploadFilesIcon();
        eventTab.selectDocumentsFromBtrix24();
        assertTrue(eventTab.getAttachedFiles().isDisplayed());

        test.pass("select documents from Btrix24 is verified");
    }


    @Test(description = "User should be able to attach link by clicking on the link icon")
    public void verifyAttachLink(){

        test = report.createTest("Verify attach link");

        LoginPage loginPage = new LoginPage();
        EventTab eventTab = new EventTab();
        loginPage.loginAsHr();

        test.info("Login as HR");
        eventTab.navigateTo("Event");

        eventTab.setEventName("Meeting with BA");
        eventTab.setIframeEventDescription("meeting link is attached");
        eventTab.clickToAttachLink();
        eventTab.setLinkText("Google");
        eventTab.setLinkUrl("www.google.com");
        eventTab.clickToSave();
        eventTab.clickToSend();

        assertEquals(eventTab.getEventNameOnAS(),"Meeting with BA" );
        System.out.println(eventTab.getEventDescriptionOnAS());
        assertTrue(eventTab.getEventDescriptionOnAS().contains("meeting link is attached"));
        assertTrue(eventTab.getEventDescriptionOnAS().contains("Google"));
        assertTrue(eventTab.getLinkUrlOnAS().contains("www.google.com"));
        BrowserUtils.wait(2);
        test.pass("attaching link to given event name and description is verified!");
    }

    @Test(description = "User should be able to create a quote by clicking on the Comma icon")
    public void verifyCreatingQuote() {

        test = report.createTest("Verify create quote");

        LoginPage loginPage = new LoginPage();
        EventTab eventTab = new EventTab();
        loginPage.loginAsHr();

        test.info("Login as HR");
        eventTab.navigateTo("Event");
        eventTab.clickOnCommaIcon();
        eventTab.setQuoteText("new quote created");
        eventTab.clickToSend();

        assertTrue(eventTab.getQuoteDescriptionOnAS().equals("new quote created"));
        test.pass("creating a quote by clicking on the Comma icon is verified");
    }


    @Test(description = "User should be able to click on Visual Editor and see the editor " +
                        "text-bar displays on top of the message box")
    public void verifyEditorTextBarIsDisplayed() {

        test = report.createTest("Verify editor text-bar");

        LoginPage loginPage = new LoginPage();
        EventTab eventTab = new EventTab();
        loginPage.loginAsHr();

        test.info("Login as HR");
        eventTab.navigateTo("Event");
        eventTab.clickOnVisualEditor();

        assertTrue(eventTab.getEditorToolBar().isDisplayed());

        test.pass("editor text-bar displays on top of the message box");

        //new line added
    }
}
