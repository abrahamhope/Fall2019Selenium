package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import gherkin.lexer.Ja;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecuter2 {

    private WebDriver driver;

    @BeforeMethod
    private void setup(){
        driver = DriverFactory.createWebDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }



    @Test
    public void verifyTitle(){
        String expected = "Practice";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String actual = (String) js.executeScript("return document.title").toString();

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void clickTest(){
        WebElement link = driver.findElement(By.linkText("Multiple Buttons"));
//        link.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",link);
        WebElement button6 = driver.findElement(By.id("disappearing_button"));

        js.executeScript("arguments[0].click()",button6);

        BrowserUtils.wait(2);
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(), "Now it's gone!");
    }

    @Test
    public void textInputTest(){
        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtils.wait(3);

        WebElement username =  driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginbtn = driver.findElement(By.id("wooden_spoon"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].setAttribute('value', 'tomsmith')",username);
        js.executeScript("arguments[0].setAttribute('value', 'SuperSecretPassword')",password);
        js.executeScript("arguments[0].click()",loginbtn);

        BrowserUtils.wait(4);
        String expected= "Welcome to the Secure Area. When you are done click logout below.";
        String subheader = js.executeScript("return document.getElementsByClassName('subheader')[0].textContent").toString();

        Assert.assertEquals(subheader,expected);
    }

    @Test
    public void scrollToElement(){
    WebElement link = driver.findElement(By.linkText("Cybertek School"));
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView(true)",link);
    }

    @Test
    public void scrollTests(){
        driver.navigate().to("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 15; i++) {
            js.executeScript("window.scrollBy(0,100");
            BrowserUtils.wait(3);
        }
    }


    @AfterMethod
    public void tearDown (){
        BrowserUtils.wait(2);
        driver.quit();
    }

}
