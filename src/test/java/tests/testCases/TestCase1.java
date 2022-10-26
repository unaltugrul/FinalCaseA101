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


    //Feature : add product to cart by logging in
    @Test
    public void testStep1(){

        //to clarify method and class names I use detailed log
        logger.info(new Object() {
        }.getClass().getEnclosingMethod().getName() + ": -User hovers over \"Giris Yap veya uye ol\" button...");
        //1-User hovers over "Giris Yap veya uye ol" button
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(Driver.getDriver().findElement(By.id("myAccount"))).perform();

    }

    @Test
    public void testStep2(){



        //•	Kullanıcı, burada satın almak istediği ürün için arama yapacaktır.
        //•	Kullanıcı, Arama sonucunda ekrana gelen ürün listesinden (veya tek bir sonuç da dönmüş olabilir) ürün seçer.
        //•	Seçilen ürün için 2 tane farklı satıcıdan ürün seçilip sepete eklenir.
        //•	Seçilen ürünün doğru olarak eklendiği ‘Sepetim’ sayfasında doğrulanmalıdır.



        //2-User clicks to "Giris Yap" option from opened dropdown menu
        logger.info("2-User clicks to \"Giris Yap\" option from opened dropdown menu");
        Driver.getDriver().findElement(By.id("login")).click();
        WebElement userInputBox = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));

        //3-User enters email address to input box
        logger.info("3-User enters email address to input box");
        userInputBox.sendKeys("swtestacademy@mailinator.com" + Keys.ENTER);

        //4-User enters password to input box
        logger.info("4-User enters password to input box");
        WebElement passwordInputBox = Driver.getDriver().findElement(By.name("password"));
        passwordInputBox.sendKeys("Qwerty_123" + Keys.ENTER);
        String exceptedUserName = "swtestacademy swtestacademy";
        String actualUserName = Driver.getDriver().findElement(By.xpath("//a[@title='Hesabım']//span[2]")).getText();
        Assert.assertEquals(exceptedUserName,actualUserName);
        if (exceptedUserName.equals(actualUserName)){
            logger.info("PASSED - User logged in successfully");
        }else {
            logger.error("FAILED - User couldn't log in successfully");
        }

        //5-User enters product name to search box




    }


    @AfterClass
    public void message2(){
        logger.info("TestCase1 ");
        logger.info(new Object() {
        }.getClass().getName() + ": is ending! Hopefully we will see each other again...");
    }




}
