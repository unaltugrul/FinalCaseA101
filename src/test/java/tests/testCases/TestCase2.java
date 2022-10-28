package tests.testCases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import tests.base.TestBase;
import utilities.Browser;
import utilities.LogLog;

import java.time.Duration;

public class TestCase2 extends TestBase {

    @Test
    public void testtwo() throws InterruptedException {

        driver.get("https://www.hepsiburada.com/");
        HomePage homePage = new HomePage(driver);

        ProductListPage productListPage = new ProductListPage(driver);

        ProductPage productPage = new ProductPage(driver);

        CartPage cartPage = new CartPage(driver);

        LoginPage loginPage = new LoginPage(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        LogLog logLog = new LogLog();

        Actions actions = new Actions(driver);


        String expectedResult = "Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com";
        String actualResult = driver.getTitle();
        Assert.assertEquals(expectedResult, actualResult);
        if (driver.getTitle().equals("Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com")) {
            logLog.info2("PASSED - User is on the home page...");
        } else {
            logLog.error2("FAILED - User is not on home page.");
        }
        //logger.info2("precondition is ending...");
        //2-user accepts cookies

        wait.until(ExpectedConditions.visibilityOf(homePage.cookiesAcceptButton));
        homePage.cookiesAcceptButton.click();

        //6-User enters product name to search box and press enter key
        logLog.info2("Step 1-User enters product name to search box and press enter key");
        String productName = "Yeni Başlayanlar İçin Java 10";
        homePage.searchBox.sendKeys(productName + Keys.ENTER);

        //7-User selects the product
        logLog.info2("Step 2-User selects the product");
        productListPage.productLink.click();

        //8-User adds product from two different seller
        logLog.info2("Step 3-User adds product from two different seller");
        Browser.switchWindow(driver, productName);

        for (WebElement eachSellerAddButton : productPage.sellerAddButtons) {
            eachSellerAddButton.click();
            Thread.sleep(1000);
        }

        //9-User clicks "sepete git" button
        logLog.info2("Step 4-User clicks \"sepete git\" button");
        wait.until(ExpectedConditions.visibilityOf(productPage.sepeteGitButton));
        productPage.sepeteGitButton.click();

        //10-Verify that correct product has been added correctly to cart
        logLog.info2("Step 5-Verify that correct product has been added correctly to cart");
        for (WebElement eachProductLink : cartPage.productLinks) {
            if (!eachProductLink.getText().contains(productName)) {
                logLog.error2("Product name is not matching it might be different product check it");
                Assert.assertTrue(false, "Product name is not matching it might be different product check it");
            } else {
                logLog.info2("PASSED - Product name is matching");
                Assert.assertTrue(true);
            }
        }

        if (cartPage.productLinks.size() != 2) {
            logLog.error2("Number of total product is not correct, check it.");
            Assert.assertTrue(false, "Number of total product should be 2 pcs. check it please.");
        } else {
            logLog.info2("PASSED - Number of total product is correct");
            Assert.assertTrue(true);
        }

        for (WebElement eachProductQuantity : cartPage.quantityOfProduct) {
            String quantityOfProduct = eachProductQuantity.getAttribute("value");
            if (!quantityOfProduct.equals("1")) {
                logLog.error2("quantity of product is not 1");
                Assert.assertTrue(false, "quantity of product is not 1");
            } else {
                logLog.info2("PASSED - quantity of product is 1");
            }
        }

        //This loop for cleaning the cart
        logLog.info2("Cart cleaning...");
        actions.moveToElement(cartPage.deleteAllLine).perform();
        while (true) {
            try {
                if (cartPage.deleteButton.isDisplayed()) {
                    cartPage.deleteButton.click();
                }
            } catch (Exception e) {
                break;
            }
            Thread.sleep(2000);
        }
        logLog.info2("Cart has been cleaned successfully!");


    }
}
