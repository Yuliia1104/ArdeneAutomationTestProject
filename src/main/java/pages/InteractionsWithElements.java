package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InteractionsWithElements {
    protected WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    protected WebDriverWait webDriverWait15, webDriverWait30;

    public InteractionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        webDriverWait15 = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        webDriverWait30 = new WebDriverWait(webDriver, Duration.ofSeconds(30));
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


