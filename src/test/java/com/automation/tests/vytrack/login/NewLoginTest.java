package com.automation.tests.vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewLoginTest extends AbstractTestBase {

    /**
     * Login and verify that the page title is "Dashboard"
     */
    @Test
    public void verifyPageTitle(){
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
    }

    /**
     * Enter
     */
    @Test
    public void verifyWarningMessage(){
       LoginPage loginPage = new LoginPage();
       loginPage.login("wrong", "wrong");
       Assert.assertEquals(loginPage.getWarningMessageText(),"Invalid user name or password.");

    }
}
