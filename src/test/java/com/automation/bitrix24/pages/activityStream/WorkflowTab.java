package com.automation.bitrix24.pages.activityStream;

import com.automation.bitrix24.pages.AbstractPageBase;
import com.automation.bitrix24.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WorkflowTab extends AbstractPageBase {

    @FindBy(css = "[id='blog-submit-button-save']")
    private WebElement send;

    @FindBy(css = "[id='blog-submit-button-cancel']")
    private WebElement cancel;

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

    @FindBy(xpath = "//button[@class='ui-btn ui-btn-lg ui-btn-primary' and text()='Send']")
    private WebElement gRequestsSend2;

    @FindBy(css = "[class='feed-add-post-micro-title']")
    private WebElement messagePlaceHolder;
///////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FindBy(css = "[class='bx-lists-input-calendar']")
    private WebElement lApprovalBothDates;

    @FindBy(css = "[name='PROPERTY_88']")
    private WebElement lApprovalAbsenceType;

    @FindBy(css = "[name='PREVIEW_TEXT']")
    private WebElement lApprovalReasonForLeave;
////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FindBy(xpath = "//input[@type='text' and @name='NAME']")
    private WebElement bTripTitle;

    @FindBy(xpath = "//input[@type='text' and @name='PROPERTY_70[n0][VALUE]']")
    private WebElement bTripDestination;

    @FindBy(css = "[class='bx-lists-input-calendar']")
    private WebElement bTripBothDates;

    @FindBy(css = "[name='PREVIEW_TEXT']")
    private WebElement bTripPurpose;

    @FindBy(css = "[name='PROPERTY_73[n0][VALUE]']")
    private WebElement bTripExpenses;

    @FindBy(css = "[name='PROPERTY_74']")
    private WebElement bTripCurrency;

    @FindBy(css = "[name='PROPERTY_78[n0][VALUE]']")
    private WebElement bTripAttDocs;
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FindBy(xpath = "//input[@type='text' and @name='NAME']")
    private WebElement pRequestTitle;

    @FindBy(css = "[name='PROPERTY_90[n0][VALUE]']")
    private WebElement pRequestAmount;

    @FindBy(css = "[name='PROPERTY_91']")
    private WebElement pRequestCurrency;

    @FindBy(css = "[name='PROPERTY_92[n0][VALUE]']")
    private WebElement pRequestFile;
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FindBy(xpath = "//input[@type='text' and @name='NAME']")
    private WebElement eReportTitle;

    @FindBy(css = "[name='PROPERTY_79[n0][VALUE]']")
    private WebElement eReportDescription;

    @FindBy(css = "[name='PROPERTY_80[n0][VALUE]']")
    private WebElement eReportAmount;

    @FindBy(css = "[name='PROPERTY_81']")
    private WebElement eReportCurrency;

    @FindBy(css = "[name='PROPERTY_82']")
    private WebElement eReportDocsAndReceipts;




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
        BrowserUtils.scrollTo(cancel);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        if (sendOrCancel.trim().equalsIgnoreCase("send")) send.click();
        else if (sendOrCancel.trim().equalsIgnoreCase("cancel")) cancel.click();
        else throw new RuntimeException("no such button");
        BrowserUtils.wait(4);
    }

//  Common practice is not using explicit and implicit wait in same method. Choosing one of them is preferable.
    /**
     * implicit wait added after clicking on "More" module
     */
    @Override
    public void navigateTo(String tabName) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String tabNameXpath = "//span[contains(@class,'feed-add-post-form-')]/span[text()='" + tabName + "']";
        if (tabName.equals("File") || tabName.equals("Appreciation") || tabName.equals("Announcement") || tabName.equals("Workflow")) {
            WebElement moreTab = driver.findElement(By.cssSelector("[id=\"feed-add-post-form-link-more\"]"));
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            moreTab.click();
        }
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement tabElement = driver.findElement(By.xpath(tabNameXpath));
        wait.until(ExpectedConditions.elementToBeClickable(tabElement)).click();
    }

    public void verifyRequestSent(){
        Assert.assertEquals(messagePlaceHolder.getText(), "Send message …");
    }

//////////////////////////////////////////////////////////////////////////////////////////////////

    public void lEnterDate(String start, String end){
        List<WebElement> bothDates = (List<WebElement>) lApprovalBothDates;
        bothDates.get(0).sendKeys(start);
        bothDates.get(1).click();
        bothDates.get(1).sendKeys(end);
    }

    public void lSelectAbsenceType(String type){
        int index;
        switch (type.trim().toLowerCase()){
            case "(not set)":
                index=0;
                break;
            case "absent without reason or official leave":
                index=1;
            case "annual leave":
                index=2;
                break;
            case "business trip":
                index=3;
                break;
            case "maternity leave":
                index=4;
                break;
            case "sick leave":
                index=5;
                break;
            case "unpaid leave":
                index = 6;
                break;
            case "personal calendars":
                index = 7;
                break;
            case "other":
                index = 8;
                break;
            default:
                throw new RuntimeException("no such absence type");
        }

        Select absenceType = new Select(lApprovalAbsenceType);
        absenceType.selectByIndex(index);
    }

    public void lApprovalEnterReasonForLeave(String reason){
        lApprovalReasonForLeave.sendKeys(reason);
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void bTripEnterTitle(String title){
        bTripTitle.sendKeys(title);
    }

    public void bTripEnterDestination(String destination){
        bTripDestination.sendKeys(destination);
    }

    public void bTripEnterDate(String start, String end){
        List<WebElement> bothDates = (List<WebElement>) bTripBothDates;
        bothDates.get(0).sendKeys(start);
        bothDates.get(1).click();
        bothDates.get(1).sendKeys(end);
    }

    public void bTripEnterPurpose(String purpose){
        bTripPurpose.sendKeys(purpose);
    }

    public void bTripEnterExpenses(String expense){
        for (char c: expense.toCharArray()){
            if (Character.isDigit(c)) throw new RuntimeException("Please enter only numbers");
        }
        bTripExpenses.sendKeys(expense);
    }

    public void bTripSelectCurrency(String currency){
        int index;
        switch (currency.trim().toUpperCase()){
            case "(not set)":
                index=0;
                break;
            case "USD":
                index=1;
            case "EUR":
                index=2;
                break;
            case "GBP":
                index=3;
                break;
            case "CNY":
                index=4;
                break;
            case "JPY":
                index=5;
                break;
            case "BRL":
                index = 6;
                break;
            case "CAD":
                index = 7;
                break;
            case "PLN":
                index = 8;
                break;
            case "INR":
                index = 9;
                break;
            case "AUD":
                index = 10;
                break;
            default:
                throw new RuntimeException("no such absence type");
        }

        Select currencyType = new Select(bTripCurrency);
        currencyType.selectByIndex(index);
    }

    /***/
    public void bTripAttachDocs(){
//        bTripAttDocs
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void pRequestEnterTitle(String title){
        pRequestTitle.sendKeys(title);
    }

    public void pRequestEnterAmount(String amount){
        for (char c: amount.toCharArray()){
            if (Character.isDigit(c)) throw new RuntimeException("Please enter only numbers");
        }
        pRequestAmount.sendKeys(amount);
    }

    public void pRequestSelectCurrency(String currency){
        int index;
        switch (currency.trim().toUpperCase()){
            case "(not set)":
                index=0;
                break;
            case "USD":
                index=1;
            case "EUR":
                index=2;
                break;
            case "GBP":
                index=3;
                break;
            case "CNY":
                index=4;
                break;
            case "JPY":
                index=5;
                break;
            case "BRL":
                index = 6;
                break;
            case "CAD":
                index = 7;
                break;
            case "PLN":
                index = 8;
                break;
            case "INR":
                index = 9;
                break;
            case "AUD":
                index = 10;
                break;
            default:
                throw new RuntimeException("no such absence type");
        }

        Select currencyType = new Select(pRequestCurrency);
        currencyType.selectByIndex(index);
    }

    /***/
    public void pRequestAddFile(){
//        pRequestFile
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void eReportEnterTitle(String title){
        eReportTitle.sendKeys(title);
    }

    public void eReportEnterDescription(String description){
        eReportDescription.sendKeys(description);
    }

    public void eReportEnterAmount(String amount){
        for (char c: amount.toCharArray()){
            if (Character.isDigit(c)) throw new RuntimeException("Please enter only numbers");
        }
        eReportAmount.sendKeys(amount);
    }

    public void eReportSelectCurrency(String currency){
        int index;
        switch (currency.trim().toUpperCase()){
            case "(not set)":
                index=0;
                break;
            case "USD":
                index=1;
            case "EUR":
                index=2;
                break;
            case "GBP":
                index=3;
                break;
            case "CNY":
                index=4;
                break;
            case "JPY":
                index=5;
                break;
            case "BRL":
                index = 6;
                break;
            case "CAD":
                index = 7;
                break;
            case "PLN":
                index = 8;
                break;
            case "INR":
                index = 9;
                break;
            case "AUD":
                index = 10;
                break;
            default:
                throw new RuntimeException("no such absence type");
        }

        Select currencyType = new Select(eReportCurrency);
        currencyType.selectByIndex(index);
    }

    /***/
    public void eReportAddDocs(){
//        eReportDocsAndReceipts
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////

}
