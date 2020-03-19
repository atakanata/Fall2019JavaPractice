package com.automation.tests.vytrack.fleet;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class VehicleCosts {
    private WebDriver driver;
    //https is a secured version of http protocol
    //http - it's hypertext transfer protocol that every single website is using now days
    //https - data encrypted, no chance for hackers to retrieve info
    //http - data as a plain text, very easy to hack it
    private String URL = "https://qa2.vytrack.com/user/login";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    // > in css selector means same thing as / in xpath - direct child
    private By warningMessageBy = By.cssSelector("[class='alert alert-error'] > div");
    private String storeManagerUsername = "storemanager77";
    private String storeManagerPassword = "UserUser123";

    //truck driver 1
    private String truckDriverUsername1 = "user39";
    private String TruckDriverPassword1 = "UserUser123";

    //truck driver 2

    private By subtitleBy = By.className("oro-subtitle");
    private By fleetBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Fleet')]");

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        //if webdriver object alive
        if (driver != null) {
            //close browser, close session
            driver.quit();
            //destroy webdriver object for sure
            driver = null;
        }
    }

    @Test
    public void verifyPageSubTitle(){
        driver.findElement(usernameBy).sendKeys(truckDriverUsername1);
        driver.findElement(passwordBy).sendKeys(TruckDriverPassword1,Keys.ENTER);
        //put more wait here as well, if didn't click
        BrowserUtils.wait(5);
        //click on fleet
        driver.findElement(fleetBy);//.click();
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(fleetBy)).perform();

        BrowserUtils.wait(2);
        //click on Vehicles
        driver.findElement(By.linkText("Vehicle Costs")).click();
        //put more wait time if you are getting Cars, Dashboard...
        //this application is slooooow...
        BrowserUtils.wait(7);
        //find subtitle element
        WebElement subTitleElement = driver.findElement(subtitleBy);
        System.out.println(subTitleElement.getText());
        assertEquals(subTitleElement.getText(),"Vehicle Costs");
    }
}