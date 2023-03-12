package pages;

import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InteractionsWithElements {
    protected WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    protected WebDriverWait webDriverWait15, webDriverWait30;
    public static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);

    public InteractionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        webDriverWait15 = new WebDriverWait(webDriver, Duration.ofSeconds(configProperties.TIME_FOR_EXPLICIT_WAIT_LOW()));
        webDriverWait30 = new WebDriverWait(webDriver, Duration.ofSeconds(configProperties.TIME_FOR_EXPLICIT_WAIT_HIGH()));
    }

    protected void clickOnElement(WebElement webElement){
        try {
            webDriverWait15.until(ExpectedConditions.elementToBeClickable(webElement));
            String name = getWebElementName(webElement);
            webElement.click();
            logger.info(name + " element is clicked");
        }catch (Exception e){
            printErrorStopTest(e);
        }
    }

    protected void enterTextIntoElement(WebElement webElement, String text){
        try{
            webDriverWait30.until(ExpectedConditions.visibilityOf(webElement));
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " is entered into element " + getWebElementName(webElement));
        }catch (Exception e){
            printErrorStopTest(e);
        }
    }

    protected boolean isElementDisplayed(WebElement webElement){
        try {
            webDriverWait30.until(ExpectedConditions.visibilityOf(webElement));
            boolean status = webElement.isDisplayed();
            String message;
            if (status){
                message = getWebElementName(webElement) + " element is displayed";
            }else {
                message = getWebElementName(webElement) + " element exists but not displayed";
            }
            logger.info(message);
            return status;
        }catch (Exception e){
            logger.info(getWebElementName(webElement) + " element does not exist.");
            return false;
        }
    }

    protected boolean isElementDisplayed(String text){
        try {
            return isElementDisplayed(webDriver.findElement(By.xpath(text)));
        }catch (Exception e){
            return false;
        }
    }

    protected void checkDisplayedElementOnly(WebElement webElement){
        Assert.assertTrue(getWebElementName(webElement) + " element is not displayed", isElementDisplayed(webElement));
    }

    protected void forTextComparing(String text, WebElement webElement){
        Assert.assertEquals(getWebElementName(webElement)+" Text of the element does not found its match", text, webElement.getText());
        logger.info(getWebElementName(webElement) + " found its match.");
    }

    protected void selectValueFromDropDown(WebElement dropDown, String value){
        try {
            Select select = new Select(dropDown);
            select.selectByValue(value);
            logger.info(value + " province is selected");
        }catch (Exception e){
            printErrorStopTest(e);
        }
    }

    protected void userRefreshTab(){
        webDriver.navigate().refresh();
    }

    protected void acceptAlert(){
        webDriver.switchTo().alert().accept();
    }

    protected String getWebElementName(WebElement webElement){
        try{
            return webElement.getAccessibleName();
        }catch (Exception e){
            return "";
        }
    }
    protected void printErrorStopTest(Exception e){
        logger.error("Cannot reach the element" + e);
        Assert.fail("Cannot reach the element");
    }
}


