package com.automation.tests.Warmup;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownMenuPractice {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(1);

        Select state = new Select(driver.findElement(By.id("state")));

        List<WebElement> stateOptions = state.getOptions();

        for (WebElement each :stateOptions
             ) {
            System.out.println(each.getText());
        }

        state.selectByVisibleText("Georgia");
        BrowserUtils.wait(2);

        if (state.getFirstSelectedOption().getText().equals("Georgia")){
            System.out.println("GA TEST PASSED");
        }else{
            System.out.println("GA TEST FAILED");
        }

        Select languages = new Select(driver.findElement(By.name("Languages")));
        List<WebElement> languageOptions = languages.getOptions();

        for (WebElement each:languageOptions
             ) {
            if (each.getText().toLowerCase().contains("java")&& !each.isSelected()){
                each.click();
                System.out.println(each.getText());
            }else {
                System.out.println(each+" not selected");
            }
        }
BrowserUtils.wait(2);
        WebElement linkDropDown = driver.findElement(By.id("dropdownMenuLink"));
        linkDropDown.click();
        BrowserUtils.wait(2);
        driver.findElement(By.linkText("Yahoo")).click();



    //driver.quit();

    }
}
