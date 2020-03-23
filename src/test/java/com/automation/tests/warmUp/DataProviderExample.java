package com.automation.tests.warmUp;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {
    private WebDriver driver;

    @Test(description = "verify page title", dataProvider = "testData")
    public void tests(String url, String title){
        driver= DriverFactory.createWebDriver("chrome");
        driver.get(url);
        Assert.assertTrue(driver.getTitle().contains(title));
        driver.quit();
    }

    @DataProvider
    public Object[][] testData(){
        return new Object[][]{  {"http://google.com","Google"},
                                {"http://amazon.com", "Amazon"},
                                {"http://etsy.com", "Etsy"},
                                {"http://ebay.com", "Ebay"}};

    }
}
