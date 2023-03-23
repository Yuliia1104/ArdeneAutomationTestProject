package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccessoriesPage extends ParentPage{
    @FindBy(xpath = ".//div[@class='desktop-only']//a[@href='https://www.ardene.com/ca/en/accessories-2']")
    private WebElement accessoriesNavigation;
    @FindBy(xpath = ".//div[@class='desktop-only']//a[@href='https://www.ardene.com/ca/en/bags-wallets']")
    private WebElement bagsButton;
    public AccessoriesPage(WebDriver webDriver) {
        super(webDriver);
    }
    @Step
    public AccessoriesPage checkIsRedirectedToAccessoriesPage() {
        checkDisplayedElementOnly(accessoriesNavigation);
        return this;
    }
    @Step
    public BagsPage clickOnBagsButton() {
        clickOnElement(bagsButton);
        return new BagsPage(webDriver);
    }
}
