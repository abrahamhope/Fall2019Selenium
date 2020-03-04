package com.automation.tests.day3;

import com.automation.utilities.DriverMaker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindElementById {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverMaker.setupWebDriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        Thread.sleep(3000);

        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        Thread.sleep(3000);

        driver.findElement(By.id("wooden_spoon")).submit();
        Thread.sleep(3000);

        String expected ="Welcome to the Secure Area. When you are done click logout below.";
        System.out.println(expected.equals(driver.findElement(By.className("subheader")).getText()) ?
                "Test Passed" : "Test Failed");


        // let's click on Logout button. It

        driver.quit();
    }
}
