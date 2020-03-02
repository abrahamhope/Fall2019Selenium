package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class OutlookLogin {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=13&ct=1583106492&rver=7.0.6737.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fnlp%3d1%26RpsCsrfState%3d79f49d47-0a14-7799-18ec-f2f171e00eb4&id=292841&aadredir=1&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=90015");
        Thread.sleep(2000);

        WebElement search = driver.findElement(By.name("loginfmt"));
        search.sendKeys("isikdurmus@outlook.com", Keys.ENTER);
        Thread.sleep(4000);

        WebElement password = driver.findElement(By.name("passwd"));
        password.sendKeys("Galatasaray12", Keys.ENTER);
        Thread.sleep(4000);

        
    }
}
