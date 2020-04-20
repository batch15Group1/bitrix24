package com.automation.bitrix24.pages.activityStream;

import java.util.List;

import com.automation.bitrix24.pages.AbstractPageBase;
import com.automation.bitrix24.utilities.BrowserUtils;
import com.automation.bitrix24.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Posts extends AbstractPageBase {

    // US10 AC 1

    //peer review
    //It is better to find elements with FindBy, gives more clean code and
    // when you need to change the locators; you won't deal with methods in this way :)

    @FindBy(xpath = "//div[@class='feed-item-wrap']")
    private List<WebElement> postsList;

    // like
    public boolean getLike() {
        int size = postsList.size();
        String beforeClickClass = "", afterClickClass = "";
        for (int i = 0; i < size; i++) {
            WebElement element = postsList.get(i);
            WebElement likeElement = element.findElement(By.xpath("//span[@class='bx-ilike-left-wrap']"));
            beforeClickClass = likeElement.getAttribute("class");
            if (beforeClickClass.equals("bx-ilike-left-wrap")) {
                likeElement.click();
                BrowserUtils.wait(3);
                afterClickClass = likeElement.getAttribute("class");
                break;
            }
        }
        //System.out.println(beforeClickClass+" / "+afterClickClass);
        return beforeClickClass.equals(afterClickClass);
    }

    // follow

    public boolean getFollow() {
        int size = postsList.size();
        String beforeClickText = "", afterClickText = "";
        for (int i = 0; i < size; i++) {
            WebElement element = postsList.get(i);
            WebElement followElement = element.findElement(By.xpath("//span[@class='feed-inform-follow']/a"));
            beforeClickText = followElement.getText();
            if (beforeClickText.equals("Unfollow")) {
                followElement.click();
                BrowserUtils.wait(3);
                afterClickText = followElement.getText();
                break;
            }
        }
        //System.out.println(beforeClickText+" / "+afterClickText);
        return beforeClickText.equals(afterClickText);
    }


    // çomment

    public String writeSmthToCommentBox() {

        postsList.get(0).findElement(By.xpath("//span[@class='feed-inform-comments']//a")).click();
        WebElement frameElement = postsList.get(0).findElement(By.xpath("//div[@class='bxhtmled-iframe-cnt']/iframe"));
        Driver.getDriver().switchTo().frame(frameElement);
        Driver.getDriver().findElement(By.tagName("body")).sendKeys("comment1 text");
        Driver.getDriver().switchTo().parentFrame();
        postsList.get(0).findElement(By.xpath("//div[@class='feed-add-post-buttons']/button")).click();
        BrowserUtils.wait(3);
        String commentText = postsList.get(0).findElement(By.xpath("//div[text()='comment1 text']")).getText();
        System.out.println(commentText);
        return commentText;
    }


}
