package com.automation.tests.Warmup;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUpload {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/upload");
        BrowserUtils.wait(3);
        String filePath = "C:/Users/Dora/Downloads/XPATH cheat sheet.pdf";
        driver.findElement(By.id("file-upload")).sendKeys(filePath);
        driver.findElement(By.id("file-submit")).click();
        BrowserUtils.wait(2);

        String resultText = driver.findElement(By.id("uploaded-files")).getText().toLowerCase();
        if (resultText.contains("xpath cheat sheet")){
            System.out.println("upload test passed");
        }else{
            System.out.println("upload test failed");
        }



        BrowserUtils.wait(5);
        driver.quit();
    }
}
