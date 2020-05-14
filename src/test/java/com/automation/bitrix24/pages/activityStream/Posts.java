package com.automation.bitrix24.pages.activityStream;

import java.util.List;

import com.automation.bitrix24.pages.AbstractPageBase;
import com.automation.bitrix24.utilities.BrowserUtils;
import com.automation.bitrix24.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Posts extends AbstractPageBase {

    // US10 AC 1

    @FindBy(xpath = "//div[@class='feed-item-wrap']")
    private List<WebElement> postsList;


    // like
    public boolean getLike() {
        String beforeClickClass = "", afterClickClass = "";
        for (WebElement each : postsList) {
            WebElement likeElement = each.findElement(By.xpath("//span[@class='bx-ilike-left-wrap']"));
            beforeClickClass = getClass(likeElement);
            if (beforeClickClass.equals("bx-ilike-left-wrap")) {
                likeElement.click();
                BrowserUtils.wait(3);
                afterClickClass = getClass(likeElement);
                break;
            }
        }
        return beforeClickClass.equals(afterClickClass);
    }

    public String getClass(WebElement el) {
        return el.getAttribute("class");
    }

    // follow
    public boolean getFollow() {
        String beforeClickText = "", afterClickText = "";
        for (WebElement each : postsList) {
            WebElement followElement = each.findElement(By.xpath("//span[@class='feed-inform-follow']/a"));
            beforeClickText = followElement.getText();
            if (beforeClickText.equals("Unfollow")) {
                followElement.click();
                BrowserUtils.wait(3);
                afterClickText = followElement.getText();
                break;
            }
        }
        return beforeClickText.equals(afterClickText);
    }


    // comment

    public String writeSmthToCommentBox() {
        postsList.get(0).findElement(By.xpath("//span[@class='feed-inform-comments']//a")).click();
        WebElement frameElement = postsList.get(0).findElement(By.xpath("//div[@class='bxhtmled-iframe-cnt']/iframe"));
        switchFrame(frameElement);
        writeComment(Driver.getDriver().findElement(By.tagName("body")), "comment2 text");
        switch2Parent();
        BrowserUtils.wait(3);
        postsList.get(0).findElement(By.xpath("//div[@class='feed-add-post-buttons']/button")).click();
        BrowserUtils.wait(3);
        String commentText = getElementText(postsList.get(0).findElement(By.xpath("//div[text()='comment2 text']")));
        return commentText;
    }

    public void switchFrame(WebElement el) {
        Driver.getDriver().switchTo().frame(el);
    }

    public void writeComment(WebElement el, String text) {
        el.sendKeys(text);
    }

    public void switch2Parent() {
        Driver.getDriver().switchTo().parentFrame();
    }

    public String getElementText(WebElement el) {
        return el.getText();
    }


    //AC2

    @FindBy(xpath = "//div[@class='feed-com-informers-bottom']//span[@class='bx-ilike-left-wrap']")
    private WebElement commentLike;

    @FindBy(xpath = "//div[@class='feed-com-informers-bottom']/span/span")
    private List<WebElement> commentLikes;

    @FindBy(xpath = "//div[@class='feed-com-informers-bottom']//a[2]")
    private List<WebElement> commentMoreLinks;

    @FindBy(xpath = "(//span[@class='menu-popup-item-text'])[1]")
    private WebElement viewComment;

    @FindBy(xpath = "//a[@class='feed-com-reply feed-com-reply-Y']")
    private List<WebElement> commentReplies;

    public void clickCommentLike() {
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(commentLikes.get(0))).click();
    }

    public String getCommentLikeClass() {
        BrowserUtils.wait(3);
        return commentLikes.get(0).getAttribute("class");
    }

    public String getTitle() {
        BrowserUtils.waitForPageToLoad(3);
        return Driver.getDriver().getTitle();
    }

    public void clickCommentMore() {
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(commentMoreLinks.get(0))).click();

    }

    public WebElement getViewCommentText() {
        BrowserUtils.wait(2);
        return viewComment;
    }

    public void clickCommentReply() {
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(commentReplies.get(0))).click();
    }

    // function to send comment on a post
    public boolean sendCommentReply() {

        WebElement frameElement = postsList.get(0).findElement(By.xpath("//div[@class='bxhtmled-iframe-cnt']/iframe"));
        Driver.getDriver().switchTo().frame(frameElement);
        Driver.getDriver().findElement(By.tagName("body")).sendKeys("comment reply text");
        Driver.getDriver().switchTo().parentFrame();
        postsList.get(0).findElement(By.xpath("//div[@class='feed-add-post-buttons']/button")).click();
        BrowserUtils.wait(3);
        String commentReplyText = postsList.get(0).findElement(By.xpath("//div[contains(text(),'comment reply text')]")).getText();
        System.out.println(commentReplyText);
        return commentReplyText.contains("comment reply text");
    }

    //AC3
    @FindBy(xpath = "(//div[@class='feed-com-user-box']/a)[1]")
    private WebElement reviewersName;

    @FindBy(xpath = "//div[@class='bx-ui-tooltip-user-name']")
    private WebElement reviewersBox;

    // function to get reviewer's name from comments
    public void getReviewersName() {
        Actions action = new Actions(Driver.getDriver());
        BrowserUtils.wait(3);
        action.moveToElement(reviewersName).pause(5000).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(reviewersBox));
        reviewersBox.click();
        BrowserUtils.waitForPageToLoad(5);
    }

   // AC 4. User should be able to add others' posts to favorite by clicking on the Star icon.

    public boolean getStarIcons() {
        String beforeClickClass = "", afterClickClass = "";
        for (WebElement each : postsList) {
            WebElement starIconElement = each.findElement(By.xpath("//div[@title='Add to favorites']"));
            beforeClickClass = getClass(starIconElement);
            if (beforeClickClass.equals("feed-post-important-switch")) {
                starIconElement.click();
                BrowserUtils.wait(3);
                afterClickClass = getClass(starIconElement);
                break;
            }
        }
        return beforeClickClass.equals(afterClickClass);
    }




}
