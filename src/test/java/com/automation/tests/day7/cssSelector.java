package com.automation.tests.day7;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class cssSelector {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        BrowserUtils.wait(3);
        WebElement heading = driver.findElement(By.cssSelector(".h3"));
        //.nav-link
        WebElement btn1 = driver.findElement(By.cssSelector("[onclick=\"button1()]"));




    }
}
