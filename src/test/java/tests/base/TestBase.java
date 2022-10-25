package tests.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

    @BeforeMethod
    public void setupMethod() {
        logger.info(new Object(){}.getClass().getEnclosingMethod().getName() + ": new case is starting");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.hepsiburada.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        logger.info(new Object(){}.getClass().getEnclosingMethod().getName() + ": end of this case");
    }



}
