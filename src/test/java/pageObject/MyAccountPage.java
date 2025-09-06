package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.NoSuchElementException;

public class MyAccountPage extends BasePage{
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[text()='My Account']")
    WebElement msgHeading;

    @FindBy(xpath = "//a[text()='Edit your account information']")
    WebElement lnkEditAccount;

    @FindBy(xpath = "//a[text()='Change your password']")
    WebElement lnkChangePassword;

    @FindBy(xpath = "//a[text()='Modify your address book entries']")
    WebElement lnkAddressBook;

    @FindBy(xpath = "//a[text()='View your order history']")
    WebElement lnkOrderHistory;

    @FindBy(xpath = "//a[text()='Download your products']")
    WebElement lnkDownloads;

    @FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
    WebElement lnkLogout;

    public String getMyAccountLabel() {
        return msgHeading.getText();
    }

    public boolean isMyAccountPageDisplayed() {
        try {
            return (msgHeading.isDisplayed());
        } catch (Exception e) {
            return false;
        }

    }

    public void clickEditAccount() {
        lnkEditAccount.click();
    }

    public void clickChangePassword() {
        lnkChangePassword.click();
    }

    public void clickAddressBook() {
        lnkAddressBook.click();
    }

    public void clickOrderHistory() {
        lnkOrderHistory.click();
    }

    public void clickDownloads() {
        lnkDownloads.click();
    }

    public void clickLogout() {
        lnkLogout.click();
    }
}
