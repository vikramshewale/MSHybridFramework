package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-email")
    WebElement txtEmail;

    @FindBy(id = "input-password")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement btnLogin;

    @FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
    WebElement msgAlert;

    public void enterEmail(String email) {
        txtEmail.sendKeys(email);
        logger.info("Entered email: " + email);
    }

    public void enterPassword(String password) {
        txtPassword.sendKeys(password);
        logger.info("Entered password");
    }

    public void clickLogin() {
        btnLogin.click();
        logger.info("Clicked on Login button");
    }

    public String getAlertMessage() {
        return msgAlert.getText();
    }
}
