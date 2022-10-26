package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Driver {
    //I used static Webdriver because i am gonna add this attribute to static method
    static WebDriver driver;

    /*
    I create getDrive method just for clean code, to be able to call with class name this method I used static
     */
    public static WebDriver getDriver() {
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
        return driver;
    }

}
