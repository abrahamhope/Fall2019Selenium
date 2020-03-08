package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createWebDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        WebElement simpleDropdown = driver.findElement(By.id("dropdown"));
        Select selectSimpleDropdown = new Select(simpleDropdown);
        //select by visible text
        selectSimpleDropdown.selectByVisibleText("Option 2");

        selectSimpleDropdown.selectByVisibleText("Option 1");
        BrowserUtils.wait(3);

        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));

        selectYear.selectByVisibleText("1982");
        selectMonth.selectByVisibleText("March");
        selectDay.selectByVisibleText("6");
        BrowserUtils.wait(3);

        // select all months one by one
        // .getOptions(); - returns all options from dropdown as List<WebElement>
        List<WebElement> months = selectMonth.getOptions();
        for (WebElement eachMonth:months){
            //get the month name and select basedn on that
            selectMonth.selectByVisibleText(eachMonth.getText());
            BrowserUtils.wait(1);
        }
//        BrowserUtils.wait(3);
//
//        List<WebElement> days = selectDay.getOptions();
//        for (WebElement eachDay:days){
//            //get the month name and select basedn on that
//            selectDay.selectByVisibleText(eachDay.getText());
//            BrowserUtils.wait(1);
//        }

        Select stateSelect = new Select(driver.findElement(By.id("state")));
        stateSelect.selectByVisibleText("Missouri");

        String selected=stateSelect.getFirstSelectedOption().getText();
        if(selected.equalsIgnoreCase("Missouri")){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }


        BrowserUtils.wait(3);
        driver.quit();
    }
}
