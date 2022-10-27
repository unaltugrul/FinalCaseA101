package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

public class Browser {

    //I create switch window utility method
    public static void switchWindow(WebDriver driver, String expectedInUrl) {

        //I use Set because Set guarantees there is no duplicate object in it.
        Set<String> allWindowsHandles = driver.getWindowHandles();

        for (String each : allWindowsHandles) {
            driver.switchTo().window(each);
            System.out.println("Current URL: " + driver.getCurrentUrl());
            if (driver.getCurrentUrl().contains(expectedInUrl)) {
                break;
            }
        }
    }
}
