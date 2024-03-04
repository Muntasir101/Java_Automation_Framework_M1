package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import utils.PropertyReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPageTest extends BaseTest {

    private LoginPage loginPage;

    private static final Logger logger = LogManager.getLogger(LoginPageTest.class);

    @Test
    public void testLogin() {
        PropertyReader propertyReader = new PropertyReader("src/main/java/config/baseConfig.properties");
        // Read properties
        String baseUrl = propertyReader.getProperty("baseUrl");
        // Initialize LoginPage
        driver.get(baseUrl+ "?route=account/login");

        loginPage = new LoginPage(driver);

        // Test data
        String email = "mail123@gmail.com";
        String password = "123456";

        // Log test data
        logger.info("Test data - Email: {}, Password: {}", email, password);

        // Perform login
        loginPage.enterEmailAddress(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        // Log test completion
        logger.info("Login test completed successfully");
    }
}
