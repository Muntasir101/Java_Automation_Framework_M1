package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import utils.PropertyReader;

public class LoginPageTest extends BaseTest {

    private LoginPage loginPage;

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

        // Perform login
        loginPage.enterEmailAddress(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }
}
