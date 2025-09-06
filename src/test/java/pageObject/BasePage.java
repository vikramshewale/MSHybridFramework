package pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver driver;
    public Logger logger;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        logger = LogManager.getLogger(this.getClass());
        PageFactory.initElements(driver, this);
    }
}
