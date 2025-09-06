package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class LoginDDT extends BaseClass {
    @Test(dataProvider = "LoginData", dataProviderClass = utilities.DataProviders.class,
    groups={"DatDriven", "Master"})
    public void verifyLoginDDT (String email, String pwd, String exp) {
        logger.info("*********** Login DDT Test Started **********");
        HomePage hp = new HomePage(driver);
        LoginPage lp = new LoginPage(driver);
        MyAccountPage map =  new MyAccountPage(driver);
        hp.clickOnMyAccount();
        hp.clickLogin();
        lp.enterEmail(email);
        lp.enterPassword(pwd);
        lp.clickLogin();
        boolean targetPage = map.isMyAccountPageDisplayed();

        if (exp.equalsIgnoreCase("Valid")){
            if (targetPage==true) {
                Assert.assertTrue(true);
                map.clickLogout();
            } else {
                Assert.assertTrue(false);
            }
        }
        if (exp.equalsIgnoreCase("Invalid")){
            if (targetPage==true) {
                map.clickLogout();
                Assert.assertTrue(false);
            } else {
                Assert.assertTrue(true);
            }
        }
        logger.info("***** Login DDT test Finished ****** ");
    }
}
