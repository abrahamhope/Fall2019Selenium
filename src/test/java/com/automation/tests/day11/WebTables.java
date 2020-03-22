package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WebTables {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        ChromeOptions chromeOptions =new ChromeOptions();
        chromeOptions.setHeadless(true); // to run browser without UI. Makes browser invisible
        // headless mode makes execution twice faster
        driver=new ChromeDriver(chromeOptions);

        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
    }

    @Test
    public void getColumnNames() {
           //th - represents table header cells
    List<String> expected = Arrays.asList("Last Name", "First Name", "Email", "Due", "Web Site", "Action");
    List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));
    for (WebElement columnName : columnNames) {
        System.out.println(columnName.getText());
    }
    Assert.assertEquals(BrowserUtils.getTextFromWebElements(columnNames), expected);
    }

    @Test
    public void verifyRowCount(){
        // //tbody//tr - to get all rows from the table body, excluding table header
        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody//tr"));

        Assert.assertEquals(rows.size(),4);
    }

    @Test
    public void deleteRecordTest (){
        String deleted = "jsmith@gmail.com";
        WebElement deleteLink= driver.findElement(By.xpath("//table[2]//td[text()='jsmith@gmail.com']//following-sibling::td/a[text()='delete']"));
        deleteLink.click();
        BrowserUtils.wait(3);

//        List<String> emails =driver.findElements(By.xpath("//table[@id='table1']/tbody//td[3]"))
//                .stream().map(each -> each.getText()).collect(Collectors.toList());
//        Assert.assertFalse(emails.contains(deleted));

        List<WebElement> rows = driver.findElements(By.xpath("//table[2]//tbody//tr"));
        Assert.assertEquals(rows.size(),3);

        List<WebElement> emails = driver.findElements(By.xpath("//table[2]//td[text()='jsmith@gmail.com']"));
        Assert.assertTrue(emails.isEmpty());
    }


    /*
    To get specific column, skip row index and just provide td index
     */
    @Test
    public void getSpecificColumn(){
        // td[5] - column with links
       List<WebElement> links = driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));

        System.out.println(BrowserUtils.getTextFromWebElements(links));
    }

    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(3);
        driver.quit();
    }


}

