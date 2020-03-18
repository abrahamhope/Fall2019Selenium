package com.automation.tests.practice;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationForm {
    private WebDriver driver;
    private String URL= "http://practice.cybertekschool.com/registration_form";
    private By firstNameBy = By.name("firstname");
    private By lastNameBy = By.name("lastname");
    private By usernameBy = By.name("username");
    private By emailBy = By.name("email");
    private By passwordBy = By.name("password");
    private By phoneBy = By.name("phone");
    private By birthdayBy = By.name("birthday");
    private By maleBy = By.cssSelector("input[value='male']");
    private By femaleBy = By.cssSelector("input[value='female']");
    private By otherBy = By.cssSelector("input[value='other']");
    private By departmentBy = By.name("department");
    private By jobTitleBy = By.name("job_title");

    private By cplusplusBy = By.xpath("//label[text()='C++']/preceding-sibling::input");
    private By javaBy = By.xpath("//label[text()='Java']/preceding-sibling::input");
    private By javascriptBy = By.xpath("//label[text()='JavaScript']/preceding-sibling::input");

    private By submitBtnBy = By.id("wooden_spoon");





    @Test
    public void test1(){

        driver.findElement(firstNameBy).sendKeys("isaac");
        driver.findElement(lastNameBy).sendKeys("hope");
        driver.findElement(usernameBy).sendKeys("ihoprede");
        driver.findElement(emailBy).sendKeys("ihope@cyber.com");
        driver.findElement(passwordBy).sendKeys("123sdghfs");
        driver.findElement(phoneBy).sendKeys("123-456-7890");
        driver.findElement(maleBy).click();
        driver.findElement(birthdayBy).sendKeys("01/01/2000");
        Select departmentSelect = new Select(driver.findElement(departmentBy));
        departmentSelect.selectByVisibleText("MPDC");
        Select jobTitleSelect = new Select(driver.findElement(jobTitleBy));
        jobTitleSelect.selectByVisibleText("SDET");
        driver.findElement(javaBy).click();
        driver.findElement(submitBtnBy).click();

        BrowserUtils.wait(4);

       String expected = "You've successfully completed registration!";
        String actual = driver.findElement(By.tagName("p")).getText();
        BrowserUtils.wait(4);

        Assert.assertEquals(actual, expected);


    }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
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
