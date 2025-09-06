package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class AccountTest extends BaseClass{

    @Test(groups = {"Regression", "Master"})
    public void verifyAccountRegistration() {
        try {
            HomePage hp = new HomePage(driver);
            AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
            String password = randomeAlphaNumeric();
            hp.clickOnMyAccount();
            hp.clickOnRegister();
            regPage.enterFirstName(randomeString().toUpperCase());
            regPage.enterLastName(randomeString().toUpperCase());
            regPage.enterEmail(randomeString() + "@gmail.com");
            regPage.enterTelephone(randomeNumber());
            regPage.enterPassword(password);
            regPage.enterConfirmPassword(password);
            regPage.checkPrivacyPolicy();
            regPage.clickContinue();
            String confirmationMessage = regPage.getConfirmationMessage();
            Assert.assertEquals(confirmationMessage, "Your Account Has Been Created!");
            logger.info("Account registration successful with confirmation message: " + confirmationMessage);
        } catch (Exception e) {
            logger.error("Test failed ...");
            logger.debug("Debug logs ...");
            Assert.fail();
        }
        logger.info("******** Account registration test completed successfully.******");
    }

}
