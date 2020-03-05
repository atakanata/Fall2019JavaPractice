package com.automation.tests.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/login");
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        Thread.sleep(3000);
        driver.findElement(By.id("wooden_spoon")).click();

        //lets click on logout button. it is a link text
        //WebElement logout = driver.findElement(By.linkText("Logout"));
        WebElement logout = driver.findElement(By.partialLinkText("out"));
        String href = logout.getAttribute("href");
        //driver.navigate().to(href);
        logout.click();
        Thread.sleep(2000);
        driver.findElement(By.name("username")).sendKeys("wrongUsername");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.id("wooden_spoon")).click();

        Thread.sleep(4000);
        driver.quit();
    }
}
