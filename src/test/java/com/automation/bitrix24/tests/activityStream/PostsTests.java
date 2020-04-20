package com.automation.bitrix24.tests.activityStream;

import com.automation.bitrix24.pages.LoginPage;
import com.automation.bitrix24.pages.activityStream.Posts;
import com.automation.bitrix24.tests.AbstractTestBase;
import com.automation.bitrix24.utilities.BrowserUtils;
import com.automation.bitrix24.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PostsTests extends AbstractTestBase {

    //peer review :
    //great working tests; just 1 issue in here as mentioned below :
    //We use all wait methods in page class >> Browser utils, implicit and explicit waits.

    /*
    US 10. As a user, I should be able to interact with employees on the posts that I have access to.
    AC 1. User should be able to make a comment, like, or unfollow on other employees' posts.
     */
    @Test
    public void likeTest() {
        test = report.createTest("Reaching \"Activity Stream Page \" as a Marketing user");

        LoginPage loginpage = new LoginPage();
        loginpage.loginAsMarketing();

        test.info("Login as Marketing user");
        BrowserUtils.wait(3);

        Assert.assertEquals(Driver.getDriver().getTitle(), "Portal");

        Posts posts = new Posts();
        Assert.assertFalse(posts.getLike());
    }

    @Test
    public void followTest() {
        test = report.createTest("follow the post");

        LoginPage loginpage = new LoginPage();
        loginpage.loginAsMarketing();

        BrowserUtils.wait(3);
        Assert.assertEquals(Driver.getDriver().getTitle(), "Portal");

        Posts posts = new Posts();
        Assert.assertFalse(posts.getFollow());
    }

    @Test
    public void commentTest() {
        test = report.createTest("Write a comment");

        LoginPage loginpage = new LoginPage();
        loginpage.loginAsMarketing();

        BrowserUtils.wait(3);
        Assert.assertEquals(Driver.getDriver().getTitle(), "Portal");


        Posts posts = new Posts();
        Assert.assertEquals(posts.writeSmthToCommentBox(), "comment1 text");
    }
}

