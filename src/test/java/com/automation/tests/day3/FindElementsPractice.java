package com.automation.tests.day3;

import com.automation.utilities.DriverMaker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsPractice {
    public static void main(String[] args) {
        WebDriver driver = DriverMaker.setupWebDriver("chrome");

        driver.get("http://practice.cybertekschool.com");
    }
}
