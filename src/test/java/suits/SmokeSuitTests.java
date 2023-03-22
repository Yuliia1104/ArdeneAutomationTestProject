package suits;


import logInTest.LogInTest;
import logOutTest.LogOutTest;
import myAccountOptionsTest.MyAccountOptionsTest;
import myFavesTest.MyFavesTest;
import newAddressAdditionTest.NewAddressAdditionTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LogInTest.class,
        MyAccountOptionsTest.class,
        NewAddressAdditionTest.class,
        MyFavesTest.class,
        LogOutTest.class
})
public class SmokeSuitTests {
}
