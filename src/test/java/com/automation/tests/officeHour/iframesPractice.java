package com.automation.tests.officeHour;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class iframesPractice {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createWebDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void Test() {
        driver.get("http://practice.cybertekschool.com/nested_frames");
        driver.manage().window().maximize();
        driver.switchTo().frame("frame-top");

        List<WebElement> frameList = driver.findElements(By.xpath("//frame"));
        /*
            we have stored all frames webelements inside the list
            1. Loop through list
            2. swithch to each frame
                a. get test from body
                b. switch to parent
         */
        for (WebElement each : frameList) {

            BrowserUtils.wait(2);
            driver.switchTo().frame(each);
            String bodyText = driver.findElement(By.tagName("body")).getText();
            System.out.println("bodyText = " + bodyText);
            driver.switchTo().parentFrame();

        }


    }

}
