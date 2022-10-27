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
import pages.*;
import utilities.Driver;

import java.time.Duration;


public class TestBase {

    //public driver field to be able to inherit

    //I created logger attribute object for logging my project
    Logger logger = Logger.getLogger(TestBase.class);

    //This constructor for logging configuration
    public TestBase() {
        DOMConfigurator.configure("log4j.xml");
    }

    //I create page object to be able to call elements from these class
    public HomePage homePage = new HomePage();

    public LoginPage loginPage = new LoginPage();

    public ProductListPage productListPage = new ProductListPage();

    public ProductPage productPage = new ProductPage();

    public CartPage cartPage = new CartPage();

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
        logger.fatal(new Object() {
        }.getClass().getEnclosingMethod().getName() + ": precondition is starting");
        //1-User navigates to Web Page
        logger.info("User is landing to home page...");
        Driver.getDriver().get("https://www.hepsiburada.com/");
        String expectedResult = "Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com";
        String actualResult = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedResult,actualResult);
        if (Driver.getDriver().getTitle().equals("Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com")) {
            logger.info("PASSED - User is on the home page...");
        } else {
            logger.error("FAILED - User is not on home page.");
        }
        logger.info("precondition is ending...");
        //2-user accepts cookies
        homePage.cookiesAcceptButton.click();

        logger.info("Test execution has started...");

    }

    //teardown method for
    @AfterMethod
    public void tearDown() {
        //Driver.getDriver().close();
        logger.info("driver is closing...");
    }

    @AfterClass
    public void message2() {
        logger.info("End of the Test Case! Hopefully we will see each other again...");
        Driver.getDriver().quit();

    }


}
