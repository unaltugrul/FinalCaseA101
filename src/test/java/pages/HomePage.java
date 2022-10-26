package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.security.PublicKey;

//inherited from BasePage
public class HomePage extends BasePage{

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//div[@class='ot-sdk-row']//button[@id='onetrust-accept-btn-handler']")
    public WebElement cookiesAcceptButton;


}
