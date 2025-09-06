package testBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseClass {
    public static WebDriver driver;
    public Logger logger;
    public Properties p;
    @BeforeClass(groups={"Master","Sanity","Regression"})
    @Parameters({"os","browser"})
    public void setUp(String os, String browser) throws IOException {
        //Loading properties file
        FileReader file = new FileReader("./src/test/resources/config.properties");
        p = new Properties();
        p.load(file);

        logger = LogManager.getLogger(this.getClass());
        logger.info("Initializing Driver...");

        switch (browser.toLowerCase()) {
            case "chrome": driver = new ChromeDriver(); break;
            case "firefox": driver =  new FirefoxDriver(); break;
            case "edge" : driver =  new EdgeDriver(); break;
            default: System.out.println("Invalid browser name provided: " + browser + ". Defaulting to Chrome."); return;
        }

        logger.debug("Deleting all cookies.");
        driver.manage().deleteAllCookies();

        logger.debug("Setting implicit wait to 10 seconds.");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = p.getProperty("appURL");
        logger.info("Navigating to URL: {}", url);
        driver.get(url);

        logger.debug("Maximizing browser window.");
        driver.manage().window().maximize();

        logger.info("Setup completed successfully.");
    }

    @AfterClass(groups={"Master","Sanity","Regression"})
    public void tearDown() {
        // Close the WebDriver
        driver.quit();
        logger.info("WebDriver closed successfully.");
    }

    public String randomeString() {
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        return generatedString;
    }

    public String captureScreen(String name){
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String targetFilePath = System.getProperty("user.dir") + "/screenshots/" + name + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);

        source.renameTo(targetFile);
        return targetFilePath;
    }

    public String randomeNumber() {
        String generatedString = RandomStringUtils.randomNumeric(10);
        return generatedString;
    }

    public String randomeAlphaNumeric() {
        String generatedString = RandomStringUtils.randomAlphabetic(3);
        String generatedNumber = RandomStringUtils.randomNumeric(3);
        return (generatedString+"@"+generatedNumber);
    }
}
