package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alerts {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createWebDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(3);

        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        buttons.get(0).click(); // to click the first button
        BrowserUtils.wait(2);

        String popupText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept(); // accept clicks the OK button

        String expected= "You successfully clicked an alert";
        String actual=driver.findElement(By.id("result")).getText();

        if(expected.equals(actual)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
            System.out.println("Expected: "+expected);
            System.out.println("Actual: "+actual);
        }
        //##################################
        //TEST#2
        buttons.get(1).click(); // to click the first button
        BrowserUtils.wait(2);
        driver.switchTo().alert().dismiss(); // accept clicks the OK button

        String expected2= "You clicked: Cancel";
        String actual2= driver.findElement(By.id("result")).getText();

        if(expected2.equals(actual2)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
            System.out.println("Expected: "+expected2);
            System.out.println("Actual: "+actual2);
        }

        //################
        //TEST#3
        buttons.get(2).click(); // to click the first button
        BrowserUtils.wait(2);
        String entry="hello";
        driver.switchTo().alert().sendKeys(entry);
        driver.switchTo().alert().accept();

        String expected3= entry;
        String actual3= driver.findElement(By.id("result")).getText();

        if(actual3.endsWith(expected3)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
            System.out.println("Expected: "+expected3);
            System.out.println("Actual: "+actual3);
        }


        BrowserUtils.wait(3);
        driver.quit();

    }
}
