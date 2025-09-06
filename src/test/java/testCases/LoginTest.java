package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class LoginTest extends BaseClass {

    @Test(groups={"Sanity","Master"})
    public void verifyLogin() {
        logger.info("*********** Login Test Started **********");
        try {
            HomePage hp = new HomePage(driver);
            LoginPage lp = new LoginPage(driver);
            MyAccountPage map =  new MyAccountPage(driver);
            hp.clickOnMyAccount();
            hp.clickLogin();
            lp.enterEmail(p.getProperty("email"));
            lp.enterPassword(p.getProperty("password"));
            lp.clickLogin();

            boolean flag = map.isMyAccountPageDisplayed();
            Assert.assertEquals(flag, true, "My Account page is not displayed after login");
        } catch (Exception e) {
            logger.error("Test failed due to exception: " + e.getMessage());
            Assert.fail();
        }
        logger.info("***** Login test Finished ****** ");
    }

}
