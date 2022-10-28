package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ProductListPage {

    WebDriver driver;
    // bir page sayfasi olusturuldugunda mutlaka yapmamiz gereken sey
    // bir constructor olusturup driver'a ilk degeri atamaktir (instantiate)
    public ProductListPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public ProductListPage(){

    }


    @FindBy(xpath = "//li[@id='i0']//a[1]")
    public WebElement productLink;

}
