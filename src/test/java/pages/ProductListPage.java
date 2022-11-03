package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListPage extends BasePage{

    public ProductListPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//li[@id='i0']//a[1]")
    public WebElement productLink;


}
