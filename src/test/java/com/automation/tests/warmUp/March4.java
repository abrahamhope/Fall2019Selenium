package com.automation.tests.warmUp;

import com.automation.utilities.DriverMaker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class March4 {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
ebayTest();
//amazonTests();
wikiTest();


    }

    public static void ebayTest() throws InterruptedException {
        driver = DriverMaker.setupWebDriver("chrome");
        driver.get("https://www.ebay.com/");
        driver.findElement(By.id("gh-ac")).sendKeys("ps4");
        driver.findElement(By.id("gh-btn")).click();
        Thread.sleep(2000);
        WebElement searchResults= driver.findElement(By.tagName("h1"));
        System.out.println(searchResults.getText());

        driver.quit();
    }

    public static void amazonTests(){


    }

    public static void wikiTest(){


    }

    /*
Go to ebay
enter search term
click on search button
print number of results
go to amazon
Go to ebay
enter search term
click on search button
verify title contains search term
Go to wikipedia.org
enter search term `selenium webdriver`
click on search button
click on search result `Selenium (software)`
verify url ends with `Selenium_(software)`
     */

}

