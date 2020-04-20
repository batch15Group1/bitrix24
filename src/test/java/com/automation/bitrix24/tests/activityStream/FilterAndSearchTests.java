package com.automation.bitrix24.tests.activityStream;

import com.automation.bitrix24.pages.LoginPage;
import com.automation.bitrix24.pages.activityStream.FilterAndSearch;
import com.automation.bitrix24.tests.AbstractTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterAndSearchTests extends AbstractTestBase {

    //All clean working codes, thank you
    @Test
    public void filterAndSearchByDefaultTest() {
        test = report.createTest("search by default");
        LoginPage loginPage = new LoginPage();
        FilterAndSearch filterAndSearch = new FilterAndSearch();
        loginPage.loginAsHr();
        filterAndSearch.clickFilerToSearchActivities();
        Assert.assertEquals(filterAndSearch.getDefaultOwner(), filterAndSearch.getCurrentUserName());

        filterAndSearch.clickToSearchAnnouncement();
        Assert.assertTrue(!filterAndSearch.getToAllAnnouncement().isEmpty());
        test.pass("verified searching by default options");

    }


    @Test
    public void clickToSaveNewFilterTest() {
        test = report.createTest("create new filter");
        LoginPage loginPage = new LoginPage();
        FilterAndSearch filterAndSearch = new FilterAndSearch();
        loginPage.loginAsHr();
        filterAndSearch.clickToSaveFilter("email");
        Assert.assertEquals(filterAndSearch.getNewFilterName(), "email");
        test.pass("verified new filter name");
    }


}
