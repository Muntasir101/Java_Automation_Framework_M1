package tests;

import io.qameta.allure.testng.AllureTestNg;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.*;


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
    }
}
