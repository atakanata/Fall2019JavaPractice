package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RadioMethods {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");

        driver.get("http://practice.cybertekschool.com/radio_buttons");
        BrowserUtils.wait(3);

        List<WebElement> radioBttns = driver.findElements(By.tagName("input"));
        for (WebElement radio:radioBttns
             ) {

            String id = radio.getAttribute("id");
            boolean isSelected = radio.isSelected();
            System.out.println(id+" is selected? :"+isSelected);

            if (radio.isEnabled()) {
                radio.click();
                System.out.println("clicked on "+radio.getAttribute("id"));
                BrowserUtils.wait(1);
            }else{
                System.out.println("NOT clicked "+ radio.getAttribute("id"));
            }
        }


        driver.quit();

    }
}
