package com.automation.tests.day4;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Warmup1 {
    public static void main(String[] args) {
        //ebayTest("java book");
        searchAmazon("java book");



    }

    static WebDriver driver;

    static void ebayTest(String searchKey){
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://www.ebay.com/");
        driver.findElement(By.id("gh-ac")).sendKeys(searchKey, Keys.ENTER);
        String resultCount = driver.findElement(By.tagName("h1")).getText().split(" ")[0];
        System.out.println(searchKey+" showed up "+resultCount+" times");
        driver.quit();
    }
    static void searchAmazon (String searchKey){
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchKey,Keys.ENTER);
        String resultTitle = driver.getTitle();
        if (resultTitle.contains(searchKey)){
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }

        driver.quit();
    }

}
