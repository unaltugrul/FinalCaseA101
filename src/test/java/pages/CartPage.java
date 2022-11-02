package pages;

import org.jsoup.Connection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
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

    //delete all line by hovering over on this element
    @FindBy(xpath = "//div[contains(@class,'hover')]//a[1]")
    public WebElement deleteAllLine;


}
