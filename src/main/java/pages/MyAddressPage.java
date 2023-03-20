package pages;

import libs.Util;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAddressPage extends ParentPage{
    @FindBy(xpath = ".//h1[contains(text(), 'My Addresses')]")
    private WebElement pageHeader;
    @FindBy(xpath = ".//div[@id='addresses']//a[@title='Create New Address for this account']")
    private WebElement createNewAddressButton;
    @FindBy(xpath = ".//form[@class='form-horizontal']")
    private WebElement addressForm;
    @FindBy(xpath = ".//input[@placeholder='Address Name *']")
    private  WebElement addressName;
    @FindBy(xpath = ".//input[@placeholder='First Name *']")
    private WebElement firstName;
    @FindBy(xpath = ".//input[@placeholder='Last Name *']")
    private WebElement lastName;
    @FindBy(xpath = ".//input[@placeholder='Address *']")
    private WebElement streetAddress;
    @FindBy(xpath = ".//input[@placeholder='City *']")
    private WebElement cityName;
    @FindBy(xpath = ".//select[@class='input-select required']")
    private WebElement selectProvince;
    @FindBy(xpath = ".//input[@placeholder='Postal Code *']")
    private WebElement postalCode;
    @FindBy(xpath = ".//select[@class='input-select country required']")
    private WebElement selectCountry;
    @FindBy(xpath = ".//button[@type='submit' and @name='dwfrm_profile_address_create']")
    private WebElement saveFormButton;
    @FindBy(xpath = ".//div[@class='mini-address-title']")
    private WebElement homeName;
    @FindBy(xpath = ".//*[@title='Delete this address']")
    private WebElement deleteAddress;
    @FindBy(xpath = ".//*[@class='address-tile  default']")
    private WebElement address;

    public MyAddressPage(WebDriver webDriver) {
        super(webDriver);
    }

    public MyAddressPage checkIsRedirectedToMyAddressPage() {
        checkDisplayedElementOnly(pageHeader);
        return this;
    }

    public MyAddressPage clickCreateNewAddressButton() {
        clickOnElement(createNewAddressButton);
        return this;
    }

    public MyAddressPage checkIsRedirectedToAddAddressForm() {
        checkDisplayedElementOnly(addressForm);
        return this;
    }

    public MyAddressPage enterAddressName(String homeName) {
        enterTextIntoElement(addressName, homeName);
        return this;
    }

    public MyAddressPage enterFirstName(String userName) {
        enterTextIntoElement(firstName, userName);
        return this;
    }

    public MyAddressPage enterLastName(String last_Name) {
        enterTextIntoElement(lastName, last_Name);
        return this;
    }

    public MyAddressPage enterStreetName(String street_Address) {
        enterTextIntoElement(streetAddress, street_Address);
        return this;
    }

    public MyAddressPage enterCityName(String city_Name) {
        enterTextIntoElement(cityName, city_Name);
        return this;
    }

    public MyAddressPage selectProvince(String provinceOption) {
        selectValueFromDropDown(selectProvince, provinceOption);
        return this;
    }

    public MyAddressPage enterPostalCode(String postal_Code) {
        enterTextIntoElement(postalCode, postal_Code);
        return this;
    }

    public MyAddressPage selectCountry(String country) {
        selectValueFromDropDown(selectCountry, country);
        return this;
    }

    public MyAddressPage clicKSaveButton() {
        clickOnElement(saveFormButton);
        return this;
    }

    public MyAddressPage refreshMyAddressesPage() {
        Util.waitABit(1);
        userRefreshTab();
        return this;
    }

    public MyAddressPage checkAddressWasCreated(String home_Name) {
        forTextComparing(home_Name, homeName);
        return this;
    }

    public MyAddressPage clickDeleteDefaultAddressButton() {
        clickOnElement(deleteAddress);
        return this;
    }

    public MyAddressPage acceptDeleteAlert() {
        acceptAlert();
        return this;
    }

    public MyAddressPage checkIsDefaultAddressDisplayed() {
        webDriverWait15.until(ExpectedConditions.invisibilityOf(address));
        Assert.assertFalse("Address has not been deleted", isElementDisplayed(address));
        return this;
    }
}
