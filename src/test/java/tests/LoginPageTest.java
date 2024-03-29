package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.PropertyReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class LoginPageTest extends BaseTest {

    private LoginPage loginPage;

    private static final Logger logger = LogManager.getLogger(LoginPageTest.class);

    @Test
    @Description("Test login functionality")
    public void testLogin() throws FileNotFoundException {
        PropertyReader propertyReader = new PropertyReader("src/main/java/config/baseConfig.properties");
        // Read properties
        String baseUrl = propertyReader.getProperty("baseUrl");
        // Initialize LoginPage
        driver.get(baseUrl+ "?route=account/login");
        logger.info("Login page open successfully");


        loginPage = new LoginPage(driver);

        // Test data
        //String email = "mail123@gmail.com";
        //String password = "123456";

        // Read the JSON file
        JsonObject jsonObject = JsonParser.parseReader(new FileReader("src/main/java/data/valid_users.json")).getAsJsonObject();

        // Extract email and password
        String email = jsonObject.get("email").getAsString();
        String password = jsonObject.get("password").getAsString();


        // Perform login
        loginPage.enterEmailAddress(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        // Assertion: Verify the user is redirected to the homepage after successful login
        String expectedHomePageUrl = "https://tutorialsninja.com/demo/index.php?route=account/account"; // Replace with the expected URL of the homepage
        String actualUrlAfterLogin = driver.getCurrentUrl();
        Assert.assertEquals(actualUrlAfterLogin, expectedHomePageUrl, "User is not redirected to the homepage after login");
        logger.info("Login Assertion done");

        // Log test completion
        logger.info("Login test completed successfully");
    }
}
