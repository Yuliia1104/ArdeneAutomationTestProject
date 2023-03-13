package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BagItemPage extends ParentPage{
    @FindBy(xpath = ".//a[@class='wishlist-btn icon-ico-wishlist']")
    private WebElement heartButton;

    public BagItemPage(WebDriver webDriver) {
        super(webDriver);
    }

    public BagItemPage checkIsRedirectedToBagItemPage(){
        checkDisplayedElementOnly(heartButton);
        return this;
    }

    public MyFavesPage clickOnHeartButton() {
        clickOnElement(heartButton);
        return new MyFavesPage(webDriver);
    }
}
