package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RadioButtons {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.setupWebDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);

        List<WebElement> radioButtons = driver.findElements(By.tagName("input"));

        for(WebElement radioButton:radioButtons){
           // <input type="radio" id="red" name="color">
            String id = radioButton.getAttribute("id");

            // return true if button already clicked
            boolean isSelected = radioButton.isSelected();

            // if button is eligible to click
            //returns true if button already clicked
            if(radioButton.isEnabled()) { // to check if the button is clickable, enabled or not
                radioButton.click();
                System.out.println("Clicked on :: "+id);
                BrowserUtils.wait(1);
            }else{
                System.out.println("Button is disabled, not clicked "+id);
            }
        }

        driver.quit();
    }
}
