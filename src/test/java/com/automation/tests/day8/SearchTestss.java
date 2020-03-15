package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTestss {
    private WebDriver driver;

    @Test
    public void googleSearchTest(){
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);

        BrowserUtils.wait(2);

        List<WebElement> searchItems = driver.findElements(By.tagName("h3"));
        for (WebElement searchItem:searchItems){
            String var= searchItem.getText();
            if(!var.isEmpty()){
                System.out.println(var);
                Assert.assertTrue(var.toLowerCase().contains("java"));
            }
        }

    }

    @Test(description = "Search for JAVA book on Amazon")
    public void amazonSearchTest(){
        driver.get("http://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java", Keys.ENTER);
        driver.manage().window().maximize();
        BrowserUtils.wait(5);

        List<WebElement> searchItems=driver.findElements(By.xpath("//h2//a"));
        searchItems.get(0).click();
        BrowserUtils.wait(5);

        WebElement productTitle = driver.findElement(By.id("title"));
        String productTitleString = productTitle.getText();
        System.out.println(productTitleString);

        Assert.assertTrue(productTitleString.contains("Java"));
    }


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
    }






    @AfterMethod
    public void tearDown(){
        //close browser and destroy browser object
        driver.quit();
    }



}
