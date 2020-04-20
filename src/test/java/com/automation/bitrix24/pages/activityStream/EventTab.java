package com.automation.bitrix24.pages.activityStream;


import com.automation.bitrix24.pages.AbstractPageBase;
import com.automation.bitrix24.utilities.BrowserUtils;
import org.openqa.selenium.By;
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
     * 4. User should be able to insert videos by clicking on the video icon and entering the video URL.
     * 5. User should be able to create a quote by clicking on the Comma icon.
     * 6. User should be able to click on Visual Editor and see the editor text-bar displays on top of the message box.
     * 7. User should be able to add Event start and ending date and time, and specify the time zone.
     * 8. User should be able to set reminder by entering the timeing.
     * 9. User should be able to select event location from dropdown.
     * 10.User should be able to add attendees by selecting contacts individually or adding groups and departments.
     * 11.User should be able to click on More to specify the event details.
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
}
