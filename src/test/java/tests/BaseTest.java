package tests;

import io.qameta.allure.testng.AllureTestNg;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Listeners({AllureTestNg.class})
public class BaseTest {

    protected WebDriver driver;
    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    @Parameters("browserName")
    @BeforeMethod
    public void testSetup(String browserName) {
        if (browserName.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
            Reporter.log("Chrome Browser Launched..");
            logger.info("Chrome Browser Launched successfully");
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
            Reporter.log("Firefox Browser Launched..");
            logger.info("Firefox Browser Launched successfully");
        } else if (browserName.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
            Reporter.log("Edge Browser Launched..");
            logger.info("Edge Browser Launched successfully");
        } else {
            System.out.println("Unsupported Browser.Please use Chrome or Firefox or Edge");
        }

        driver.manage().window().maximize();
    }


    @AfterMethod
    public void tearDown() {
        // Close the WebDriver after each test
        driver.quit();
        logger.info("Browser Closed !");
    }

    public void captureScreenshot(WebDriver driver, String fileName) {
        // Create screenshots directory if it doesn't exist
        String screenshotsDirPath = "src/test/screenshots";
        Path screenshotsDir = Paths.get(screenshotsDirPath);
        if (!Files.exists(screenshotsDir)) {
            try {
                Files.createDirectories(screenshotsDir);
            } catch (IOException e) {
                System.out.println("Failed to create screenshots directory: " + e.getMessage());
                return;
            }
        }

        // Capture screenshot
        if (driver instanceof TakesScreenshot) {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String screenshotPath = screenshotsDirPath + "/" + fileName + "_" + timestamp + ".png";
            try {
                Files.copy(screenshotFile.toPath(), Paths.get(screenshotPath));
                System.out.println("Screenshot captured: " + screenshotPath);
            } catch (IOException e) {
                System.out.println("Failed to capture screenshot: " + e.getMessage());
            }
        } else {
            System.out.println("Driver does not support taking screenshots");
        }
    }
}
