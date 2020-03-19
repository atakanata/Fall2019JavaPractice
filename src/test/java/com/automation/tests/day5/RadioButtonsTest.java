package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonsTest {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);
        WebElement blackBttn = driver.findElement(By.id("black"));

        if (blackBttn.isDisplayed()&&blackBttn.isEnabled()) {
            blackBttn.click();
        }
        if (blackBttn.isSelected()){
            System.out.println("============================");
            System.out.println("TEST PASSED");
        }else{
            System.out.println("=============================");
            System.out.println("TEST FAILED");
        }



    driver.quit();
    }
}
