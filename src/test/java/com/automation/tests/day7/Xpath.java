package com.automation.tests.day7;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Xpath {
    public static String userNameLocator = "//label[text()='Username']/following-sibling::input";
    public static String userPasswordLocator = "//label[text()='Password']/following-sibling::input";
    public static String submitButton = "//button[contains(text(), 'Login')]";
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");
        BrowserUtils.wait(3);
        driver.findElement(By.xpath(userNameLocator)).sendKeys("tomsmith");
        driver.findElement(By.xpath(userPasswordLocator)).sendKeys("password");
        driver.findElement(By.xpath(submitButton)).click();



        BrowserUtils.wait(2);
        driver.quit();

    }
}
