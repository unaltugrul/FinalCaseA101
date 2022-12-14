package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//I used abstract because I don't want to create object from this class
public class BasePage {
    //I am going to add all common elements on the web page to this page

    //driver instance, I am going to assign this driver to this page for every cycle
    WebDriver driver;

    //constructor to trigger this class while finding for every element
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //"giris yap" button from main modul for dropdown menu
    @FindBy(id = "myAccount")
    public WebElement loginDropdown;

    //"giris yap" button from dropdown menu
    @FindBy(id="login")
    public WebElement loginOption;

    //search input box
    @FindBy(xpath = "//div[@role='combobox']/input[1]")
    public WebElement searchBox;

    //hesabim dropdown menu link after logging in
    @FindBy(xpath = "//a[@title='Hesabım']")
    public WebElement myAccountDropdown;

    //sepetim Button
    @FindBy(xpath = "//span[@id='shoppingCart']/..")
    public WebElement myCartButton;

    @FindBy(id = "cartItemCount")
    public WebElement cartItemCount;

}
