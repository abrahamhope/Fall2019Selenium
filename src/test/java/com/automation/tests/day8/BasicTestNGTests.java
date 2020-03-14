package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicTestNGTests {

    @Test
    public void tests1(){
        String expected = "apple";
        String actual= "apple";
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void test2(){
        int num1=5;
        int num2=10;
        // it is called hard assertion.
        // if assertion fails, it stops the execution.
        Assert.assertTrue(num1>num2);
    }



}
