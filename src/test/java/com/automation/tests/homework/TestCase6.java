package com.automation.tests.homework;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TestCase6 {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();

    }

    @Test
    public void test6(){
        driver.get("https://www.tempmailaddress.com/");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
        String emailAddress = driver.findElement(By.id("email")).getText();

        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); //switches to new tab
        driver.get("https://practicecybertekschool.herokuapp.com");

        WebElement signUpForMailingList=driver.findElement(By.linkText("Sign Up For Mailing List"));
        signUpForMailingList.click();
        BrowserUtils.wait(2);
        WebElement fullName=driver.findElement(By.name("full_name"));
        fullName.sendKeys("Mike Johnson");
        WebElement email= driver.findElement(By.name("email"));
        email.sendKeys(emailAddress);
        WebElement signupBtn= driver.findElement(By.name("wooden_spoon"));
        signupBtn.click();

        WebElement signupMessage=driver.findElement(By.name("signup_message"));
        Assert.assertTrue(signupMessage.isDisplayed());

        driver.switchTo().window(tabs.get(0)); // switch back to main screen
        WebElement mailBox = driver.findElement(By.xpath("//*[@id=\"schranka\"]/tr[1]/td[1]/text()"));
        Assert.assertTrue(mailBox.getText().contains("do-not-reply@practice.cybertekschool.com"));
    }



    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
