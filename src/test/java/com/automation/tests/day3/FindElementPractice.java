package com.automation.tests.day3;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElementPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement full_name = driver.findElement(By.name("full_name"));
        //Thread.sleep(3000);
        full_name.sendKeys("Mahmut");
        Thread.sleep(2000);
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("mahmut@cybertek.com");
        Thread.sleep(2000);
        WebElement signUpButton = driver.findElement(By.name("wooden_spoon"));
        signUpButton.click();
        WebElement nextPageText = driver.findElement(By.tagName("h3"));
        String expectedText = "thank you for signing up.";
        String actualText = nextPageText.getText();
        if (actualText.toLowerCase().contains(expectedText)){
            System.out.println("Test passed");
            System.out.println(actualText);
        }else{
            System.out.println("test Failed");
        }

        driver.quit();


    }
}
