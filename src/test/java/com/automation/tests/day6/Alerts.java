package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alerts {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(1);

        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        buttons.get(0).click();
        BrowserUtils.wait(3);

        //System.out.println(button0Text);
        driver.switchTo().alert().accept();
        String button0Text = driver.findElement(By.id("result")).getText();
        if (button0Text.equals("You successfuly clicked an alert")){
            System.out.println("TEST 1 PASSED");
        }else{
            System.out.println("TEST 1 FAILED");
        }

        BrowserUtils.wait(3);
        buttons.get(1).click();
        driver.switchTo().alert().dismiss();
        BrowserUtils.wait(3);
        String button1Text = driver.findElement(By.id("result")).getText();
        //You clicked: Cancel
        if (button1Text.equals("You clicked: Cancel")){
            System.out.println("TEST 2 PASSED");
        }else{
            System.out.println("TEST 2 FAILED");
        }
        BrowserUtils.wait(3);
        buttons.get(2).click();
        Alert alert = driver.switchTo().alert();

              alert  .sendKeys("Cybertek");
        BrowserUtils.wait(3);
        alert.accept();
        String button2Text = driver.findElement(By.id("result")).getText();
        if (button2Text.endsWith("Cybertek")){
            System.out.println("TEST 3 PASSED");
        }else{
            System.out.println("TEST 3 FAILED");
        }

        BrowserUtils.wait(4);



        BrowserUtils.wait(1);
        driver.quit();

    }
}
