package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import com.google.gson.internal.$Gson$Preconditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NoSelectDropdown {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createWebDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        driver.findElement(By.id("dropdownMenuLink")).click(); //to expand dropdown
        BrowserUtils.wait(2);

        driver.findElement(By.linkText("Google")).click();


        BrowserUtils.wait(3);
        driver.quit();
    }
}
