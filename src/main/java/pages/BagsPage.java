package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BagsPage extends ParentPage{
    @FindBy(xpath = ".//div[@id='secondary']//div[@class='desktop-only breadcrumb-page-title' and contains(text(), 'view all bags')]")
    private WebElement bagsPageHeader;
    @FindBy(xpath = ".//a[@class='thumb-link']")
    private WebElement anyBag;

    public BagsPage(WebDriver webDriver) {
        super(webDriver);
    }
    @Step
    public BagsPage checkIsRedirectedToBagsPage(){
        checkDisplayedElementOnly(bagsPageHeader);
        return this;
    }
    @Step
    public BagItemPage clickOnBagItem(){
        clickOnElement(anyBag);
        return new BagItemPage(webDriver);
    }
}
