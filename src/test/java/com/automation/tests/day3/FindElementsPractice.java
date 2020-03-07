package com.automation.tests.day3;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElementsPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverFactory.setupWebDriver("chrome");

        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement fullName =driver.findElement(By.name("full_name"));
        fullName.sendKeys("Isaac Hope");

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("hope@gsastl.org");

        WebElement signup = driver.findElement(By.name("wooden_spoon"));
        signup.submit();
        Thread.sleep(4000);

        WebElement signupMessage = driver.findElement(By.tagName("h3"));
        if(signupMessage.getText().equalsIgnoreCase("Thank you for signing up. Click the button below to return to the home page.")){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }


    driver.quit();
    }
}
