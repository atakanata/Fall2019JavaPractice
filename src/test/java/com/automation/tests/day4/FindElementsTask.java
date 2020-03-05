package com.automation.tests.day4;

import com.automation.utilities.DriverFactory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindElementsTask {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverFactory.createDriver("chrome");

        driver.get("http://practice.cybertekschool.com/");
        Thread.sleep(3000);
        List<WebElement> links =  driver.findElements(By.tagName("a"));
        for (WebElement each:links
             ) {
            System.out.println(each.getText());
        }

        driver.quit();




    }
}
