package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class PracticeTests {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://practice.cybertekschool.com/");
    }
    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }

    @Test
    public void loginTest(){

        driver.navigate().to("http://practice.cybertekschool.com/login");
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword", Keys.ENTER);
        String actual = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h4")).getText();
        driver.findElement(By.cssSelector("#content > div > h4"));
        Assert.assertEquals(actual, "Welcome to the Secure Area. When you are done click logout below.", "Subheader message is not matching!");
    }

    @Test
    public void forgotPasswordTest(){
        driver.navigate().to("http://practice.cybertekschool.com/forgot_password");
        driver.findElement(By.name("email")).sendKeys("atakanata@cybertek.com", Keys.ENTER);
        String actual = driver.findElement(By.tagName("h4")).getText();
        Assert.assertEquals(actual,"Your e-mail's been sent!");
    }
    @Test
    public void checkboxTest1(){
        driver.navigate().to("http://practice.cybertekschool.com/checkboxes");
        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));
                                                           //By.xpath //input[1]
        BrowserUtils.wait(1);
        checkboxes.get(0).click();
        BrowserUtils.wait(1);
        Assert.assertTrue(checkboxes.get(0).isSelected());
    }



}
