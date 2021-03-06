package com.automation.tests.warmUp;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class verifySortedByLastName {
  private WebDriver driver;

  @BeforeMethod
    public void setup(){
      driver = DriverFactory.createWebDriver("chrome");
      driver.get("http://practice.cybertekschool.com/tables");
      driver.manage().window().maximize();
      BrowserUtils.wait(2);
  }
@Test
public void verifySortedLastName(){
    WebElement lastName = driver.findElement(By.xpath("//table[1]/thead/tr/th[1]"));
    lastName.click();
//    List<String> lastNamesActual = driver.findElements(By.xpath("//table[1]/tbody/tr/td[1]")).
//            stream().map(each -> each.getText()).collect(Collectors.toList());
//
//    List<String> lastNamesExpected = driver.findElements(By.xpath("//table[1]/tbody/tr/td[1]")).
//            stream().map(each -> each.getText()).collect(Collectors.toList());
//
//    Collections.sort(lastNamesExpected);
//
//    Assert.assertEquals(lastNamesActual,lastNamesExpected);
/**
 * Go to http://practice.cybertekschool.com/tables
 * Click on "Last name" column name
 * Verify that table is sorted by last name in alphabetic order.
 *
 * The Java String compareTo() method is used for comparing two strings lexicographically.
 * Each character of both the strings is converted into a Unicode value for comparison.
 * If both the strings are equal then this method returns 0 else it returns positive or negative value.
 * The result is positive if the first string is lexicographically greater than
 * the second string else the result would be negative.
 *
 *  This method is coming from Comparable interface.
 *  If you want ot be able to sort collection of some class
 *  you need to implement this interface
 *  and override compareTo method
 *
 "a".compareTo("b") = -1
 61 - 62 = -1
 a is before b
 "a".compareTo("a")
 61 - 61 = 0
 0 means 2 strings are equals
 *
 */


    List<WebElement> column= driver.findElements(By.xpath("//table[1]/tbody/tr/td[1]"));

    for (int i = 0; i < column.size() - 1; i++) {
        String value= column.get(i).getText();
        String nextValue=column.get(i+1).getText();

        Assert.assertTrue(value.compareTo(nextValue) <=0);
    }



}


  @AfterMethod
    public void tearDown(){
      driver.quit();
  }

}
