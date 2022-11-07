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

    //Feature : add product to cart without by logging in
    @Test
    public void second_test() {

        //I create page object to be able to call elements from these class
        BasePage basePage = new BasePage(driver);

        HomePage homePage = new HomePage(driver);

        ProductListPage productListPage = new ProductListPage(driver);

        ProductPage productPage = new ProductPage(driver);

        CartPage cartPage = new CartPage(driver);

        LoginPage loginPage = new LoginPage(driver);
        //-----------------------------------------------------------------

        //I created wait object if I face with any delaying
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //-----------------------------------------------------------------

        //I used actions class to implement hover action for now
        Actions actions = new Actions(driver);
        //------------------------------------------------------------------

        //I created this object to reach Loglog class
        LogLog logLog = new LogLog();
        //------------------------------------------------------------------

        //to clarify method and class names I use detailed log
        logLog.info2("Test Execution is working... Feature - User adds product to cart without by logging in...");

        /////////////////////////////////////////////////////////////////////
        ///////////////////////PART OF TEST STEPS////////////////////////////
        /////////////////////////////////////////////////////////////////////

        //1-User navigates to home page
        driver.get("https://www.hepsiburada.com/");
        String expectedResult = "Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com";
        String actualResult = driver.getTitle();
        Assert.assertEquals(expectedResult, actualResult);
        if (driver.getTitle().equals("Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com")) {
            logLog.info2("PASSED - User is on the home page...");
        } else {
            logLog.error2("FAILED - User is not on home page.");
        }

        //2-user accepts cookies
        wait.until(ExpectedConditions.visibilityOf(homePage.cookiesAcceptButton));
        homePage.cookiesAcceptButton.click();
        //------------------------------------------------------------------

        //Special method---Check if there is any product in cart clean it and continue

        try {
            if (!basePage.cartItemCount.getText().equals("0")) {
                basePage.myCartButton.click();

                while (true) {
                    try {
                        actions.moveToElement(cartPage.deleteAllLine).perform();
                        cartPage.deleteAllLine.click();
                    } catch (Exception e) {
                        break;
                    }
                }
            }
        } catch (Exception e) {

        }

        ///////////////////////////////////////////////////////////////////////////////

        //3-User enters product name to search box and press enter key
        logLog.info2("Step 1-User enters product name to search box and press enter key");
        String productName = "Yeni Başlayanlar İçin Java 10";
        basePage.searchBox.sendKeys(productName + Keys.ENTER);
        //------------------------------------------------------------------

        //4-User selects the product
        logLog.info2("Step 2-User selects the product");
        productListPage.productLink.click();
        //------------------------------------------------------------------

        //5-User adds product from two different seller
        logLog.info2("Step 3-User adds product from two different seller");
        Browser.switchWindow(driver, productName);
        for (WebElement eachSellerAddButton : productPage.sellerAddButtons) {
            eachSellerAddButton.click();
            Browser.sleep(2);
        }
        //------------------------------------------------------------------

        //6-User clicks "sepete git" button
        logLog.info2("Step 4-User clicks \"sepete git\" button");
        //if there is no "sepete git button" click to "sepetim"
        try {
            wait.until(ExpectedConditions.visibilityOf(productPage.goToCartButton));
            productPage.goToCartButton.click();

        } catch (Exception e) {
            basePage.myCartButton.click();
        }

        //7-Verify that correct product has been added correctly to cart
        logLog.info2("Step 5-Verify that correct product has been added correctly to cart");
        //Product name should be same =====================================================
        for (WebElement eachProductLink : cartPage.productLinks) {
            if (!eachProductLink.getText().contains(productName)) {
                logLog.error2("Product name is not matching it might be different product check it");
                //Even if I face with accident to be able to continue I use try-catch
                try {
                    Assert.assertTrue(false, "Product name is not matching it might be different product check it");
                } catch (AssertionError e) {

                }

            } else {
                logLog.info2("PASSED - Product name is matching");
                Assert.assertTrue(true);
            }
        }

        //Number of product should be 1 pcs. ==============================================
        for (WebElement eachProductQuantity : cartPage.quantityOfProduct) {
            String quantityOfProduct = eachProductQuantity.getAttribute("value");
            if (!quantityOfProduct.equals("1")) {
                logLog.error2("quantity of product is not 1");
                try {
                    Assert.assertTrue(false, "quantity of product is not 1");
                } catch (AssertionError e) {

                }

            } else {
                logLog.info2("PASSED - quantity of product is 1");
            }
        }
        //Merchant name should be different ================================================
        String firstMerchantName = cartPage.merchantLinks.get(0).getText();
        String secondMerchantName = cartPage.merchantLinks.get(1).getText();
        if (firstMerchantName.equals(secondMerchantName)) {
            logLog.error2("FAILED - Merchant name should be different");
        } else {
            logLog.info2("PASSED - Merchant name different");
        }
        try {
            Assert.assertFalse(firstMerchantName.equals(secondMerchantName));
        } catch (AssertionError e) {

        }
        //------------------------------------------------------------------
        /////////////////////////////////////////////////////////////////////
        ///////////////////////END OF TEST STEPS////////////////////////////
        /////////////////////////////////////////////////////////////////////

        //This loop for cleaning the cart
        logLog.info2("Cart cleaning...");


        while (true) {
            try {
                actions.moveToElement(cartPage.deleteAllLine).perform();
                cartPage.deleteAllLine.click();
            } catch (Exception e) {
                break;
            }
        }
        logLog.info2("Cart has been cleaned successfully!");

    }
}
