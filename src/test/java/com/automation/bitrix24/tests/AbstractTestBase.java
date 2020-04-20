package com.automation.bitrix24.tests;

import com.automation.bitrix24.utilities.BrowserUtils;
import com.automation.bitrix24.utilities.ConfigurationReader;
import com.automation.bitrix24.utilities.Driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;


public abstract class AbstractTestBase {
    protected WebDriverWait wait;
    protected Actions actions;
    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest test;


    @BeforeTest
    @Parameters("reportName")
    public void setupTest(@Optional String reportName) {
        System.out.println("reportName = " + reportName);
        reportName = reportName == null ? "report.html" : reportName + ".html";
        report = new ExtentReports();
        String reportPath = "";
        //location of report file
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            reportPath = System.getProperty("user.dir") + "\\test-output\\" + reportName;
        } else {
            reportPath = System.getProperty("user.dir") + "/test-output/" + reportName;
        }
        //HTML report
        htmlReporter = new ExtentHtmlReporter(reportPath);
        //add it to the reporter
        report.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("Btrix24 Test Automation Results");

    }

    @AfterTest
    public void afterTest() {
        report.flush();// to release report
    }


    @BeforeMethod
    public void setUp() {
        WebDriver driver = Driver.getDriver();
        String url = ConfigurationReader.getProperty("url");
        driver.get(url);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 15);
        actions = new Actions(driver);
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) throws IOException {
        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            //take screen shot:
            String screenshotPath = BrowserUtils.getScreenshot(iTestResult.getName());
            //we can put some wait here;
            BrowserUtils.waitForPageToLoad(5);

            test.addScreenCaptureFromPath(screenshotPath);// attach screen shot
            test.fail(iTestResult.getName());//attach test name that failed
            test.fail(iTestResult.getThrowable());// attach console output
        }

        Driver.closeDriver();
    }

}
