package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests {
    private WebDriver driver;
    @Test
    public void googleSearchTest(){
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
        BrowserUtils.wait(2);
        //since every search item has a tag name <h3>
        //it's the easiest way to collect all of them
        List<WebElement> searchItems = driver.findElements(By.tagName("h3"));
        for(WebElement searchItem: searchItems){
            //System.out.println(searchItem.getText());
            String var = searchItem.getText();
            if (!var.isEmpty()){
                System.out.println(var);
                Assert.assertTrue(var.toLowerCase().contains("java"));
            }
        }
    }

//    @Test
////    public void amazonSearchTest(){
////        driver.get("https://www.amazon.com/");
////        BrowserUtils.wait(1);
////        driver.manage().window().maximize();
////        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java", Keys.ENTER);
////        BrowserUtils.wait(2);
////        List<WebElement> searchItems = driver.findElements(By.xpath("//h2//a"));
////        searchItems.get(0).click();
////        BrowserUtils.wait(2);
////
////        driver.findElement(By.id("a-autoid-5-announce")).click();
////        BrowserUtils.wait(2);
////
////        WebElement productTitle = driver.findElement(By.id("productTitle"));
////        String productTitleStr = productTitle.getText();
////        Assert.assertTrue(productTitleStr.toLowerCase().contains("java"));
////
////    }

    @BeforeMethod
    public void setup(){
        //setup webdriver
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void teardown(){
        //close browser and destroy webdriver object
        driver.quit();
    }
}
