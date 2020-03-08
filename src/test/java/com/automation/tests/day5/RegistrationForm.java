package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegistrationForm {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createWebDriver("chrome");
        driver.get("http://practice.cybertekschool.com/registration_form");
        BrowserUtils.wait(5);

        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        driver.findElement(By.name("username")).sendKeys("jsmith");
        driver.findElement(By.name("email")).sendKeys("jsmith@cyber.com");
        driver.findElement(By.name("password")).sendKeys("mypassword");
        driver.findElement(By.name("phone")).sendKeys("123-456-7890");

        List<WebElement> genders = driver.findElements(By.name("gender"));
        genders.get(2).click();

        driver.findElement(By.name("birthday")).sendKeys("01/01/2007");
        driver.findElement(By.id("inlineCheckbox2")).click();
        driver.findElement(By.id("wooden_spoon")).click();

        BrowserUtils.wait(5);

        driver.quit();
    }
}
