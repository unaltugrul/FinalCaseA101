package tests.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import tests.base.TestBase;
import utilities.Driver;

public class TestCase1 extends TestBase {

    //I used logger for each class because to log class name to log file
    Logger logger = Logger.getLogger(TestCase1.class);

    //This constructor to configure log4j.xml file
    public TestCase1(){
        DOMConfigurator.configure("log4j.xml");
    }

    //I used actions class to implement hover action for now
    Actions actions = new Actions(Driver.getDriver());

    //Feature : add product to cart by logging in
    @Test
    public void testSteps(){

        //to clarify method and class names I use detailed log
        logger.info(new Object() {
        }.getClass().getEnclosingMethod().getName() + ": Test Execution is working Feature - User adds product to cart by logging in...");

        logger.info("Step 1-User hovers over \"Giris Yap veya uye ol\" button");
        //1-User hovers over "Giris Yap veya uye ol" button
        actions.moveToElement(homePage.girisYapDropdown).perform();

        //2-User clicks to "Giris Yap" option from opened dropdown menu
        logger.info("Step 2-User clicks to \"Giris Yap\" option from opened dropdown menu");
        homePage.girisYapOption.click();

        //3-User enters email address to input box
        logger.info("Step 3-User enters email address to input box");
        loginPage.emailInputBox.sendKeys("swtestacademy@mailinator.com" + Keys.ENTER);

        //4-User enters password to input box
        logger.info("Step 4-User enters password to input box");
        loginPage.passwordInputBox.sendKeys("Qwerty_123" + Keys.ENTER);

        //5- Verify that user is able to log in successfully
        logger.info("Verifying... that user is able to log in successfully");
        String exceptedUserName = "swtestacademy swtestacademy";
        String actualUserName = Driver.getDriver().findElement(By.xpath("//a[@title='Hesabım']//span[2]")).getText();
        //I use Assert class from testng library to verify
        Assert.assertEquals(exceptedUserName,actualUserName);
        //this condition to commit this verification to log file
        if (exceptedUserName.equals(actualUserName)){
            logger.info("PASSED - User logged in successfully");
        }else {
            logger.error("FAILED - User couldn't log in successfully");
        }

        //6-User enters product name to search box


    }

    @Test
    public void testCase2(){

        //•	Kullanıcı, Arama sonucunda ekrana gelen ürün listesinden (veya tek bir sonuç da dönmüş olabilir) ürün seçer.
        //•	Seçilen ürün için 2 tane farklı satıcıdan ürün seçilip sepete eklenir.
        //•	Seçilen ürünün doğru olarak eklendiği ‘Sepetim’ sayfasında doğrulanmalıdır.


    }


    @AfterClass
    public void message2(){
        logger.info("TestCase1 ");
        logger.info(new Object() {
        }.getClass().getName() + ": is ending! Hopefully we will see each other again...");
    }




}
