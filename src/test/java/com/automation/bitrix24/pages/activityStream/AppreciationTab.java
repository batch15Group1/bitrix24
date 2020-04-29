package com.automation.bitrix24.pages.activityStream;


import com.automation.bitrix24.pages.AbstractPageBase;
import com.automation.bitrix24.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AppreciationTab extends AbstractPageBase {

    Actions actions = new Actions(driver);

    // Button used to add items from internal, external, select document from Bitrix etc.
    @FindBy(css = "#bx-b-uploadfile-blogPostForm")
    private WebElement uploadButtonforFile;

    // Button used to upload files from the local disk
    @FindBy(xpath = "(//td[@class='diskuf-selector wd-fa-add-file-light-cell wd-fa-add-file-from-main'])[1]")
    private WebElement dragFileToUploadButton;

    // Button to add the picture uploaded from local disk to the text
    @FindBy(css = ".insert-btn-text")
    private WebElement insertinTextButton;

    // Button to select documents from Bitrix 24
    @FindBy(xpath = "(//span[text()='Select document from Bitrix24'])[1]")
    private WebElement availableLibrariesButton;

    // Button to upload files from external drive (Google driver, dropbox, etc.)
    @FindBy(xpath = "(//span[text()='Download from external drive'])[1]")
    private WebElement downloadfromExternalDriveButton;

    // Button to create documents (excel, ppt, etc.) from desktop application
    @FindBy(xpath = "(//span[text()='Desktop applications'])[1]")
    private WebElement desktopApplicationButton;

    // Button to add employees as recipient
    @FindBy(css = "#bx-grat-tag")
    private WebElement addEmployeesButton;

    // This one can be used in the method to add different people into the 'To' section
    @FindBy(xpath = "//div[@class='bx-finder-company-department-employee-name' and text()='hr37@cybertekschool.com']")
    private WebElement employerEmailToadd;

    // Button to add link to the message
    @FindBy(css = ".bxhtmled-top-bar-btn.bxhtmled-button-link.bxhtmled-top-bar-btn-active > i")
    private WebElement linkButton;

    // Box to fill out as a title, or explanation for the link attached to the message - it comes after clicking linkButton
    @FindBy(css = "#linkidPostFormLHE_blogPostForm-text")
    private WebElement linkText;

    // Box to enter the URL of a link, attached to the message- it comes after clicking linkButton
    @FindBy(css = "#linkidPostFormLHE_blogPostForm-href")
    private WebElement linkUrl;

    // Button to save text and URL for the link
    @FindBy(xpath = "(//input[@id='undefined'])[1]")
    private WebElement saveButtonforLink;

    // Icon to click to add a video
    @FindBy(css = ".bxhtmled-top-bar-btn.bxhtmled-button-video.bxhtmled-top-bar-btn-active > i")
    private WebElement videoButton;

    // Box to fill out with the URL of the videp
    @FindBy(css = "#video_idPostFormLHE_blogPostForm-source")
    private WebElement videoBox;

    // Button to save the URL of the video
    @FindBy(xpath = "(//input[@id='undefined'])[1]")
    private WebElement saveButtonforVideo;

    // Button to add a quote the message
    @FindBy(xpath = "//span[@title='Quote text']")
    private WebElement quoteButton;

    // Box to fill out with the quote
    @FindBy(tagName = "blockquote")
    private WebElement texttoEnter;

    // Send the message with all attachments, links, etc.
    @FindBy(css = "#blog-submit-button-save")
    private WebElement sendButton;

    @FindBy(xpath = "(//a[@class='feed-post-user-name'])[1]")
    private WebElement mainPageLastMessageSender;

    @FindBy(css = ".bx-editor-iframe")
    private WebElement iframeforQuote;

    @FindBy(xpath = "//div//span[@id='bx-b-mention-blogPostForm']")
    private WebElement addMentionIcon;

    @FindBy(xpath = "//a[text()='Employees and departments']")
    private WebElement contactListButton;

    @FindBy(xpath = "//span[@data-id='U521']")
    private WebElement selectedContactName;
    //get text

    @FindBy(xpath = "(//div[@class='bx-finder-company-department-employee-info'])")
    private WebElement contactList;
//it is list.We need to put index number

    @FindBy(id = "lhe_button_editor_blogPostForm")
    private WebElement visualEditor;

    @FindBy(id = "lhe_button_title_blogPostForm")
    private WebElement topicIcon;

    @FindBy(className = "feed-add-post-tags")
    private WebElement tagList;

    @FindBy(id = "bx-b-tag-input-blogPostForm")
    private WebElement tagIcon;

    @FindBy(id = "TAGS_blogPostForm67abSn")
    private WebElement tagBox;
    //for write some #tag send keys

    @FindBy(className = "popup-window-button")
    private WebElement addTagButton;


    @FindBy(className = "bxhtmled-top-bar-wrap")
    private WebElement editorTextBar;

    @FindBy(id = "blog-title")
    private WebElement topicTitle;

    public String addaQuotetotheMessage(String message) {
        wait.until(ExpectedConditions.visibilityOf(quoteButton)).click();
        driver.switchTo().frame(wait.until(ExpectedConditions.visibilityOf(iframeforQuote)));
        wait.until(ExpectedConditions.visibilityOf(texttoEnter)).sendKeys(message);
        String text = texttoEnter.getText();
        driver.switchTo().defaultContent();
        return text;
    }

    public void clickAddMentionIconAndSelectContactList() {
        driver.findElement(By.xpath("//div//span[@id='bx-b-mention-blogPostForm']")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//a[text()='Employees and departments']")).click();
        BrowserUtils.wait(5);
        driver.findElement(By.xpath("(//div[@class='bx-finder-company-department-employee-info'])[2]")).click();
        BrowserUtils.wait(5);

    }

    public String selectedContactName() {
        String contactName = driver.findElement(By.xpath("//span[@data-id='U521']")).getText();
        BrowserUtils.wait(5);
        return contactName;
    }


    public void clickVisualEditor() {
        visualEditor.click();
        BrowserUtils.wait(3);
    }

    public void clickTopicIcon() {
        topicIcon.click();
        BrowserUtils.wait(2);
    }

    public void createNewTag(String tagName) {

        tagIcon.click();
        BrowserUtils.wait(3);
        tagBox.sendKeys(tagName);
        BrowserUtils.wait(2);
        addTagButton.click();
        BrowserUtils.wait(5);
    }

    public boolean editorTextBarDisplay(){
        BrowserUtils.wait(5);
        return editorTextBar.isDisplayed();
    }

    public boolean topicTitleDisplay(){
        BrowserUtils.wait(5);
        return topicTitle.isDisplayed();
    }

    public String getTagName(){
       BrowserUtils.wait(5);
        return tagList.getText();

    }
}

