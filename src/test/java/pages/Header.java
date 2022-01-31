package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header extends GenericPage {
    public Header(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "contact-link")
    WebElement contactUsLink;

    @FindBy (css = "[class='expand-more']")
    WebElement languageDropdown;

    @FindBy (css = "[class = 'expand-more _gray-darker']")
    WebElement currencyDropdown;

    @FindBy (css = "[class = 'logout hidden-sm-down']")
    WebElement signOut;

    @FindBy (className = "user-info")
    WebElement signIn;

    @FindBy (className = "account")
    WebElement account;

    @FindBy (id = "_desktop_cart")
    WebElement cart;
}