package com.automation.bitrix24.pages.activityStream;

import com.automation.bitrix24.pages.AbstractPageBase;
import com.automation.bitrix24.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Collections;
import java.util.List;

public class MessageTabPage extends AbstractPageBase {

    @FindBy(id = "feed-add-post-form-tab-message")
    private WebElement messageTabLink;

    @FindBy(css = "[id='bx-b-uploadfile-blogPostForm']")
    private WebElement uploadFileIcon;

    @FindBy(css = "span[title='Link']")
    private WebElement linkIcon;

    @FindBy(css = "[id='linkidPostFormLHE_blogPostForm-text']")
    private WebElement linkTextInput;

    @FindBy(css = "[id='linkidPostFormLHE_blogPostForm-href']")
    private WebElement linkURLInput;

    @FindBy(css = "input[value='Save']")
    private WebElement linkSaveBtn;

    @FindBy(css = "[class='bxhtmled-top-bar-btn bxhtmled-button-video bxhtmled-top-bar-btn-active']")
    private WebElement videoIcon;

    @FindBy(css = "[class^='bxhtmled-top-bar-btn bxhtmled-button-quote']")
    private WebElement quoteIcon;

    @FindBy(css = "[class='bxhtmled-quote']")
    private WebElement quoteInput;

    @FindBy(css = "[id='bx-b-mention-blogPostForm']")
    private WebElement mentionIcon;

    @FindBy(css = "[id='bx-b-tag-input-blogPostForm']")
    private WebElement tagIcon;

    @FindBy(css = "[id^='TAGS_blogPostForm']")
    private WebElement tagInput;

    @FindBy(css = "[class='feed-add-post-form-but-cnt feed-add-videomessage']")
    private WebElement recordVideoIcon;

    @FindBy(css = "[id='bx-destination-tag']")
    private WebElement toInputAddMore;

    @FindBy(css = "[id^='destLastTab_destination']")
    private WebElement toInputRecentLink;

    @FindBy(css = "[id^='destDepartmentTab_destination']")
    private WebElement toInputEmployeesAndDepartmentsLink;

    @FindBy(css = "[id^='destEmailTab_destination']")
    private WebElement toInputEmailUsersLink;

    @FindBy(css = "[id='lhe_button_editor_blogPostForm']")
    private WebElement visualEditorIcon;

    @FindBy(css = "[id='lhe_button_title_blogPostForm']")
    private WebElement topicIcon;

    @FindBy(css = "[id='POST_TITLE']")
    private WebElement topicTitleInput;

    @FindBy(css = "[class='wd-fa-add-file-light-title']")
    private WebElement uploadFilesAndImagesLink;

    @FindBy(css = "[class='wd-fa-add-file-light-title-text diskuf-selector-link']")
    private WebElement selectDocumentFromBitrix24;

    @FindBy(xpath = "//*[@id=diskuf-selectdialog-s3eFTzF]/div[2]/table/tbody/tr[3]/td[1]/span/span/span[1]/span")
    private WebElement downloadFromExternalDrive;

    @FindBy(xpath = "//*[@id=\"diskuf-selectdialog-s3eFTzF\"]/div[2]/table/tbody/tr[3]/td[3]/span/span/span[1]/span")
    private WebElement createUsingDesktopApplicationLink;

    @FindBy(css = "iframe[class='bx-editor-iframe']")
    private WebElement iframe;

    @FindBy(css = "a[href='www.google.com']")
    private WebElement linkInBody;


    @FindBy (xpath = "//*[@id='feed-add-post-destination-item']/span[2]/span")
    private WebElement addedToInput;

    public String  getAddedToInputText(){
        return wait.until(ExpectedConditions.visibilityOf(addedToInput)).getText();
    }

    public String getPeopleWithNumText(int num){
        List<WebElement> peopleList=driver.findElements(By.cssSelector("[class='bx-finder-box-item-t7-name']"));
        if(num<=peopleList.size()){
           return peopleList.get(num).getText();
        }else{
          return  null;
        }
    }
    public void clickOnPeopleWithNum(int num){
        List<WebElement> peopleList=driver.findElements(By.cssSelector("[class='bx-finder-box-item-t7-name']"));
        if(num<=peopleList.size()){
             peopleList.get(num).click();
        }else{
            System.out.println("not in recent people list");
        }

    }

    public String getLinkInBodyText() {
        driver.switchTo().frame(iframe);
        return wait.until(ExpectedConditions.visibilityOf(linkInBody)).getText();
    }

    public void clickuploadFilesAndImagesLink() {
        wait.until(ExpectedConditions.visibilityOf(topicIcon)).click();
    }

    public String getQuoteInputText(String quote) {
        WebElement iframe = driver.findElement(By.className("bx-editor-iframe"));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOf(quoteInput)).sendKeys(quote);
        return quoteInput.getText();
    }

    public void enterTagInput(String tag) {
        wait.until(ExpectedConditions.visibilityOf(topicIcon)).sendKeys(tag);
    }

    public void enterTopicTitleInput(String title) {
        wait.until(ExpectedConditions.visibilityOf(topicIcon)).sendKeys(title);
    }

    public void clickTopicIcon() {
        wait.until(ExpectedConditions.visibilityOf(topicIcon)).click();
    }

    public void clickVisualEditorIcon() {
        wait.until(ExpectedConditions.visibilityOf(visualEditorIcon)).click();
    }

    public void clickToInputAddMore() {
        wait.until(ExpectedConditions.visibilityOf(toInputAddMore)).click();
    }

    public void clickRecordVideoIcon() {
        wait.until(ExpectedConditions.visibilityOf(recordVideoIcon)).click();
    }

    public void clickTagIcon() {
        wait.until(ExpectedConditions.visibilityOf(tagIcon)).click();
    }

    public void clickMentionIcon() {
        wait.until(ExpectedConditions.visibilityOf(mentionIcon)).click();
    }

    public void clickQuoteIcon() {
        wait.until(ExpectedConditions.visibilityOf(quoteIcon)).click();
    }

    public void clickVideoIcon() {
        wait.until(ExpectedConditions.visibilityOf(videoIcon)).click();
    }

    public void clickLinkIcon() {
        wait.until(ExpectedConditions.visibilityOf(linkIcon)).click();
    }

    public void enterLinkTextInput(String linkText) {
        wait.until(ExpectedConditions.visibilityOf(linkTextInput)).sendKeys(linkText);
    }

    public void enterLinkURLInput(String linkURL) {
        wait.until(ExpectedConditions.visibilityOf(linkURLInput)).sendKeys(linkURL);
    }

    public void clickLinkSaveBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(linkSaveBtn)).click();
    }

    public void clickUploadFileIcon() {
        wait.until(ExpectedConditions.visibilityOf(uploadFileIcon)).click();
    }

    public void clickMessage() {
        wait.until(ExpectedConditions.elementToBeClickable(messageTabLink)).click();
    }

}
