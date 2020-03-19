package com.automation.tests.day10;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecuter {
    private RemoteWebDriver driver;

    @BeforeMethod
    public void setup(){
        //driver = DriverFactory.createDriver("chrome");
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
    }

    @Test
    public void scrollTest(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        driver.manage().window().maximize();
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //need to cast if driver is a WebDriver
        for (int i = 0; i < 10; i++) {
        // x and y coordinates
        //moves 500 pixels down
        driver.executeScript("window.scrollBy(0,500)");
        BrowserUtils.wait(1);
    }

    }

    @Test
    public void scrollToElementTest(){
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        driver.executeScript("arguments[0].scrollIntoView(true)",link);
        BrowserUtils.wait(2);
        link.click();
        BrowserUtils.wait(2);
//        driver.navigate().back();
//        BrowserUtils.wait(2);
    }

    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(3);
        driver.quit();
    }
}
