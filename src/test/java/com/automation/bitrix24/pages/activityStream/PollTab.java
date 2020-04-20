package com.automation.bitrix24.pages.activityStream;

import com.automation.bitrix24.pages.AbstractPageBase;
import com.automation.bitrix24.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class PollTab extends AbstractPageBase {

    //peer review :
    //your codes are nice and clean, only 1 issue mentioned below :
    //this page class is for finding locators and wrap them with methods to use in test class.
    //Since we do not run any test in this class; we do not use Assertion in here
    //we do our assertions on test class =>   Assert.assertTrue(text.isDisplayed());

    /**
     * US 4. As a user, I should be able to create a
     * poll by clicking on Poll tab under Active Stream.
     */


    // AC 3. User should be able to attach link by clicking on the link icon.

    @FindBy(id = "feed-add-post-form-tab-vote")
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

    public void clickOnLinkIcon() {
        linkIcon.click();
        BrowserUtils.wait(3);
    }

    public String getPopupWindowHeader() {
        wait.until(ExpectedConditions.visibilityOf(linkPopupWindowHeadline));
        return linkPopupWindowHeadline.getText();
    }

    public void fillInTheFields() {
        linkText.sendKeys("Click on this link.");
        linkURL.sendKeys("https://translate.google.com/");
    }

    public void clickOnSaveButton() {
        saveButton.click();
    }

    public void verifyIfLinkWasAttached() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrame));
        // driver.switchTo().frame(iFrame);
        Assert.assertTrue(text.isDisplayed());
        driver.switchTo().defaultContent();

    }


}
