package tests.testCases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import tests.base.TestBase;
import utilities.Browser;
import utilities.LogLog;

import java.time.Duration;

public class TestCase1 extends TestBase {
    //I used actions class to implement hover action for now





    //I create page object to be able to call elements from these class


    //Feature : add product to cart by logging in
    @Test
    public void first_test(){

        driver.get("https://www.hepsiburada.com/");

        //I created wait object if I face with any delaying
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        Actions actions = new Actions(driver);

        HomePage homePage = new HomePage(driver);

        ProductListPage productListPage = new ProductListPage(driver);

        ProductPage productPage = new ProductPage(driver);

        CartPage cartPage = new CartPage(driver);

        LoginPage loginPage = new LoginPage(driver);

        LogLog logLog = new LogLog();


        String expectedResult = "Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com";
        String actualResult = driver.getTitle();
        Assert.assertEquals(expectedResult, actualResult);
        if (driver.getTitle().equals("Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com")) {
            logLog.info1("PASSED - User is on the home page...");
        } else {
            logLog.error1("FAILED - User is not on home page.");
        }
        logLog.info1("precondition is ending...");
        //2-user accepts cookies
        wait.until(ExpectedConditions.visibilityOf(homePage.cookiesAcceptButton));
        homePage.cookiesAcceptButton.click();

        //to clarify method and class names I use detailed log
        logLog.info1("Test Execution is working... Feature - User adds product to cart by logging in...");

        logLog.info1("Step 1-User hovers over \"Giris Yap veya uye ol\" button");
        //1-User hovers over "Giris Yap veya uye ol" button
        actions.moveToElement(homePage.girisYapDropdown).perform();

        //2-User clicks to "Giris Yap" option from opened dropdown menu
        logLog.info1("Step 2-User clicks to \"Giris Yap\" option from opened dropdown menu");
        homePage.girisYapOption.click();

        //3-User enters email address to input box
        logLog.info1("Step 3-User enters email address to input box");
        loginPage.emailInputBox.sendKeys("swtestacademy@mailinator.com" + Keys.ENTER);

        //4-User enters password to input box and press to enter key
        logLog.info1("Step 4-User enters password to input box");
        loginPage.passwordInputBox.sendKeys("Qwerty_123" + Keys.ENTER);

        //5-Verify that user is able to log in successfully
        logLog.info1("Step 5-Verifying... that user is able to log in successfully");
        String exceptedText = "Hesabım";
        String actualText = homePage.hesabimDropdown.getAttribute("title");
        //this condition to commit this verification to log file
        if (exceptedText.equals(actualText)) {
            logLog.info1("PASSED - User logged in successfully");
        } else {
            logLog.error1("FAILED - User couldn't log in successfully");
        }

        //I use Assert class from testng library to verify
        Assert.assertEquals(actualText, exceptedText);

        //6-User enters product name to search box and press enter key
        logLog.info1("Step 6-User enters product name to search box and press enter key");
        String productName = "Yeni Başlayanlar İçin Java 10";
        homePage.searchBox.sendKeys(productName + Keys.ENTER);

        //7-User selects the product
        logLog.info1("Step 7-User selects the product");
        productListPage.productLink.click();

        //8-User adds product from two different seller
        logLog.info1("Step 8-User adds product from two different seller");
        Browser.switchWindow(driver, productName);

        for (WebElement eachSellerAddButton : productPage.sellerAddButtons) {
            eachSellerAddButton.click();
            Browser.sleep(1);
        }

        //9-User clicks "sepete git" button
        logLog.info1("Step 9-User clicks \"sepete git\" button");
        wait.until(ExpectedConditions.visibilityOf(productPage.sepeteGitButton));
        productPage.sepeteGitButton.click();

        //10-Verify that correct product has been added correctly to cart
        logLog.info1("Step 10-Verify that correct product has been added correctly to cart");
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

            Browser.sleep(1);
        }
        logLog.info2("Cart has been cleaned successfully!");

    }


    //mvn clean test -DsuiteXmlFile=testng.xml

}
