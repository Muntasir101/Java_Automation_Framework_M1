package tests;

import pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.*;


public class LoginPageTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @Parameters("browserName")
    @BeforeMethod
    public void testSetup(String browserName) throws InterruptedException {
        if (browserName.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            Reporter.log("Chrome Browser Launch..");
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            Reporter.log("Firefox Browser Launch..");
        } else if (browserName.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            Reporter.log("Edge Browser Launch..");
        } else {
            System.out.println("Unsupported Browser.Please use Chrome or Firefox or Edge");
        }

        driver.manage().window().maximize();
        // Initialize LoginPage
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLogin() {
        // Test data
        String email = "mail123@gmail.com";
        String password = "123456";

        // Perform login
        loginPage.enterEmailAddress(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    @AfterMethod
    public void tearDown() {
        // Close the WebDriver after each test
        driver.quit();
    }
}
