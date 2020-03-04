package com.automation.tests.day3;

import com.automation.utilities.DriverMaker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverMaker.setupWebDriver("chrome");

        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement fullName =driver.findElement(By.name("full_name"));
        fullName.sendKeys("Isaac Hope");

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("hope@gsastl.org");

        WebElement signup = driver.findElement(By.name("wooden_spoon"));
        signup.submit();

        Thread.sleep(4000);
    driver.quit();
    }
}
