package com.automation.bitrix24.pages.activityStream;

import com.automation.bitrix24.pages.AbstractPageBase;
import com.automation.bitrix24.utilities.BrowserUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class FilterAndSearch extends AbstractPageBase {

    @FindBy(id = "LIVEFEED_search")
    private WebElement filterAndSearchBox;

    @FindBy(css = "div[data-id='my']")
    private WebElement dropDownMyActivity;

    @FindBy(id = "bp_356")
    private WebElement myActivities;

    @FindBy(css = "div[data-id='important']")
    private WebElement dropDownAnnouncements;

    @FindBy(className = "feed-add-post-destination-new")
    private List<WebElement> toAllAnnouncement;

    @FindBy(xpath = "//span[text()='Save filter']")
    private WebElement saveFilter;

    @FindBy(className = "main-ui-filter-sidebar-edit-control")
    private WebElement filterName;

    @FindBy(xpath = "//*[@id=\"popup-window-content-LIVEFEED_search_container\"]/div/div/div[1]/div[2]/div[8]/span[2]/span[1]")
    private WebElement newFilterName;


    public void clickFilerToSearchActivities() {
        filterAndSearchBox.click();
        BrowserUtils.wait(3);
        wait.until(ExpectedConditions.elementToBeClickable(dropDownMyActivity));
        dropDownMyActivity.click();

    }

    public String getDefaultOwner() {
        wait.until(ExpectedConditions.visibilityOf(myActivities));
        return myActivities.getText();
    }

    public void clickToSearchAnnouncement() {
        filterAndSearchBox.click();
        BrowserUtils.wait(3);
        wait.until(ExpectedConditions.elementToBeClickable(dropDownAnnouncements));
        dropDownAnnouncements.click();
    }

    public List<WebElement> getToAllAnnouncement() {
        BrowserUtils.wait(3);
        return toAllAnnouncement;
    }

    public void clickToSaveFilter(String newFilterName) {
        filterAndSearchBox.click();
        BrowserUtils.wait(2);
        saveFilter.click();
        filterName.sendKeys(newFilterName, Keys.ENTER);
    }

    public String getNewFilterName() {
        BrowserUtils.wait(3);
        return newFilterName.getText().toLowerCase();
    }
}
