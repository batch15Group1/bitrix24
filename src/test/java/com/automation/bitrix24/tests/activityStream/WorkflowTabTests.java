package com.automation.bitrix24.tests.activityStream;

import com.automation.bitrix24.pages.LoginPage;
import com.automation.bitrix24.pages.activityStream.WorkflowTab;
import com.automation.bitrix24.tests.AbstractTestBase;
import com.automation.bitrix24.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class WorkflowTabTests extends AbstractTestBase {

    protected WebDriver driver = Driver.getDriver();




    /**
     * US8_AC2
     * under Business Trip
     * send a Business Trip request
     * after sending approval message
     * to selected people
     */
    @Test()
    public void upload(){
        LoginPage loginPage = new LoginPage();
        WorkflowTab workflowTab = new WorkflowTab();

        loginPage.loginAsHelpDesk();
        workflowTab.workflowNavigation("Business Trip");

        workflowTab.bTripEnterTitle("help desk");
        workflowTab.bTripEnterDestination("Boston");
        workflowTab.bTripEnterDate("04/25/2020","04/29/2020");
        workflowTab.bTripEnterPurpose("business trip");
        workflowTab.bTripEnterExpenses("1231");
        workflowTab.bTripSelectCurrency("USD");
        workflowTab.bTripAttachDocs();
        workflowTab.assignApprovers("Support");
        workflowTab.sendOrCancel("send");

        workflowTab.verifyBusinessTrip(); // workflow parameters needs to be configured (BUG?)
    }

    /**
     * US8_AC3
     * under General Requests
     * send any type of request
     * to the employee that you indicate
     */
    @Test()
    public void sendRequest() {
        LoginPage loginPage = new LoginPage();
        WorkflowTab workflowTab = new WorkflowTab();

        loginPage.loginAsHelpDesk();
        workflowTab.workflowNavigation("General Requests");
        workflowTab.enterText("title", "mayor of the corner office");
        workflowTab.enterText("description", "I am sending this request regarding asdasdasd asdasdasd asdasdasd");
        workflowTab.priorityLevel("Low");
        workflowTab.enterText("send request to", "491");
        workflowTab.sendOrCancel("send");

        workflowTab.verifyRequestSent();
    }

}
