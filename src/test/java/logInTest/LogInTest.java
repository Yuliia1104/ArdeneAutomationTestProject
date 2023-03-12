package logInTest;

import baseTest.BaseTest;

import baseTest.BaseTest;
import libs.TestData;
import org.junit.Assert;
import org.junit.Test;
public class LogInTest extends BaseTest {
    @Test
    public void validLogInTest(){
        landingPage
                .openLandingPage()
                .clickLogInDropDown()
                .enterUserEmail(TestData.LOGIN_EMAIL)
                .enterUserPassword(TestData.LOGIN_PASSWORD)
                .clickLogInButton()
        ;
        Assert.assertTrue("User Name is not displayed", headerElements.isUserNameLogoDisplayed(TestData.USER_NAME));
    }
}
