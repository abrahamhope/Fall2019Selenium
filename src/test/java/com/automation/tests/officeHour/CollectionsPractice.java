package com.automation.tests.officeHour;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionsPractice {
    public static void main(String[] args) {
        List<String> priceLstStr =  new ArrayList<>( Arrays.asList("99.99","149.99","79.99","149.99","299.99","599.99","299.99","599.99"));
        priceLstStr.add("999.99");
        System.out.println("priceLstStr = " + priceLstStr);
        // but we want to get List<Double>
        List<Double> prices = new ArrayList<>();
        for (String eachPrice : priceLstStr) {
            prices.add(  Double.parseDouble(eachPrice)  );
        }
        System.out.println("prices in double = " + prices);
        // how do I get max price , min , average
        // remove items above average
        //  get the unique prices

    }


    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
    }

    @Test
    public void pricesTest(){
        driver.get("https://www.amazon.com/s?k=iphone&ref=nb_sb_noss_2");
        List<WebElement> names = driver.findElements(By.cssSelector("span[class='a-size-medium a-color-base a-text-normal']"));
        List<WebElement> prices = driver.findElements(By.xpath("//div[@class='a-section a-spacing-mini a-spacing-top-small']"));

        for (WebElement price : prices) {
            System.out.println("price = " + price);
        }
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
