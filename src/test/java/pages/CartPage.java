package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CartPage {
    public CartPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //product links in chart
    @FindBy(xpath = "//div[contains(@class,'product_name')]//a")
    public List<WebElement> productLinks;

    //merchant names
    @FindBy(xpath = "//span[contains(@class,'merchant')]//a")
    public List<WebElement> merchantLinks;

}