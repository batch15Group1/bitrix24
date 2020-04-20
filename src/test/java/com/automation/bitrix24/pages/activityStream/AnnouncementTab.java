package com.automation.bitrix24.pages.activityStream;

import com.automation.bitrix24.pages.AbstractPageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AnnouncementTab extends AbstractPageBase {

    // uploadButton
    @FindBy(xpath = "//span[@id='bx-b-uploadfile-blogPostForm']")
    private WebElement uploadButtonforFile;

    //upload from the local disk
    @FindBy(xpath = "(//td[@class='diskuf-selector wd-fa-add-file-light-cell wd-fa-add-file-from-main'])[1]")
    private WebElement dragFileToUploadButton;

    // upload documents from Bitrix 24
    @FindBy(xpath = "(//span[text()='Select document from Bitrix24'])[1]")
    private WebElement availableLibrariesButton;

    // upload from external drive (Google driver, dropbox, etc.)
    @FindBy(xpath = "(//span[text()='Download from external drive'])[1]")
    private WebElement downloadfromExternalDriveButton;

    // create files from desktop application
    @FindBy(xpath = "(//span[text()='Desktop applications'])[1]")
    private WebElement applicationButton;

    public void clickToUploadFilesButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(uploadButtonforFile)).click();

//public void clickToDragFilesButton(){
//        WebDriverWait wait2 =new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.elementToBeClickable(dragFileToUploadButton)).click();
//}
//public void clickToFromBtrixButton(){
//            WebDriverWait wait3 =new WebDriverWait(driver, 10);
//            wait.until(ExpectedConditions.elementToBeClickable(availableLibrariesButton)).click();
//}
//    public void clickToFromExternalButton(){
//        WebDriverWait wait4 =new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.elementToBeClickable(downloadfromExternalDriveButton)).click();
//}
//    public void clickToCreateAppButton(){
//        WebDriverWait wait5 =new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.elementToBeClickable(applicationButton)).click();
    }
}