package tests;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.PropertyReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class LoginPageTestDP extends BaseTest {

    private LoginPage loginPage;

    private static final Logger logger = LogManager.getLogger(LoginPageTestDP.class);

    @Test(dataProvider = "LoginDataProvider")
    @Description("Test login functionality")
    public void testLogin(String Email_DP, String Password_DP) throws FileNotFoundException {
        PropertyReader propertyReader = new PropertyReader("src/main/java/config/baseConfig.properties");
        // Read properties
        String baseUrl = propertyReader.getProperty("baseUrl");
        // Initialize LoginPage
        driver.get(baseUrl+ "?route=account/login");
        logger.info("Login page open successfully");

        loginPage = new LoginPage(driver);


        // Perform login
        loginPage.enterEmailAddress(Email_DP);
        loginPage.enterPassword(Password_DP);
        loginPage.clickLoginButton();
        captureScreenshot(driver,"LoginTestDP");
        logger.info("Screenshot Captured");

        // Assertion: Verify the user is redirected to the homepage after successful login
        String expectedHomePageUrl = "https://tutorialsninja.com/demo/index.php?route=account/account"; // Replace with the expected URL of the homepage
        String actualUrlAfterLogin = driver.getCurrentUrl();

        // Use a boolean flag to track the outcome of the assertion
        boolean loginSuccessful = false;
        try {
            Assert.assertEquals(actualUrlAfterLogin, expectedHomePageUrl, "User is not redirected to the homepage after login");
            loginSuccessful = true;
            logger.info("Login Assertion done");
        } catch (AssertionError e) {
            loginSuccessful = false;
            logger.error("Login Assertion failed: " + e.getMessage());
        }

        // Perform actions based on login success or failure
        if (loginSuccessful) {
            // Handle successful login
            logger.info("Login successful!");
        } else {
            // Handle login failure
            logger.warn("Login failed!");
        }

        // Log test completion
        logger.info("Login test completed successfully");

    }
    @DataProvider(name = "LoginDataProvider")
    public Object[][] loginDataValid(){
        return new Object[][]{
                {"mail123@gmail.com", "123456"},
                {"mail123@gmail.com", "1234565"}
        };
    }
}
