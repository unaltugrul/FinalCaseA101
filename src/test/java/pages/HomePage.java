package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//inherited from BasePage
public class HomePage extends BasePage{

    WebDriver driver;
    // bir page sayfasi olusturuldugunda mutlaka yapmamiz gereken sey
    // bir constructor olusturup driver'a ilk degeri atamaktir (instantiate)
    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public HomePage(){

    }
    @FindBy(xpath = "//div[@class='ot-sdk-row']//button[@id='onetrust-accept-btn-handler']")
    public WebElement cookiesAcceptButton;


}
