package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeDriver driver = new ChromeDriver();

        driver.get("http://google.com");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.navigate().to("https://www.amazon.com/");
        driver.navigate().back();
        //driver.navigate().forward();
        driver.navigate().refresh();

        String title = driver.getTitle();
        String expectedtitle = "Google";

        System.out.println("Title is "+title);
        if (title.equalsIgnoreCase(expectedtitle)){
            System.out.println("google Test passed");
            }else{
            System.out.println("google Test failed");
        }
        driver.navigate().to("https://www.amazon.com/");
Thread.sleep(1000);
String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        if (driver.getTitle().toLowerCase().contains("amazon")){
            System.out.println("amazon test passed");
        }else{
            System.out.println("amazon test failed");
        }

driver.close();

    }
}
