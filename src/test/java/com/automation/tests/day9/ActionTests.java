package com.automation.tests.day9;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionTests {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createWebDriver("chrome");
    }

    @Test
    public void hoverOnImage(){
        driver.get("http://practice.cybertekschool.com/hovers");
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
