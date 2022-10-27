package tests.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import tests.base.TestBase;
import utilities.Browser;
import utilities.Driver;
import utilities.UtilityMethods;

import java.time.Duration;

public class TestCase1 extends TestBase {

    //I used logger for each class because to log class name to log file
    Logger logger = Logger.getLogger(TestCase1.class);

    //This constructor to configure log4j.xml file
    public TestCase1() {
        DOMConfigurator.configure("log4j.xml");
    }

    //I used actions class to implement hover action for now
    Actions actions = new Actions(Driver.getDriver());

    //I created wait object if I face with any delaying
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    //Feature : add product to cart by logging in
    @Test
    public void testSteps() throws InterruptedException {

        //to clarify method and class names I use detailed log
        logger.info("Test Execution is working... Feature - User adds product to cart by logging in...");

        logger.info("Step 1-User hovers over \"Giris Yap veya uye ol\" button");
        //1-User hovers over "Giris Yap veya uye ol" button
        actions.moveToElement(homePage.girisYapDropdown).perform();

        //2-User clicks to "Giris Yap" option from opened dropdown menu
        logger.info("Step 2-User clicks to \"Giris Yap\" option from opened dropdown menu");
        homePage.girisYapOption.click();

        //3-User enters email address to input box
        logger.info("Step 3-User enters email address to input box");
        loginPage.emailInputBox.sendKeys("swtestacademy@mailinator.com" + Keys.ENTER);

        //4-User enters password to input box and press to enter key
        logger.info("Step 4-User enters password to input box");
        loginPage.passwordInputBox.sendKeys("Qwerty_123" + Keys.ENTER);

        //5-Verify that user is able to log in successfully
        logger.info("Verifying... that user is able to log in successfully");
        String exceptedText = "Hesabım";
        String actualText = homePage.hesabimDropdown.getAttribute("title");
        //this condition to commit this verification to log file
        if (exceptedText.equals(actualText)) {
            logger.info("PASSED - User logged in successfully");
        } else {
            logger.error("FAILED - User couldn't log in successfully");
        }

        //I use Assert class from testng library to verify
        Assert.assertEquals(actualText, exceptedText);

        //6-User enters product name to search box and press enter key
        logger.info("Step 6-User enters product name to search box and press enter key");
        String productName = "Yeni Başlayanlar İçin Java 10";
        homePage.searchBox.sendKeys(productName + Keys.ENTER);

        //7-User selects the product
        logger.info("Step 7-User selects the product");
        productListPage.productLink.click();

        //8-User adds product from two different seller
        logger.info("Step 8-User adds product from two different seller");
        Browser.switchWindow(Driver.getDriver(), productName);

        for (WebElement eachSellerAddButton : productPage.sellerAddButtons) {
            eachSellerAddButton.click();
            Thread.sleep(1000);
        }

        //9-User clicks "sepete git" button
        logger.info("Step 9-User clicks \"sepete git\" button");
        wait.until(ExpectedConditions.visibilityOf(productPage.sepeteGitButton));
        productPage.sepeteGitButton.click();

        //10-Verify that correct product has been added correctly to cart
        logger.info("Step 10-Verify that correct product has been added correctly to cart");
        for (WebElement eachProductLink : cartPage.productLinks) {
            if (!eachProductLink.getText().contains(productName)) {
                logger.error("Product name is not matching it might be different product check it");
                Assert.assertTrue(false, "Product name is not matching it might be different product check it");
            } else {
                logger.info("PASSED - Product name is matching");
                Assert.assertTrue(true);
            }
        }

        if (cartPage.productLinks.size() != 2) {
            logger.error("Number of total product is not correct, check it.");
            Assert.assertTrue(false, "Number of total product should be 2 pcs. check it please.");
        } else {
            logger.info("PASSED - Number of total product is correct");
            Assert.assertTrue(true);
        }

        for (WebElement eachProductQuantity : cartPage.quantityOfProduct) {
            String quantityOfProduct = eachProductQuantity.getAttribute("value");
            if (!quantityOfProduct.equals("1")) {
                logger.error("quantity of product is not 1");
                Assert.assertTrue(false, "quantity of product is not 1");
            } else {
                logger.info("PASSED - quantity of product is 1");
            }
        }

        //This loop for cleaning the cart
        logger.info("Cart cleaning...");
        UtilityMethods.cleanCart();


    }

/*    @Test
    public void testCase2() {


    }*/


}
