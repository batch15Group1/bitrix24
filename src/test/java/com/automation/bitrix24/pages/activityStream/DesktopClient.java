package com.automation.bitrix24.pages.activityStream;

import com.automation.bitrix24.pages.AbstractPageBase;
import com.automation.bitrix24.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DesktopClient extends AbstractPageBase {
    @FindBy(xpath = "//div[text()='Desktop client']")
    private WebElement desktopClientButton;

    @FindBy(xpath = "//span[text()='Mac OS']")
    private WebElement macOSIcon;

    @FindBy(xpath = "//span[text()='Windows']")
    private WebElement windowsIcon;

    @FindBy(xpath = "//span[text()='Linux']")
    private WebElement linuxIcon;


    //==========================US_11_AC_1_2_3==========================//
    public void ChooseTheIconclickAndDownload(String icon){
        BrowserUtils.waitForPageToLoad(10);
        if(icon.equals("macOSIcon")) {
            BrowserUtils.scrollTo(desktopClientButton);
            BrowserUtils.wait(3);
            wait.until(ExpectedConditions.elementToBeClickable(macOSIcon)).click();
        }else if(icon.equals("windowsIcon")){
            BrowserUtils.scrollTo(desktopClientButton);
            BrowserUtils.wait(3);
            wait.until(ExpectedConditions.elementToBeClickable(windowsIcon)).click();
        }else if(icon.equals("linuxIcon")){
            BrowserUtils.scrollTo(desktopClientButton);
            BrowserUtils.wait(3);
            wait.until(ExpectedConditions.elementToBeClickable(linuxIcon)).click();
        }else{
            throw new RuntimeException("Invalid icon");
        }
    }


//==========================US_11_AC_1==========================//
//    public void scrollToDesktopClientElement(){
//        BrowserUtils.waitForPageToLoad(30);
//
//        BrowserUtils.scrollTo(desktopClientButton);
//        BrowserUtils.wait(3);
//    }

//    public void clickAndDownloadForUserMacOS(){
//        BrowserUtils.waitForPageToLoad(10);
//            wait.until(ExpectedConditions.elementToBeClickable(macOSIcon)).click();
//
//    }


}


