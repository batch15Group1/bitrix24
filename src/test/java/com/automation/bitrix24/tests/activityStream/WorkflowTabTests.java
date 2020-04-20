package com.automation.bitrix24.tests.activityStream;

import com.automation.bitrix24.pages.LoginPage;
import com.automation.bitrix24.pages.activityStream.WorkflowTab;
import com.automation.bitrix24.tests.AbstractTestBase;
import com.automation.bitrix24.utilities.BrowserUtils;
import com.automation.bitrix24.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WorkflowTabTests extends AbstractTestBase {

    //peer review:
    //great working test, but have couple of issue as mention below :
    //This test page is just for run test method. So we must not use driver.findElement method in this page
    //we need to find locators in page class.
    //Additionally; we use all wait on page class.

    protected WebDriver driver = Driver.getDriver();
//    protected WebDriverWait wait = new WebDriverWait(driver, 20);

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
        //       driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        workflowTab.enterText("title", "mayor of the corner office");
        //       driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        workflowTab.enterText("description", "I am sending this request regarding asdasdasd asdasdasd asdasdasd");
        //      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        workflowTab.priorityLevel("Low");
        //      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        workflowTab.enterText("send request to", "491");
        //       driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        workflowTab.sendOrCancel("send");

        BrowserUtils.wait(4);
        Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Send message …']")).getText(), "Send message …");
    }
}
