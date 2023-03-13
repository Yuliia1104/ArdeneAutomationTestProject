package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.*;

public class HeaderElements extends InteractionsWithElements {
    private String userNameLogo = ".//div[@class='utility-bar desktop-only']//a[@href='https://www.ardene.com/ca/en/account'and @title='User: Hello %s']";
    @FindBy(xpath = ".//div[@class='utility-bar desktop-only']//span[@class='span-icon']")
    private WebElement customDropDown;
    @FindBy(xpath = ".//div[@class='utility-bar desktop-only']//a[@title='My addresses']")
    private WebElement myAddresses;
    @FindBy(xpath = ".//div[@class='utility-bar desktop-only']//a[@title='My Account']")
    private WebElement myAccount;
    @FindBy(xpath = ".//div[@class='utility-bar desktop-only']//a[@title='Logout']")
    private WebElement logOutButton;

    public HeaderElements(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isUserNameLogoDisplayed(String userName) {
        return isElementDisplayed(String.format(userNameLogo,userName));
    }

    public MyAccountPage clickOptionsDropDown(){
        clickOnElement(customDropDown);
         return new MyAccountPage(webDriver);
    }

    public MyAddressPage clickMyAddresseButton() {
        clickOnElement(myAddresses);
        return new MyAddressPage(webDriver);
    }

    public MyAccountPage clickOnMyAccountOption(){
        clickOnElement(myAccount);
        return new MyAccountPage(webDriver);
    }

    public LogInPage clickOnLogOutButton() {
        clickOnElement(logOutButton);
        return new LogInPage(webDriver);
    }
}
