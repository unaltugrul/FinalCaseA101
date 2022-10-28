package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage extends BasePage{
    WebDriver driver;

    public ProductPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public ProductPage(){

    }


    //"sepete ekle" buttons for every seller
    @FindBy(xpath = "//button[@class='add-to-basket button small']")
    public List<WebElement> sellerAddButtons;

    @FindBy(xpath = "//button[text()='Sepete git']")
    public WebElement sepeteGitButton;

}
