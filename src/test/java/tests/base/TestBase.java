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

import java.time.Duration;


public class TestBase {

    public WebDriver driver;
    Logger logger = Logger.getLogger(TestBase.class);

    public TestBase(){
        DOMConfigurator.configure("log4j.xml");
    }

    @BeforeClass
    public void message(){
        logger.info("Welcome to my framework Tests is starting!...");
    }

    //Background//Precondition
    @BeforeMethod
    public void setupMethod() {
        logger.info(new Object(){}.getClass().getEnclosingMethod().getName() + ": new case is starting");
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--incognito");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //1-User navigates to Web Page
        logger.info("User is landing to home page...");
        driver.get("https://www.hepsiburada.com/");
        Assert.assertTrue(driver.getTitle().equals("Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com"));
        if (driver.getTitle().equals("Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com")){
            logger.info("PASSED - User is on the home page...");
        }else {
            logger.error("FAILED - User is not on home page.");
        }
        //2-user accepts cookies
        driver.findElement(By.xpath("//div[@class='ot-sdk-row']//button[@id='onetrust-accept-btn-handler']")).click();

    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
        logger.info(new Object(){}.getClass().getEnclosingMethod().getName() + ": end of this case");
    }



}
