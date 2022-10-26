package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Driver {
    //this class singleton design pattern

    /*
    We make WebDriver private, because we want to close access from outside the class
    We make it static because we will use it in a static method.
    */
    private static WebDriver driver;

    /*
        Creating a private constructor so we are closing access
        to the object of this class from outside the class
     */

    private Driver() {
    }

    /*
    Create a re-usable utility method which will return same driver instance when we call it
     */
    public static WebDriver getDriver() {
        if (driver == null) {

            //I made such an adjustment because this website does not allow me to login
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.addArguments("--disable-notifications");
            //Setup chrome driver
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            //maximize window because some elements design might be change according to window dimension
            driver.manage().window().maximize();
            //implicitly wait for the element that is appearing on the web page
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
        return driver;
    }

    /*
    This method will make sure our driver value is always null after using quit() method
     */
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
