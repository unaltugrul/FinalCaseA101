package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//inherited from BasePage
public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);

    }

    //cookies
    @FindBy(xpath = "//div[@class='ot-sdk-row']//button[@id='onetrust-accept-btn-handler']")
    public WebElement cookiesAcceptButton;


}
