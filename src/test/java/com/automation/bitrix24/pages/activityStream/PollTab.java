package com.automation.bitrix24.pages.activityStream;

import com.automation.bitrix24.pages.AbstractPageBase;
import com.automation.bitrix24.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class PollTab extends AbstractPageBase {

    /**
     *  US 4. As a user, I should be able to create a
     *  poll by clicking on Poll tab under Active Stream.
     */


    // AC 3. User should be able to attach link by clicking on the link icon.

    @FindBy(id="feed-add-post-form-tab-vote")
    private WebElement pollTab;

    @FindBy(id = "bx-b-link-blogPostForm")
    private WebElement linkIcon;

    @FindBy(className = "bx-core-adm-dialog-head-inner")
    private WebElement linkPopupWindowHeadline;

    @FindBy(id = "linkidPostFormLHE_blogPostForm-text")
    private WebElement linkText;

    @FindBy(id = "linkidPostFormLHE_blogPostForm-href")
    private WebElement linkURL;

    @FindBy(id = "undefined")
    private WebElement saveButton;

    @FindBy(className = "bx-editor-iframe")
    private WebElement iFrame;

    @FindBy(partialLinkText = "Click on this link.")
    private WebElement text;

    // 5. User should be able to create a quote by clicking on the Comma icon.

    @FindBy (xpath = "//span[@id='bx-b-quote-blogPostForm']//span")
    private WebElement commaIcon;

    @FindBy(className = "bx-editor-iframe")
    private WebElement iFrameQuote;

    @FindBy(className = "bxhtmled-quote")
    private WebElement lineForQuote;

    @FindBy(id = "blog-submit-button-save")
    private WebElement sendButton;

    @FindBy (xpath = "/html/body/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]/table/tbody/tr/td/div/div[2]/div/div[3]/div[2]/div[1]/div/div[1]/div[3]/div[1]/div//div//table//tr//td")
    private WebElement postedQuote;

    // 6. User should be able to add mention by clicking on the Add mention icon and select contacts from the lists provided in dropdown.

    @FindBy(id = "bx-b-mention-blogPostForm")
    private WebElement addMentionIcon;

    @FindBy (xpath = "//div[@id='popup-window-content-BXSocNetLogDestination']/div/div[1]/a[2]")
    private WebElement employeesAndDepartments;

    @FindBy (xpath = "//div[@id=\"bx-lm-category-relation-129\"]/a[1]/div[1]/div[1]")
    private WebElement firstUserFromTheList;

    @FindBy(xpath = "//span[@id='feed-add-post-destination-item']/span[2]")
    private WebElement mentionedContact;

   // 7. User should be able to click on Visual Editor and see the editor text-bar displays on top of the message box.

    @FindBy(id = "lhe_button_editor_blogPostForm")
    private WebElement visualEditor;

    @FindBy(xpath = "//span[@class='bxhtmled-top-bar-btn bxhtmled-button-bold']")
    private WebElement boldIcon;



    public void clickOnLinkIcon(){
        linkIcon.click();
        BrowserUtils.wait(3);
    }

    public String getPopupWindowHeader(){
        wait.until(ExpectedConditions.visibilityOf(linkPopupWindowHeadline));
        return linkPopupWindowHeadline.getText();
    }

    public void fillInTheFields(){
        linkText.sendKeys("Click on this link.");
        linkURL.sendKeys("https://translate.google.com/");
    }

    public void clickOnSaveButton(){
        saveButton.click();
    }

    public void switchToIFrame(){
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrame));
    }
    public WebElement returnText(){
        return text;
    }

    public void exitFromIFrame(){
        driver.switchTo().defaultContent();
    }

    public void selectContuctFromTheList(){
        BrowserUtils.wait(3);
        addMentionIcon.click();
        wait.until(ExpectedConditions.elementToBeClickable(employeesAndDepartments)).click();
        wait.until(ExpectedConditions.elementToBeClickable(firstUserFromTheList)).click();
    }

    public WebElement getMentionedContact(){
        wait.until(ExpectedConditions.visibilityOf(mentionedContact));
        return mentionedContact;
    }


    public void sendQuote(){
        BrowserUtils.wait(3);
        commaIcon.click();
        BrowserUtils.wait(3);
        driver.switchTo().frame(iFrame);
        lineForQuote.sendKeys("Everyone's journey is different.");
        BrowserUtils.wait(2);
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.elementToBeClickable(sendButton));
        sendButton.click();
    }

    public WebElement getPostedQuote(){
        wait.until(ExpectedConditions.visibilityOf(postedQuote));
        return postedQuote;
    }


    public void clickOnVisualEditor(){
        BrowserUtils.wait(2);
        visualEditor.click();
        BrowserUtils.wait(3);
    }

    public WebElement boldIconIsDisplayed(){
        return boldIcon;
    }


}