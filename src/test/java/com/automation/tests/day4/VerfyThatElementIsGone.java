package com.automation.tests.day4;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class VerfyThatElementIsGone {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        Thread.sleep(2000);
        driver.findElement(By.id("disappearing_button")).click();
        Thread.sleep(2000);

        if (driver.findElements(By.id("disappearing_button")).size()==0){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }

        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        for (WebElement button:buttons
             ) {
            button.click();
            Thread.sleep(1000);
        }

        driver.quit();


    }
}
