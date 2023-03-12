package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.InteractionsWithElements;
import pages.MyAccountPage;

public class HeaderElements extends InteractionsWithElements {
    private String userNameLogo = ".//div[@class='utility-bar desktop-only']//a[@href='https://www.ardene.com/ca/en/account'and @title='User: Hello %s']";
    @FindBy(xpath = ".//div[@class='utility-bar desktop-only']//span[@class='span-icon']")
    private WebElement customDropDown;

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
}
