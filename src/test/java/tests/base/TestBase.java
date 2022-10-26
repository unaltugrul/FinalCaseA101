package tests.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utilities.Driver;

import java.time.Duration;


public class TestBase {

    //public driver field to be able to inherit
    public WebDriver driver = Driver.getDriver();

    //I created logger attribute object for logging my project
    Logger logger = Logger.getLogger(TestBase.class);

    //This constructor for logging configuration
    public TestBase() {
        DOMConfigurator.configure("log4j.xml");
    }

    //I wanted sending to console a message before starting
    @BeforeClass
    public void message() {
        logger.info("Welcome to my framework Tests is starting!...");
    }

    //I have 2 test case and both test steps start with same scenario because of that I used these steps as precondition
    //1- Users add product to chart by logging in
    //2- Users add product to chart without by logging in
    //Background//Precondition
    @BeforeMethod
    public void setupMethod() {
        logger.info(new Object() {
        }.getClass().getEnclosingMethod().getName() + ": new case is starting");
        //1-User navigates to Web Page
        logger.info("User is landing to home page...");
        driver.get("https://www.hepsiburada.com/");
        Assert.assertTrue(driver.getTitle().equals("Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com"));
        if (driver.getTitle().equals("Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com")) {
            logger.info("PASSED - User is on the home page...");
        } else {
            logger.error("FAILED - User is not on home page.");
        }
        //2-user accepts cookies
        driver.findElement(By.xpath("//div[@class='ot-sdk-row']//button[@id='onetrust-accept-btn-handler']")).click();

    }

    //teardown method for
    @AfterMethod
    public void tearDown() {
        //driver.quit();
        logger.info(new Object() {
        }.getClass().getEnclosingMethod().getName() + ": end of this case, driver is closing...");
    }


}
