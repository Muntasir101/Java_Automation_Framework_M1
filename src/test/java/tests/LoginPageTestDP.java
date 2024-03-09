package tests;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.PropertyReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class LoginPageTestDP extends BaseTest {

    private LoginPage loginPage;

    private static final Logger logger = LogManager.getLogger(LoginPageTestDP.class);

    @Test(dataProvider = "LoginValidDataProvider")
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

        // Log test completion
        logger.info("Login test completed successfully");
    }
    @DataProvider(name = "LoginValidDataProvider")
    public Object[][] loginDataValid(){
        return new Object[][]{
                {"mail123@gmail.com", "123456"}
        };
    }
}
