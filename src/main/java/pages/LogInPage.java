package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends ParentPage{
    @FindBy(xpath = ".//div[@class='utility-bar desktop-only']//span[@class='span-icon']")
    private WebElement logInDropDown;

    public LogInPage(WebDriver webDriver) {
        super(webDriver);
    }
    @Step
    public LogInPage checkIsRedirectedToLogInPage() {
        checkDisplayedElementOnly(logInDropDown);
        return this;
    }
}
