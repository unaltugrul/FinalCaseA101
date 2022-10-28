package utilities;
import org.openqa.selenium.WebDriver;
import java.util.Set;

public class Browser {

    //I create switch window utility method
    public static void switchWindow(WebDriver driver, String expectedInUrl) {

        //I use Set because Set guarantees there is no duplicate object in it.
        Set<String> allWindowsHandles = driver.getWindowHandles();

        for (String each : allWindowsHandles) {
            driver.switchTo().window(each);
            if (driver.getCurrentUrl().contains(expectedInUrl)) {
                break;
            }
        }
    }

    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }
    }


}
