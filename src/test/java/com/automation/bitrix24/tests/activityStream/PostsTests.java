package com.automation.bitrix24.tests.activityStream;

import com.automation.bitrix24.pages.LoginPage;
import com.automation.bitrix24.pages.activityStream.Posts;
import com.automation.bitrix24.tests.AbstractTestBase;
import com.automation.bitrix24.utilities.BrowserUtils;
import com.automation.bitrix24.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PostsTests extends AbstractTestBase {

    /*
    US 10. As a user, I should be able to interact with employees on the posts that I have access to.
    AC 1. User should be able to make a comment, like, or unfollow on other employees' posts.
     */
    @Test
    public void likeTest() {
        test = report.createTest("User should be able to like the post");

        LoginPage loginpage = new LoginPage();
        loginpage.loginAsMarketing();

        Assert.assertEquals(Driver.getDriver().getTitle(), "Portal");

        Posts posts = new Posts();
        Assert.assertFalse(posts.getLike());
        test.pass("User should be able to like the post is verified");
    }

    @Test
    public void followTest() {
        test = report.createTest("follow the post");

        LoginPage loginpage = new LoginPage();
        loginpage.loginAsMarketing();

        Assert.assertEquals(Driver.getDriver().getTitle(), "Portal");

        Posts posts = new Posts();
        Assert.assertFalse(posts.getFollow());
        test.pass("User should be able to follow the post is verified");
    }

    @Test
    public void commentTest() {
        test = report.createTest("Write a comment");

        LoginPage loginpage = new LoginPage();
        loginpage.loginAsMarketing();

        BrowserUtils.wait(3);
        Assert.assertEquals(Driver.getDriver().getTitle(), "Portal");

        Posts posts = new Posts();
        Assert.assertEquals(posts.writeSmthToCommentBox(), "comment2 text");
        test.pass("User should be able to comment the post is verified");
    }

    //AC 2.User should be able to view, like, or make comments on all other reviewers's comments.

    @Test
    public void ReviewersLikeCommentTest() {
        test = report.createTest("Like,view and make comments on other reviewers' comments ");
        LoginPage loginpage = new LoginPage();
        loginpage.loginAsMarketing();

        Posts posts = new Posts();
        Assert.assertEquals(posts.getTitle(), "Portal");

        String beforeClass=posts.getCommentLikeClass();
        posts.clickCommentLike();
        String afterClass=posts.getCommentLikeClass();
        Assert.assertNotEquals(beforeClass,afterClass);

        posts.clickCommentMore();
        Assert.assertTrue(posts.getViewCommentText().isDisplayed());

        posts.clickCommentReply();
        Assert.assertTrue(posts.sendCommentReply());
      test.pass("Like,view and make comments on other reviewers' comments are verified");
    }

    //3. User should be able to click on reviewers' name and visit their profiles.

    @Test
    public void ReviewersProfileTest(){
        test = report.createTest("Access reviewer's profile");
        LoginPage loginpage = new LoginPage();
        loginpage.loginAsMarketing();

        Posts posts = new Posts();
        String title = posts.getTitle();
        Assert.assertEquals(title, "Portal");

        posts.getReviewersName();

        Assert.assertNotEquals(title,posts.getTitle());
        test.pass("User should be able to click on reviewer' name and visit their profile is verified");

    }
    // AC 4. User should be able to add others' posts to favorite by clicking on the Star icon.

    @Test
    public void addFavoriteByClickingStarIcon() {
        test = report.createTest("Add posts to favorites by clicking to star icon");

        LoginPage loginpage = new LoginPage();
        loginpage.loginAsMarketing();

        Assert.assertEquals(Driver.getDriver().getTitle(), "Portal");

        Posts posts = new Posts();
        Assert.assertFalse(posts.getStarIcons());
        test.pass("User should be able to add others' posts to favorite by clicking the star icon is verified");
    }
}

