package pages;

import io.qameta.allure.Step;
import libs.TestData;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.elements.HeaderElements;

import java.util.ArrayList;
import java.util.List;

public class MyAccountPage extends ParentPage {
    private HeaderElements headerElements = new HeaderElements(webDriver);

    @FindBy(xpath = ".//div[@class='utility-bar desktop-only']//a[@title='My Account']")
    private WebElement myAccount;
    @FindBy(xpath = ".//div[@class='utility-bar desktop-only']//a[@title='My rewards']")
    private WebElement myRewards;
    @FindBy(xpath = ".//div[@class='utility-bar desktop-only']//a[@title='My payment settings']")
    private WebElement myPaymentSettings;
    @FindBy(xpath = ".//div[@class='utility-bar desktop-only']//a[@title='My orders']")
    private WebElement myOrders;
    @FindBy(xpath = ".//div[@class='utility-bar desktop-only']//a[@title='My profile']")
    private WebElement myProfile;
    @FindBy(xpath = ".//div[@class='utility-bar desktop-only']//a[@title='My addresses']")
    private WebElement myAddresses;
    @FindBy(xpath = ".//div[@class='utility-bar desktop-only']//a[@title='My communication preferences']")
    private WebElement myCommunicationPreferences;
    @FindBy(xpath = ".//div[@class='utility-bar desktop-only']//a[@title='Logout']")
    private WebElement logOutOption;
    private static final String navElement = ".//nav//a[@class='has-sub-menu top-level-tag']";
    @FindBy(xpath = navElement)
    private List<WebElement> listOfOptions;
    @FindBy(xpath = ".//nav[@id='navigation']//a[@href='https://www.ardene.com/ca/en/accessories-2']")
    private WebElement accessoriesTab;
    @FindBy(xpath = ".//ul[@class='account-navigation']//a[@title='Modify your wish list']")
    private WebElement myFavesTab;

    public MyAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    public HeaderElements getHeaderElements() {
        return headerElements;
    }

    public MyAccountPage openMyAccountPage() {
        LandingPage landingPage = new LandingPage(webDriver);
        landingPage.openLandingPage();
        if (!getHeaderElements().isUserNameLogoDisplayed(TestData.USER_NAME)) {
            landingPage.fillInLogInForm();
        }
        checkIsRedirectedToMyAccountPage();
        return this;
    }
    @Step
    public MyAccountPage checkIsRedirectedToMyAccountPage() {
        Assert.assertTrue("Element is not displayed", getHeaderElements().isUserNameLogoDisplayed(TestData.USER_NAME));
        return this;
    }

    public MyAccountPage checkMyAccountOptionPresent() {
        webDriverWait15.until(ExpectedConditions.visibilityOf(myAccount));
        checkDisplayedElementOnly(myAccount);
        return this;
    }

    public MyAccountPage checkMyRewadsOptionPresent() {
        webDriverWait15.until(ExpectedConditions.visibilityOf(myRewards));
        checkDisplayedElementOnly(myRewards);
        return this;
    }

    public MyAccountPage checkMyPaymentOptionPresent(String myPaymentOption) {
        forTextComparing(myPaymentOption, myPaymentSettings);
        return this;
    }

    public MyAccountPage checkMyOrdersOptionPresent() {
        webDriverWait15.until(ExpectedConditions.visibilityOf(myOrders));
        checkDisplayedElementOnly(myOrders);
        return this;
    }

    public MyAccountPage checkMyProfileOptionPresent() {
        checkDisplayedElementOnly(myProfile);
        return this;
    }

    public MyAccountPage checkMyAddresses() {
        checkDisplayedElementOnly(myAddresses);
        return this;
    }

    public MyAccountPage checkMyCommunicationPreferencesPresent(String myCommPref) {
        forTextComparing(myCommPref, myCommunicationPreferences);
        return this;
    }

    public MyAccountPage checkLogOutOptionPresent() {
        checkDisplayedElementOnly(logOutOption);
        return this;
    }

    public MyAccountPage checkShopNavigationOptions(String expectedElements) {
        String[] expectedWebElements = expectedElements.split(",");
        webDriverWait15.withMessage("Number of messages must be " + expectedWebElements.length)
                .until(ExpectedConditions.numberOfElementsToBe(By.xpath(navElement), expectedWebElements.length));
        Assert.assertEquals(" Number of elements ", expectedWebElements.length, listOfOptions.size());
        logger.info(expectedWebElements.length + " options are available to the user.");

        ArrayList<String> valueOfOptions = new ArrayList<>();
        for (WebElement webElement : listOfOptions) {
            valueOfOptions.add(webElement.getText());
            logger.info(webElement.getText());
        }

        SoftAssertions softAssertions = new SoftAssertions();
        for (int i = 0; i < expectedWebElements.length; i++) {
            softAssertions.assertThat(expectedWebElements[i]).as("Element does not find its match ").isIn(valueOfOptions);
        }
        softAssertions.assertAll();
        return this;
    }

    public AccessoriesPage clickOnAccessoriesTab() {
        clickOnElement(accessoriesTab);
        return new AccessoriesPage(webDriver);
    }

    public MyFavesPage clickOnMyFavesTab() {
        clickOnElement(myFavesTab);
        return new MyFavesPage(webDriver);
    }
}
