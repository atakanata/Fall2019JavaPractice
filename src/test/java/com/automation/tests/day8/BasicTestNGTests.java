package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTestNGTests {

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }

    @BeforeMethod
    public void setup(){
        System.out.println("Before Method");
    }

    @AfterMethod
    public void teardown(){
        System.out.println("After method");
    }

    @Test
    public void test1(){
        String expected = "apple";
        String actual = "apple";
        Assert.assertEquals(actual,expected);
        System.out.println("test-1");
    }
    @Test
    public void test2(){
        int num1 = 5;
        int num2 = 10;
        Assert.assertTrue(num1<num2);
        System.out.println("test-2");
    }


}
