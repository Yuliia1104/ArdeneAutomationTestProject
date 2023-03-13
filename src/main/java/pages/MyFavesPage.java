package pages;

import libs.Util;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyFavesPage extends ParentPage{
    @FindBy(xpath = ".//div[@class='account__section-header']//h1")
    private WebElement myFavesHeader;
    @FindBy(xpath = ".//form//button[@value='Add to Bag']")
    private WebElement addToBagButton;
    @FindBy(xpath = ".//div[@class='image-details-container']")
    private List<WebElement> myFavesItems;
    @FindBy(xpath = ".//form//button[@class='button-text delete-item']")
    private WebElement deleteButton;
    @FindBy(xpath = ".//h2[@class='empty-text']")
    private WebElement alertMessage;
    public MyFavesPage(WebDriver webDriver) {
        super(webDriver);
    }

    public MyFavesPage checkIsRedirectedToMyFavesPage() {
        checkDisplayedElementOnly(myFavesHeader);
        return this;
    }

    public MyFavesPage checkIsItemAddedToMyFavesList() {
        checkDisplayedElementOnly(addToBagButton);
        return this;
    }

    public MyFavesPage deleteItemsInMyFavesList() {
        Util.waitABit(1);
        int counter = myFavesItems.size();
        while (!(myFavesItems.size() == 0) && counter > 0){
            clickOnElement(deleteButton);
            logger.info("Item is deleted");
            counter--;
        }
        if (myFavesItems.size()==0){
            logger.info("All items are deleted");
        }else{
            logger.error("Delete functionality fails");
            Assert.fail("Delete functionality fails");
        }
        return this;
    }

    public MyFavesPage checkAlertMessage(){
        Util.waitABit(1);
        Assert.assertTrue("Element is not found", isElementDisplayed(alertMessage));
        return this;
    }
}
