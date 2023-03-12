package myAccountOptionsTest;

import baseTest.BaseTest;
import libs.ExcelDriver;
import libs.TestData;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

import static pages.InteractionsWithElements.configProperties;

public class MyAccountOptionsTest extends BaseTest {

    @Test
    public void myAccountOptionsCheck() throws IOException {
        Map<String, String > navigationOptionsData = ExcelDriver.getData(configProperties.DATA_FILE(), "navOptions");
        myAccountPage
                .openMyAccountPage()
                .getHeaderElements().clickOptionsDropDown()
                .checkMyAccountOptionPresent()
                .checkMyRewadsOptionPresent()
                .checkMyPaymentOptionPresent(TestData.MY_PAY_SETTINGS)
                .checkMyOrdersOptionPresent()
                .checkMyProfileOptionPresent()
                .checkMyAddresses()
                .checkMyCommunicationPreferencesPresent(TestData.MY_COMM_PREF)
                .checkLogOutOptionPresent()
                .checkShopNavigationOptions(navigationOptionsData.get("shoppingOptions"))
        ;
    }

}
