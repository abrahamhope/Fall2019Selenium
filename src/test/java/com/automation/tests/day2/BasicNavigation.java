package com.automation.tests.day2;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws InterruptedException {
        // to start selenium script we need to:
        // setup webdriver and create webdriver object
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        // in selenium, everything start from WebDriver
        driver.get("http://google.com"); // to open a website
        Thread.sleep(3000);
        String title = driver.getTitle(); // returns <title> Some title</title>
        String expectedTitle="Google";

        System.out.println("WebPage Title is: "+title);
        if(expectedTitle.equals(title)){
            System.out.println("TEST PASSED!");
        }else{
            System.out.println("TEST FAILED!");
        }


        driver.close(); // to close the driver

    }
}
