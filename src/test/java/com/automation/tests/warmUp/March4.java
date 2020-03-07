package com.automation.tests.warmUp;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class March4 {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
ebayTest();
amazonTests();
wikiTest();


    }

    public static void ebayTest() throws InterruptedException {
        driver = DriverFactory.setupWebDriver("chrome");
        driver.get("https://www.ebay.com/");
        driver.findElement(By.id("gh-ac")).sendKeys("ps4");
        driver.findElement(By.id("gh-btn")).click();
        Thread.sleep(2000);
        WebElement searchResults= driver.findElement(By.tagName("h1"));
        System.out.println(searchResults.getText());

        driver.quit();
    }

    public static void amazonTests(){
        driver = DriverFactory.setupWebDriver("chrome");
        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("ps4", Keys.ENTER);
        String title =driver.getTitle();
        System.out.println(title.contains("ps4"));
        driver.quit();
    }

    public static void wikiTest(){
        driver = DriverFactory.setupWebDriver("chrome");
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        driver.findElement(By.id("searchInput")).sendKeys("Selenium (software)", Keys.ENTER);
        String link = driver.getCurrentUrl(); // to get link as a String
        if(link.endsWith("Selenium_(software)")){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }
        driver.quit();


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

