package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxes {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createWebDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtils.wait(2);

        List<WebElement> checkBoxes =driver.findElements(By.tagName("input"));

        checkBoxes.get(0).click(); //click on first checkbox

        BrowserUtils.wait(2);

        checkBoxes.get(1).click(); // click on the second checkbox

        BrowserUtils.wait(2);

        for(int i=0; i<checkBoxes.size(); i++) {
            //       if visible,                            eligible to click  and         not clicked yet
            if (checkBoxes.get(i).isDisplayed() && checkBoxes.get(i).isEnabled() && (!checkBoxes.get(i).isSelected())) {
                //if checkbox is not selected, click on it
                checkBoxes.get(i).click(); // click on the checkbox

            }
        }



        driver.quit();


    }
}
