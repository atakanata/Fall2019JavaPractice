package com.automation.tests.vytrack.login;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//STATIC IMPORT OF ALL ASSERTIONS
import static org.testng.Assert.*;

public class LoginPageTests {
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


    @Test(description = "Verify that warning message displays when user enters invalid username")
    public void invalidUsername(){
        driver.findElement(usernameBy).sendKeys("invalidusername_user39");
        driver.findElement(passwordBy).sendKeys("UserUser123", Keys.ENTER);
        BrowserUtils.wait(5);
        WebElement warningElement = driver.findElement(warningMessageBy);
        assertTrue(warningElement.isDisplayed());
    }

    @Test(description = "Verify that truck driver can login")
    public void validUsernameTruckDriver(){
        driver.findElement(usernameBy).sendKeys("user39");
        driver.findElement(passwordBy).sendKeys("UserUser123", Keys.ENTER);
        BrowserUtils.wait(7);
        //Select Fleet = new Select(driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span")) );
        //Fleet.selectByVisibleText("Vehicle Costs");
        String vehicleCosts = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/div/div/ul/li[5]/a")).getAttribute("href");
        driver.navigate().to(vehicleCosts);
        BrowserUtils.wait(5);
        assertTrue(driver.findElement(By.linkText("Vehicle Costs")).isDisplayed());
    }

    @Test(description = "login as store manager and verify that title equals to Dashboard")
    public void loginAsStoreManager(){
        driver.findElement(usernameBy).sendKeys(storeManagerUsername);
        driver.findElement(passwordBy).sendKeys(storeManagerPassword,Keys.ENTER);
        BrowserUtils.wait(5);

        String expected = "Dashboard";
        String actual = driver.getTitle();

        assertEquals(actual,expected, "Page title is not correct!");

    }


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
}