package newAddressAdditionTest;

import baseTest.BaseTest;
import libs.TestData;
import org.junit.After;
import org.junit.Test;

public class NewAddressAdditionTest extends BaseTest {
    @Test
    public void defaultAddressFormTest(){
        myAccountPage
                .openMyAccountPage()
                .getHeaderElements().clickOptionsDropDown()
                .getHeaderElements().clickMyAddresseButton()
                .checkIsRedirectedToMyAddressPage()
                .clickCreateNewAddressButton()
                .checkIsRedirectedToAddAddressForm()
                .enterAddressName(TestData.HOME_NAME)
                .enterFirstName(TestData.USER_NAME)
                .enterLastName(TestData.LAST_NAME)
                .enterStreetName(TestData.STREET_ADDRESS)
                .enterCityName(TestData.CITY_NAME)
                .selectProvince(TestData.PROVINCE_OPTION)
                .enterPostalCode(TestData.POSTAL_CODE)
                .selectCountry(TestData.COUNTRY)
                .clicKSaveButton()
                .refreshMyAddressesPage()
                .checkAddressWasCreated(TestData.HOME_NAME)
        ;
    }

    @After
    public void deleteDefaultAddress(){
        myAccountPage
                .openMyAccountPage()
                .getHeaderElements().clickOptionsDropDown()
                .getHeaderElements().clickMyAddresseButton()
                .checkIsRedirectedToMyAddressPage()
                .clickDeleteDefaultAddressButton()
                .acceptDeleteAlert()
                .checkIsDefaultAddressDisplayed()
        ;
    }
}
