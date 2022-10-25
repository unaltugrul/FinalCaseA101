package tests;

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

public class TestCase_1 extends TestBase {

    Logger logger = Logger.getLogger(TestCase_1.class);

    public TestCase_1(){
        DOMConfigurator.configure("log4j.xml");
    }


    //Feature : add product to cart
    @Test
    public void test1(){
        logger.info("Test1 execution has started...");
        //•	Kullanıcı, burada satın almak istediği ürün için arama yapacaktır.
        //•	Kullanıcı, Arama sonucunda ekrana gelen ürün listesinden (veya tek bir sonuç da dönmüş olabilir) ürün seçer.
        //•	Seçilen ürün için 2 tane farklı satıcıdan ürün seçilip sepete eklenir.
        //•	Seçilen ürünün doğru olarak eklendiği ‘Sepetim’ sayfasında doğrulanmalıdır.

        //1-user hover over "Giris Yap veya uye ol" button
        logger.info("1-user hover over \"Giris Yap veya uye ol\" button");
        driver.findElement(By.xpath("//div[@class='ot-sdk-row']//button[@id='onetrust-accept-btn-handler']")).click();
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("myAccount"))).perform();

        //2-User clicks to "Giris Yap" option from opened dropdown menu
        logger.info("2-User clicks to \"Giris Yap\" option from opened dropdown menu");
        driver.findElement(By.id("login")).click();
        WebElement userInputBox = driver.findElement(By.xpath("//input[@name='username']"));

        //3-User enters email address to input box
        logger.info("3-User enters email address to input box");
        userInputBox.sendKeys("swtestacademy@mailinator.com" + Keys.ENTER);

        //4-User enters password to input box
        logger.info("4-User enters password to input box");
        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("Qwerty_123" + Keys.ENTER);
        String exceptedUserName = "swtestacademy swtestacademy";
        String actualUserName = driver.findElement(By.xpath("//a[@title='Hesabım']//span[2]")).getText();
        Assert.assertEquals(exceptedUserName,actualUserName);
        if (exceptedUserName.equals(actualUserName)){
            logger.info("PASSED - User logged in successfully");
        }else {
            logger.error("FAILED - User couldn't log in successfully");
        }



    }


    @AfterClass
    public void message2(){
        logger.info("TestCase1 is ending! Hopefully we will see each other again...");
    }




}
