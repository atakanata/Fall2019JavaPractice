package com.automation.tests.day4;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Warmup2 {
    public static void main(String[] args) throws InterruptedException {
        String str = new String("java");
        //WebDriver driver = new ChromeDriver()
        WebDriver driver = DriverFactory.createDriver("chrome");

        //driver.get("https://www.google.com/");
        //driver.findElement(By.name("q")).sendKeys("java book");
        //driver.get("https://www.facebook.com/");
        //driver.findElement(By.id("email")).sendKeys("atakanata");
        driver.get("https://www.google.com/search?sxsrf=ALeKk02Yd4kA8-bqq4XNZxfn0WopzHLahw%3A1583593863191&source=hp&ei=h7ljXo-kB8GWsQWzyb-gDA&q=hand+sanitizer&oq=hand+sanit&gs_l=psy-ab.3.0.0i131l10.803702.806540..808770...20.0..0.155.942.8j2......0....1..gws-wiz.....10..35i362i39j35i39j0j35i305i39.wzMmbBOdFPo");
        driver.findElement(By.name("q")).clear();


        Thread.sleep(3000);
        WebElement searchBox = driver.findElement(By.name("q"));


        driver.findElement(By.name("q")).sendKeys("Baska bir kelime");
        Thread.sleep(3000);

        driver.quit();





    }
}
