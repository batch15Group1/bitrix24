package com.automation.bitrix24.pages;

import com.automation.bitrix24.utilities.ConfigurationReader;
import com.automation.bitrix24.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPageBase {

    @FindBy(name = "USER_LOGIN")
    private WebElement userName;

    @FindBy(name = "USER_PASSWORD")
    private WebElement password;

    @FindBy(className = "login-btn")
    private WebElement login;

    @FindBy(className = "login-link-forgot-pass")
    private WebElement forgotPassword;

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    /**
     * This is for different user login credentials
     *
     * @param userValue     accepts a user email
     * @param passwordValue accepts a password
     */
    public void login(String userValue, String passwordValue) {
        userName.sendKeys(userValue);
        password.sendKeys(passwordValue);
        login.click();
    }

    /**
     * Choose user type for different user levels
     *
     * @param userType help_desk, marketing, hr
     */
    public void loginAs(String userType) {
        userName.sendKeys(ConfigurationReader.getProperty(userType));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        login.click();
    }

    /**
     * Login as HR user
     */
    public void loginAsHr() {
        userName.sendKeys(ConfigurationReader.getProperty("hr_25"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        login.click();
    }

    /**
     * Login as Help Desk User
     */
    public void loginAsHelpDesk() {
        userName.sendKeys(ConfigurationReader.getProperty("helpdesk_25"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        login.click();
    }

    /**
     * Login as Marketing User
     */
    public void loginAsMarketing() {
        userName.sendKeys(ConfigurationReader.getProperty("marketing_25"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        login.click();
    }

}
