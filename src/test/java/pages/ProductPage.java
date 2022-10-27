package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ProductPage {
    public ProductPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //"sepete ekle" buttons for every seller
    @FindBy(xpath = "//button[@class='add-to-basket button small']")
    public List<WebElement> sellerAddButtons;

    @FindBy(xpath = "//button[text()='Sepete git']")
    public WebElement sepeteGitButton;

}
