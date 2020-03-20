package com.automation.tests.day9;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionTests {
    private WebDriver driver;
    private Actions actions;

    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createWebDriver("chrome");
        actions=new Actions(driver);
    }

    @Test
    public void hoverOnImage(){
        driver.get("http://practice.cybertekschool.com/hovers");
        BrowserUtils.wait(3);

        WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));
        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
        WebElement img3 = driver.findElement(By.xpath("(//img)[3]"));

        // build is needed when you have a couple of actions
        // always end with perform()
        actions.moveToElement(img1).pause(1000).moveToElement(img2).
                pause(1000).moveToElement(img3).build().perform();

        actions.moveToElement(img1).perform();
        WebElement imgText1 = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        Assert.assertTrue(imgText1.isDisplayed());
    }

    @Test
    public void jqueryMenuTest(){
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        WebElement enable=driver.findElement(By.id("ui-id-3"));
        WebElement download = driver.findElement(By.id("ui-id-4"));
        WebElement pdf= driver.findElement(By.id("ui-id-5"));

        actions.moveToElement(enable).pause(1000).moveToElement(download).pause(1000).
                moveToElement(pdf).click().build().perform();

    }

    @Test
    public void dragAndDropTests(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        BrowserUtils.wait(5);
        WebElement moon=driver.findElement(By.id("draggable"));
        WebElement earth=driver.findElement(By.id("droptarget"));

        actions.dragAndDrop(moon,earth).perform();
        BrowserUtils.wait(3);

        String expected= "You did great!";
        String actual=earth.getText();

        Assert.assertEquals(actual,expected);
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
