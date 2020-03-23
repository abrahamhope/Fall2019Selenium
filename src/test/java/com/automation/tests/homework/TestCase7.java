package com.automation.tests.homework;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;

public class TestCase7 {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createWebDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement fileUpload = driver.findElement(By.linkText("File Upload"));
        fileUpload.click();
    }

}
