package logOutTest;

import baseTest.BaseTest;
import org.junit.Test;

public class LogOutTest extends BaseTest {
    @Test
    public void logOutTest(){
        myAccountPage
                .openMyAccountPage()
                .checkIsRedirectedToMyAccountPage()
                .getHeaderElements().clickOptionsDropDown()
                .getHeaderElements().clickOnLogOutButton()
                .checkIsRedirectedToLogInPage()
        ;
    }
}
