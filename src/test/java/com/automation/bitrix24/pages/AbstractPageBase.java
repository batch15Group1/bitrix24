package com.automation.bitrix24.pages;

import com.automation.bitrix24.utilities.BrowserUtils;
import com.automation.bitrix24.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPageBase {

    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 25);

    @FindBy(id = "user-block")
    protected WebElement currentUser;

    @FindBy(id = "search-textbox-input")
    protected WebElement searchBox;

    @FindBy(id = "timeman-container")
    protected WebElement clockBox;

    @FindBy(id = "logo_24_a")
    protected WebElement homeBtn_CRM24;

    @FindBy(id = "sitemap-menu")
    protected WebElement siteMapBtn;


    public AbstractPageBase() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Method for Btrix24 navigation. Provide tab name to navigate
     *
     * @param tabName, like Message, Task, Poll, Event, File, Appreciation, Announcement, Workflow
     */
    public void navigateTo(String tabName) {
        BrowserUtils.waitForPageToLoad(10);
        String tabNameXpath = "//span[contains(@class,'feed-add-post-form-')]/span[text()='" + tabName + "']";
        if (tabName.equals("File") || tabName.equals("Appreciation") || tabName.equals("Announcement") || tabName.equals("Workflow")) {
            WebElement moreTab = driver.findElement(By.cssSelector("[id=\"feed-add-post-form-link-more\"]"));
            wait.until(ExpectedConditions.elementToBeClickable(moreTab)).click();
            BrowserUtils.wait(4);

        }
        WebElement tabElement = driver.findElement(By.xpath(tabNameXpath));
        wait.until(ExpectedConditions.elementToBeClickable(tabElement)).click();
    }

    /**
     * This method will navigate user to specified Main Modules on left menu
     *
     * @param module user will enter a main module name. Case Sensitive!!
     */
    public void mainModules(String module) {
        BrowserUtils.waitForPageToLoad(10);
        WebElement mainModule = driver.findElement(By.xpath("//*[@title='" + module + "']"));
        wait.until(ExpectedConditions.visibilityOf(mainModule)).click();
    }

    /**
     * This method will navigate user to specified Module and Sub-Module from top-left navigation
     *
     * @param module    user will enter main module name. Case Sensitive!!
     * @param subModule user will enter sub-module name. Case Sensitive!!
     */
    public void topNavigation(String module, String subModule) {
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(siteMapBtn));
        siteMapBtn.click();
        String path = "//*[@class='sitemap-section-title' and contains(text(),'" + module + "')] /..//a[@class='sitemap-section-item' and contains(text(),'" + subModule + "')]";
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(path)))).click();
    }

    /**
     * This method returns Current User Name
     *
     * @return user name as String value
     */
    public String getCurrentUserName() {
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(currentUser));
        return currentUser.getText().trim();
    }

    /**
     * This method will run search function based on provided String value
     *
     * @param value accepts String value
     */
    public void search_value(String value) {
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.sendKeys(value, Keys.ENTER);
    }

    /**
     * This method will click on home button (CRM 24) - to navigate home page
     */
    public void clickHomeBtn() {
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(homeBtn_CRM24)).click();
    }
}
