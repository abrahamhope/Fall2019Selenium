package com.automation.tests.day3;

import com.automation.utilities.DriverMaker;
import org.openqa.selenium.WebDriver;

public class FindElementById {
    public static void main(String[] args) {
        WebDriver driver = DriverMaker.setupWebDriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");
    }
}
