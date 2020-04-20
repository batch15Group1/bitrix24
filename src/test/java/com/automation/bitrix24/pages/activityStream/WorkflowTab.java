package com.automation.bitrix24.pages.activityStream;

import com.automation.bitrix24.pages.AbstractPageBase;
import com.automation.bitrix24.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WorkflowTab extends AbstractPageBase {

    //Since we have wait object in PageBase class, we do not need to create it again here.
//    protected WebDriverWait wait = new WebDriverWait(driver, 20);

    @FindBy(xpath = "//*[@type='text' and @name='NAME']")
    private WebElement gRequestsTitleTextBox;

    @FindBy(css = "[name='PREVIEW_TEXT']")
    private WebElement gRequestsDescriptionTextBox;

    @FindBy(xpath = "//select[@name='PROPERTY_84']")
    private WebElement gRequestsPriorityLevel;

    @FindBy(xpath = "//option[@value='83']/preceding-sibling::option")
    private WebElement gRequestsPriorityLevelNotSet;

    @FindBy(xpath = "//option[@value='83']")
    private WebElement gRequestsPriorityLevelLow;

    @FindBy(xpath = "//option[@value='84']")
    private WebElement gRequestsPriorityLevelMedium;

    @FindBy(xpath = "//option[@value='85']")
    private WebElement gRequestsPriorityLevelHigh;

    @FindBy(css = "[style='width:35px;font-size:14px;border:1px #c8c8c8 solid;']")
    private WebElement gRequestsSendRequestTo;

    @FindBy(css = "//*[text()='Select']")
    private WebElement gRequestsSelect;

    @FindBy(css = "[id='blog-submit-button-save']")
    private WebElement gRequestsSend;

    @FindBy(css = "[id='blog-submit-button-cancel']")
    private WebElement gRequestsCancel;

    /**
     * choose submodules of Workflow:
     * Leave Approval, Business Trip, General Requests,
     * Purchase Request, Expense Report,
     * Workflows Directory, Settings
     */
    public void workflowNavigation(String subModules) {
        navigateTo("Workflow");
        BrowserUtils.waitForPageToLoad(10);
        String xpath = "//*[@class='menu-popup-item-text' and text()='" + subModules + "']";
        driver.findElement(By.xpath(xpath)).click();
    }

    /**
     * entering text method
     * choose where to enter the text
     * fill the text
     *
     * @param where
     * @param text
     */
    public void enterText(String where, String text) {
        BrowserUtils.waitForPageToLoad(10);
        switch (where.toLowerCase()) {
            case "title":
                gRequestsTitleTextBox.sendKeys(text);
                break;
            case "description":
                gRequestsDescriptionTextBox.sendKeys(text);
                break;
            case "send request to":
                gRequestsSendRequestTo.sendKeys(text);
                break;
            default:
                throw new RuntimeException("couldn't find where to enter text");
        }
    }

    /**
     * choose priority level
     * Low, Medium, High, (not set)
     */
    public void priorityLevel(String priorityLevel) {
        BrowserUtils.waitForPageToLoad(10);
//        Select pLevel = new Select(gRequestsPriorityLevel);
//        pLevel.selectByVisibleText( priorityLevel.trim().toLowerCase() );
        switch (priorityLevel.toLowerCase().trim()) {
            case "(not set)":
                gRequestsPriorityLevelNotSet.click();
                break;
            case "low":
                gRequestsPriorityLevelLow.click();
                break;
            case "medium":
                gRequestsPriorityLevelMedium.click();
                break;
            case "high":
                gRequestsPriorityLevelHigh.click();
                break;
            default:
                throw new RuntimeException("no such level");
        }
    }

    /**
     * click on send or cancel
     */
    public void sendOrCancel(String sendOrCancel) {
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.scrollTo(gRequestsCancel);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        if (sendOrCancel.trim().equalsIgnoreCase("send")) gRequestsSend.click();
        else if (sendOrCancel.trim().equalsIgnoreCase("cancel")) gRequestsCancel.click();
        else throw new RuntimeException("no such button");
    }

//  Common practice is not using explicit and implicit wait in same method. Choosing one of them is preferable.
    /**
     * implicit wait added after clicking on "More" module
     */
    @Override
    public void navigateTo(String tabName) {
        BrowserUtils.waitForPageToLoad(10);
        String tabNameXpath = "//span[contains(@class,'feed-add-post-form-')]/span[text()='" + tabName + "']";
        if (tabName.equals("File") || tabName.equals("Appreciation") || tabName.equals("Announcement") || tabName.equals("Workflow")) {
            WebElement moreTab = driver.findElement(By.cssSelector("[id=\"feed-add-post-form-link-more\"]"));
            wait.until(ExpectedConditions.elementToBeClickable(moreTab)).click();
        }
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement tabElement = driver.findElement(By.xpath(tabNameXpath));
        wait.until(ExpectedConditions.elementToBeClickable(tabElement)).click();
    }
}
