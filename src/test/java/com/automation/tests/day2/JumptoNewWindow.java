package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumptoNewWindow {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(5000);
        String windowHandle = driver.getWindowHandle();
        System.out.println(windowHandle);
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);

        driver.quit();


    }
}
