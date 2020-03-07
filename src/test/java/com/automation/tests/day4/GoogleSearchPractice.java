package com.automation.tests.day4;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPractice {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");

        driver.get("https://www.google.com/search?q=yes+m+systems&oq=yes+m+systems&aqs=chrome..69i57j0l5j69i60l2.2790j1j7&sourceid=chrome&ie=UTF-8");
        driver.findElement(By.name("q")).clear();
                driver.findElement(By.name("q")).sendKeys("SDET jobs");
    }
}
