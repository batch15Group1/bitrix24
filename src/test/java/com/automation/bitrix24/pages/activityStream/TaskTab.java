package com.automation.bitrix24.pages.activityStream;

import com.automation.bitrix24.pages.AbstractPageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * "2. As a user, I should be able to assign
 * tasks by clicking on Task tab under Active Stream."
 */
public class TaskTab extends AbstractPageBase {

    @FindBy(xpath = "//*[@class='menu-item-link-text' and contains(text(),'Tasks')]")
    private WebElement taskTab;

    @FindBy(xpath = "//a[@id='task-buttonAdd']")
    private WebElement newTask;

    @FindBy(xpath = "//input[@id='tasks-task-priority-cb']")
    private WebElement highPriority;

    //    1. User should be able to click on "High Priority" checkbox to set the current task to a top priority task.
    public void clickHighPriorityBox() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(taskTab)).click();
        wait.until(ExpectedConditions.elementToBeClickable(newTask)).click();
        wait.until(ExpectedConditions.elementToBeClickable(highPriority)).click();
    }

//    2. User should be able to click on Visual Editor and see the editor text-bar displays on top of the message box.
//    3. User should be able to click on upload files icon to upload files
//    and pictures from local disks, download from external drive, select documents from bixtrix24, and create files to upload.
}
