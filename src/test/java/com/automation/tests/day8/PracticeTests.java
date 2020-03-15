package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class PracticeTests {
  private  WebDriver driver;

  @Test
  public void loginTest(){
      driver.get("http://practice.cybertekschool.com/login");
      BrowserUtils.wait(3);
      driver.findElement(By.name("username")).sendKeys("tomsmith");
      driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
      driver.findElement(By.id("wooden_spoon")).click();
      WebElement message=driver.findElement(By.className("subheader"));
      Assert.assertTrue(message.getText().equalsIgnoreCase("Welcome to the Secure Area. When you are done click logout below."));
  }

  @Test
  public void forgotPasswordTest(){
      driver.findElement(By.linkText("Forgot Password")).click();
      driver.findElement(By.name("email")).sendKeys("hope@gsastl.org");
      driver.findElement(By.id("form_submit")).click();
      WebElement confirmation= driver.findElement(By.name("confirmation_message"));
      Assert.assertEquals(confirmation.getText(),"Your e-mail's been sent!");

  }

  @Test
  public void checkBoxesTest(){
      driver.findElement(By.linkText("Checkboxes")).click();
      List<WebElement> checkboxes= driver.findElements(By.tagName("input"));
      checkboxes.get(0).click();
      Assert.assertTrue(checkboxes.get(0).isSelected());
  }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        //INTERVIEW QUESTION: HOW TO HANDLE SSL ISSUES IN SELENIUM?
        // ChromeOptions - use to customize browser for tests
        ChromeOptions chromeOptions=new ChromeOptions();
        // to ignore "Your connection is not private issue"
        chromeOptions.setAcceptInsecureCerts(true);
        driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void quit(){
        driver.quit();
    }


}
