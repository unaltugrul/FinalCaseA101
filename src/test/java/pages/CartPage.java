package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CartPage {
    WebDriver driver;
    // bir page sayfasi olusturuldugunda mutlaka yapmamiz gereken sey
    // bir constructor olusturup driver'a ilk degeri atamaktir (instantiate)
    public CartPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public CartPage(){

    }

    //product links in chart
    @FindBy(xpath = "//div[contains(@class,'product_name')]//a")
    public List<WebElement> productLinks;

    //merchant names
    @FindBy(xpath = "//span[contains(@class,'merchant')]//a")
    public List<WebElement> merchantLinks;

    //every product quantity
    @FindBy(name = "quantity")
    public List<WebElement> quantityOfProduct;

    //delete button to delete products
    @FindBy(xpath = "//a[@aria-label='Ürünü Kaldır']")
    public WebElement deleteButton;

    @FindBy(xpath = "//div[contains(@class,'product_pro')]//a[contains(@class,'delete_pro')]")
    public WebElement deleteAllLine;


}
