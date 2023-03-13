package myFavesTest;

import baseTest.BaseTest;
import org.junit.After;
import org.junit.Test;

public class MyFavesTest extends BaseTest{
    @Test
    public void wishListCheck(){
        myAccountPage
                .openMyAccountPage()
                .clickOnAccessoriesTab()
                .checkIsRedirectedToAccessoriesPage()
                .clickOnBagsButton()
                .checkIsRedirectedToBagsPage()
                .clickOnBagItem()
                .checkIsRedirectedToBagItemPage()
                .clickOnHeartButton()
                .checkIsRedirectedToMyFavesPage()
                .checkIsItemAddedToMyFavesList()
        ;
    }

    @After
    public void deleteItemFromMyFavesList(){
        myAccountPage
                .openMyAccountPage()
                .getHeaderElements().clickOptionsDropDown()
                .getHeaderElements().clickOnMyAccountOption()
                .checkIsRedirectedToMyAccountPage()
                .clickOnMyFavesTab()
                .checkIsRedirectedToMyFavesPage()
                .deleteItemsInMyFavesList()
                .checkAlertMessage()
        ;
    }
}
