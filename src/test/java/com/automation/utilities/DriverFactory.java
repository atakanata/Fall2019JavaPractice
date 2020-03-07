package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
//
//    @param browserName
//    @return new webdriver object
    public static WebDriver createDriver(String browserName){
        if (browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().version("79.0").setup();
            return new ChromeDriver();
        }else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }else{
            return new ChromeDriver();
        }
    }
}
