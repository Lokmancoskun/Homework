package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LocatorsPage {
    public LocatorsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(linkText = "Login")
    public WebElement login;

    @FindBy(linkText = "Home")
    public WebElement home;

    @FindBy(linkText = "Search")
    public WebElement search;

    @FindBy(xpath = "//h1[contains(text(),'Testing!')]")
    public WebElement testingText;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/main/p")
    public WebElement helloWorldText;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@id='searchText']")
    public WebElement searchBox;

    @FindBy(xpath = "/html/body/div/div/main/div/a[1]")
    public WebElement ownerObject;


}