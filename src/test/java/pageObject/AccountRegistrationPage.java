package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
    public AccountRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-firstname")
    WebElement txtFirstName;

    @FindBy(id = "input-lastname")
    WebElement txtLastName;

    @FindBy(id = "input-email")
    WebElement txtEmail;

    @FindBy(id = "input-telephone")
    WebElement txtTelephone;

    @FindBy(id = "input-password")
    WebElement txtPassword;

    @FindBy(id = "input-confirm")
    WebElement txtConfirmPassword;

    @FindBy(name = "agree")
    WebElement chkPrivacyPolicy;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement btnContinue;

    @FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
    WebElement msgConfirmation;

    public void enterFirstName(String firstName) {
        txtFirstName.sendKeys(firstName);
        logger.info("Entered first name: " + firstName);
    }

    public void enterLastName(String lastName) {
        txtLastName.sendKeys(lastName);
        logger.info("Entered last name: " + lastName);
    }

    public void enterEmail(String email) {
        txtEmail.sendKeys(email);
        logger.info("Entered email: " + email);
    }

    public void enterTelephone(String telephone) {
        txtTelephone.sendKeys(telephone);
        logger.info("Entered telephone: " + telephone);
    }

    public void enterPassword(String password) {
        txtPassword.sendKeys(password);
        logger.info("Entered password");
    }

    public void enterConfirmPassword(String confirmPassword) {
        txtConfirmPassword.sendKeys(confirmPassword);
        logger.info("Entered confirm password");
    }

    public void checkPrivacyPolicy() {
        chkPrivacyPolicy.click();
        logger.info("Checked privacy policy agreement");
    }

    public void clickContinue() {
        btnContinue.click();
        logger.info("Clicked on Continue button to submit registration form");
    }

    public String getConfirmationMessage() {
        try {
            return msgConfirmation.getText();
        } catch (Exception e) {
            return (e.getMessage());
        }
    }
}
