package com.automation.bitrix24.pages.activityStream;


import com.automation.bitrix24.pages.AbstractPageBase;
import com.automation.bitrix24.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class EventTab extends AbstractPageBase {

    /**
     * USER STORY :
     * "3. As a user, I should be able to create events by clicking on Event tab under Activity Stream."
     * AC'S:
     * 1. User should be able to click on upload files icon to upload files and pictures from local disks,
     * download from external drive, select documents from btrix24, and create files to upload.
     * 2. User should be able to attach link by clicking on the link icon.
     * 3. User should be able to insert videos by clicking on the video icon and entering the video URL.
     * 4. User should be able to create a quote by clicking on the Comma icon.
     * 5. User should be able to click on Visual Editor and see the editor text-bar displays on top of the message box.
     * 6. User should be able to add Event start and ending date and time, and specify the time zone.
     * 7. User should be able to set reminder by entering the timeing.
     * 8. User should be able to select event location from dropdown.
     * 9.User should be able to add attendees by selecting contacts individually or adding groups and departments.
     * 10.User should be able to click on More to specify the event details.
     */
    
    //upload files
    @FindBy(id = "bx-b-uploadfile-blogPostForm_calendar")
    private WebElement uploadFilesIcon;

    @FindBy(css = "[name=\"bxu_files[]\"]")
    private WebElement uploadFilesAndImages;

    @FindBy(id = "blog-submit-button-save")
    private WebElement sendBtn;

    @FindBy(css = "[class=\"insert-btn\"]")
    private WebElement insertInText;

    @FindBy(css = "[title=\"Click to insert file\"]")
    private WebElement attachedFiles;

    @FindBy(xpath = "//input[@name=\"UF_WEBDAV_CAL_EVENT[]\"]/../table//span[text()=\"Select document from Bitrix24\"]")
    private WebElement documentFromBtrix24;

    @FindBy(css = "[class=\"bx-file-dialog-content-wrap\"]>div")
    private List<WebElement> recentItemsList;

    @FindBy(css = "[class=\"popup-window-buttons\"]>span:nth-child(1)")
    private WebElement selectDocument;

    //attach link
    @FindBy(css = "[class=\"feed-event-inp feed-event-inp-active\"]")
    private WebElement eventName;

    @FindBy(xpath = "//*[@class=\"feed-event\"]//iframe")
    private WebElement iframeDescription;

    @FindBy(xpath = "//body[@contenteditable=\"true\" and @style]")
    private WebElement frameDescriptionText;

    @FindBy(css = "[id=\"bx-b-link-blogPostForm_calendar\"]>span")
    private WebElement attachLinkIcon;

    @FindBy(css = "[id=\"linkoCalEditorcal_3Jcl-text\"]")
    private WebElement linkTextInput;

    @FindBy(css = "[id=\"linkoCalEditorcal_3Jcl-href\"]")
    private WebElement linkUrlInput;

    @FindBy(css = "[value=\"Save\"]")
    private WebElement saveBtn;

    @FindBy(css = "[value=\"Cancel\"]")
    private WebElement cancelBtn;

    @FindBy(css = "span[title=\"Close\"]")
    private WebElement closeBtn;

    @FindBy(xpath = "(//div[@class=\"feed-cal-view-desc-title\"])[1]")
    private WebElement eventDescription;

    @FindBy(xpath = "(//a[starts-with(@id,\"feed-event-view-link-livefeed\")])[1]")
    private WebElement eventNameOnAS;

    @FindBy(xpath = "(//div[@class=\"feed-calendar-view-description\"])[1]")
    private WebElement eventDescriptionOnAS;

    @FindBy(xpath = "(//div[text()=\"Event description:\"]/../a)[1]")
    private WebElement linkUrlOnAS;

    //create quote
    @FindBy(css = "[id=\"bx-b-quote-blogPostForm_calendar\"]>span")
    private WebElement commaIcon;

    @FindBy(xpath = "//body[@contenteditable=\"true\" and @style]/blockquote")
    private WebElement quoteText;

    @FindBy(xpath = "(//table[@class=\"quote\"])[1]/tbody/tr/td")
    private WebElement quoteDescriptionOnAS;

    //visual editor text-bar
    @FindBy(xpath = "//div/span[@id=\"lhe_button_editor_blogPostForm_calendar\"]")
    private WebElement visualEditor;

    @FindBy(css = "[id=\"bx-html-editor-tlbr-cnt-oCalEditorcal_3Jcl\"]")
    private WebElement editorToolBar;


    // #US3_AC1
    public void clickUploadFilesIcon() {
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(uploadFilesIcon)).click();
    }

    public void uploadFilesFromLocal() {
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[name=\"bxu_files[]\"]")));
        //uploadFilesAndImages.sendKeys("/Users/sedacivan/Downloads/jdk-14.0.1_osx-x64_bin.dmg");
        uploadFilesAndImages.sendKeys(System.getProperty("user.dir") + "/pom.xml");
        wait.until(ExpectedConditions.visibilityOf(insertInText));
    }

    public WebElement getAttachedFiles() {
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[title=\"Click to insert file\"]")));
        return attachedFiles;
    }

    public void selectDocumentsFromBtrix24() {
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.
                presenceOfElementLocated(By.xpath("//input[@name=\"UF_WEBDAV_CAL_EVENT[]\"]/../table//span[text()=\"Select document from Bitrix24\"]"))).click();
        Random random = new Random();
        BrowserUtils.wait(2);
        int index = random.nextInt(recentItemsList.size());
        recentItemsList.get(index).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectDocument)).click();
    }

    // #US3_AC2
    public void setEventName(String event){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class=\"feed-event-inp feed-event-inp-active\"]"))).sendKeys(event);
        BrowserUtils.wait(4);
    }

    public void setIframeEventDescription(String description){
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(1);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeDescription));
        BrowserUtils.wait(3);
        frameDescriptionText.sendKeys(description,Keys.ENTER);
        driver.switchTo().defaultContent();
    }

    public void clickToAttachLink(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(attachLinkIcon)).click();
        BrowserUtils.wait(2);
    }

    public void setLinkText(String text){
        BrowserUtils.waitForPageToLoad(10);
        linkTextInput.sendKeys(text);
    }

    public void setLinkUrl(String url){
        BrowserUtils.wait(3);
        linkUrlInput.sendKeys(url);
    }

    public void clickToSave(){
        saveBtn.click();
    }

    public void clickToSend(){
        BrowserUtils.wait(2);
        wait.until(ExpectedConditions.elementToBeClickable(sendBtn)).click();
        BrowserUtils.waitForPageToLoad(10);
    }

    //for assertions
    public String getEventNameOnAS(){
        return eventNameOnAS.getText().trim();
    }

    public String getEventDescriptionOnAS(){
        return eventDescriptionOnAS.getText();
    }

    public String getLinkUrlOnAS(){
        return linkUrlOnAS.getAttribute("href");
    }


    // #US3_AC4
    public void clickOnCommaIcon(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(commaIcon)).click();
    }

    public void setQuoteText(String text){
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(2);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeDescription));
        BrowserUtils.wait(2);
        quoteText.sendKeys(text);
        driver.switchTo().defaultContent();
    }

    public String getQuoteDescriptionOnAS(){
        BrowserUtils.wait(3);
        return quoteDescriptionOnAS.getText().trim();
    }

    // #US3_AC5
    public void clickOnVisualEditor(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(visualEditor)).click();
    }

    public WebElement getEditorToolBar(){
        return editorToolBar;
    }


}
