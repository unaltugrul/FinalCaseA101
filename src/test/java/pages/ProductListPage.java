package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListPage {

    WebDriver driver;

    public ProductListPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public ProductListPage(){

    }


    @FindBy(xpath = "//li[@id='i0']//a[1]")
    public WebElement productLink;

}
