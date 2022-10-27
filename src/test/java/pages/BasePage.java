package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

//I used abstract because I don't want to create object from this class
public abstract class BasePage {
    //I am going to add all common elements on the web page
    //constructor to initialize with PageFactory Class
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //"hesabim" or "giris yap" button from main modul for dropdown menu
    @FindBy(id = "myAccount")
    public WebElement girisYapDropdown;

    //"giris yap" button from dropdown menu
    @FindBy(id="login")
    public WebElement girisYapOption;

    //search input box
    @FindBy(xpath = "//div[@role='combobox']/input[1]")
    public WebElement searchBox;

}
