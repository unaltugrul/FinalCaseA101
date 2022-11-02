package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//inherited from BasePage
public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    //cookies
    @FindBy(xpath = "//div[@class='ot-sdk-row']//button[@id='onetrust-accept-btn-handler']")
    public WebElement cookiesAcceptButton;


}
