package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByIndex {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createWebDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        Select stateSelected = new Select(driver.findElement(By.id("state")));
        stateSelected.selectByIndex(9);

        String expected = "District Of Columbia";
        String actual = stateSelected.getFirstSelectedOption().getText();

        if(expected.equals(actual)){
            System.out.println( "TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

        BrowserUtils.wait(2);
        driver.quit();
    }
}
