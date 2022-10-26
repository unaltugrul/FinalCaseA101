package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BasePage {
    //I am going to add all common elements on the web page
    //constructor to initialize with PageFactory Class
    public BasePage(){
       PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy()
    public WebElement



}
