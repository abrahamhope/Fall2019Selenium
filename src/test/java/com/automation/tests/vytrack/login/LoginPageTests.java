package com.automation.tests.vytrack.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.*;

public class LoginPageTests {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }


    @AfterMethod
    public void tearDown(){
        // if WebDriver object alive,
        if(driver!=null){
            // close browser, close session
            driver.quit();
            // destroy driver object for sure.
            driver=null;
        }
    }


}
