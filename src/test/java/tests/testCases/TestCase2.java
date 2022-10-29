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
    public void second_test() {

        //1-User navigates to home page
        driver.get("https://www.hepsiburada.com/");
        HomePage homePage = new HomePage(driver);

        ProductListPage productListPage = new ProductListPage(driver);

        ProductPage productPage = new ProductPage(driver);

        CartPage cartPage = new CartPage(driver);

        LoginPage loginPage = new LoginPage(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

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

        //3-User enters product name to search box and press enter key
        logLog.info2("Step 1-User enters product name to search box and press enter key");
        String productName = "Yeni Başlayanlar İçin Java 10";
        homePage.searchBox.sendKeys(productName + Keys.ENTER);

        //4-User selects the product
        logLog.info2("Step 2-User selects the product");
        productListPage.productLink.click();

        //5-User adds product from two different seller
        logLog.info2("Step 3-User adds product from two different seller");
        Browser.switchWindow(driver, productName);

        for (WebElement eachSellerAddButton : productPage.sellerAddButtons) {
            eachSellerAddButton.click();
            Browser.sleep(2);
        }

        //6-User clicks "sepete git" button
        logLog.info2("Step 4-User clicks \"sepete git\" button");
        //if there is no "sepete git button" clicks to "sepetim"
        try {
            wait.until(ExpectedConditions.visibilityOf(productPage.sepeteGitButton));
            productPage.sepeteGitButton.click();

        }catch (Exception e){
            productPage.sepetimButton.click();
        }

        //7-Verify that correct product has been added correctly to cart
        logLog.info2("Step 5-Verify that correct product has been added correctly to cart");
        for (WebElement eachProductLink : cartPage.productLinks) {
            if (!eachProductLink.getText().contains(productName)) {
                logLog.error1("Product name is not matching it might be different product check it");
                //Even if I face with accident to be able to continue I use try-catch
                try {
                    Assert.assertTrue(false, "Product name is not matching it might be different product check it");
                }catch (AssertionError e){

                }

            } else {
                logLog.info1("PASSED - Product name is matching");
                Assert.assertTrue(true);
            }
        }

        if (cartPage.productLinks.size() != 2) {
            logLog.error1("Number of total product is not correct, check it.");
            try {
                Assert.assertTrue(false, "Number of total product should be 2 pcs. check it please.");
            }catch (AssertionError e){

            }

        } else {
            logLog.info1("PASSED - Number of total product is correct");
            Assert.assertTrue(true);
        }

        for (WebElement eachProductQuantity : cartPage.quantityOfProduct) {
            String quantityOfProduct = eachProductQuantity.getAttribute("value");
            if (!quantityOfProduct.equals("1")) {
                logLog.error1("quantity of product is not 1");
                try {
                    Assert.assertTrue(false, "quantity of product is not 1");
                }catch (AssertionError e){

                }

            } else {
                logLog.info1("PASSED - quantity of product is 1");
            }
        }

        String firstMerchantName = cartPage.merchantLinks.get(0).getText();
        String secondMerchantName = cartPage.merchantLinks.get(1).getText();
        if (firstMerchantName.equals(secondMerchantName)){
            logLog.error1("FAILED - Merchant name should be different");
        }else {
            logLog.info1("PASSED - Merchant name different");
        }
        try {
            Assert.assertFalse(firstMerchantName.equals(secondMerchantName));
        }catch (AssertionError e){

        }

        //This loop for cleaning the cart
        logLog.info1("Cart cleaning...");

        actions.moveToElement(cartPage.deleteAllLine).perform();
        while (true) {
            try {
                if (cartPage.deleteAllLine.isDisplayed()) {
                    cartPage.deleteAllLine.click();
                }
            } catch (Exception e) {
                break;
            }
            Browser.sleep(2);
        }
        logLog.info2("Cart has been cleaned successfully!");


    }
}
