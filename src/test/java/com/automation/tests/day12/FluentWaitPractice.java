package com.automation.tests.day12;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FluentWaitTest {
private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createWebDriver("chrome");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void  fluentWaitTest(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/5");

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementClickInterceptedException.class);

    }

}
