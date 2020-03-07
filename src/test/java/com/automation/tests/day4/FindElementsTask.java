package com.automation.tests.day4;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindElementsTask {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverFactory.createDriver("chrome");

        driver.get("http://practice.cybertekschool.com/");
        Thread.sleep(3000);
        List<WebElement> links =  driver.findElements(By.tagName("a"));
        for (WebElement link:links
             ) {
           // System.out.println(each.getText());
//            each.click();
//            Thread.sleep(2000);
//            driver.navigate().back();
//            links = driver.findElements(By.tagName("a"));
        }

        //List<String> weblinks = new ArrayList<>();
        for (int i = 1; i <links.size() -1; i++) {
            links.get(i).click();
            driver.navigate().back();
            links = driver.findElements(By.tagName("a"));
//            weblinks.add(links.get(i).getAttribute("href"));
//            //System.out.println(links.get(i).getAttribute("href") );
//            //driver.navigate().to(links.get(i).getAttribute("href"));
//            //driver.navigate().back();
////            Thread.sleep(2000);
////            driver.navigate().back();
////            Thread.sleep(2000);
//            //refresh list
        }
//        for (String weblink:weblinks
//             ) {
//            driver.navigate().to(weblink);
//            Thread.sleep(2000);
//        }

        driver.quit();




    }
}
