package pages.elements;

import org.openqa.selenium.WebDriver;
import pages.InteractionsWithElements;

public class HeaderElements extends InteractionsWithElements {
    private String userNameLogo = ".//div[@class='utility-bar desktop-only']//a[@href='https://www.ardene.com/ca/en/account'and @title='User: Hello %s']";

    public HeaderElements(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isUserNameLogoDisplayed(String userName) {
        return isElementDisplayed(String.format(userNameLogo,userName));
    }
}
