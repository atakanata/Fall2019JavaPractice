package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Xpath {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        BrowserUtils.wait(1);
        WebElement firstBttn = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/button[1]"));
        firstBttn.click();
        BrowserUtils.wait(1);
        String result = driver.findElement(By.id("result")).getText();

        if (result.equals("Clicked on button one!")){
            System.out.println("TEST 1 PASSED");
        }else{
            System.out.println("TEST 1 FAILED");
        }



        BrowserUtils.wait(2);
        driver.quit();
    }
}
