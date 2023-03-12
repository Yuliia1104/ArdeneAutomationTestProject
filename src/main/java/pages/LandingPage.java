package pages;

import libs.TestData;
import libs.Util;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class LandingPage extends InteractionsWithElements{
    public LandingPage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(xpath = ".//div[@class='utility-bar desktop-only']//span[@class='span-icon']")
    private WebElement logInDropDown;
    @FindBy(xpath = ".//ul[@class='menu-utility-user']//input[@name='dwfrm_login_username']")
    private WebElement inputUserEmail;
    @FindBy(xpath = ".//ul[@class='menu-utility-user']//input[@name='dwfrm_login_password']")
    private WebElement inputPassword;
    @FindBy(xpath = ".//ul[@class='menu-utility-user']//button[@name='dwfrm_login_login']")
    private WebElement logInButton;

    public LandingPage openLandingPage(){
        try {
            webDriver.get("https://www.ardene.com/");
            Util.waitABit(1);
            logger.info("Landing page is loaded");
        }catch (Exception e){
            logger.error("Landing page is not loaded" + e);
            Assert.fail("Landing page is not loaded");
        }
        return this;
    }

    public LandingPage clickLogInDropDown(){
        clickOnElement(logInDropDown);
        return this;
    }

    public LandingPage enterUserEmail(String email){
        enterTextIntoElement(inputUserEmail, email);
        return this;
    }

    public LandingPage enterUserPassword(String password){
        enterTextIntoElement( inputPassword, password);
        return  this;
    }

    public LandingPage clickLogInButton(){
        clickOnElement(logInButton);
        return this;
    }

    public MyAccountPage fillInLogInForm() {
        clickOnElement(logInDropDown);
        enterUserEmail(TestData.LOGIN_EMAIL);
        enterUserPassword(TestData.LOGIN_PASSWORD);
        clickLogInButton();
        return new MyAccountPage(webDriver);
    }
}
