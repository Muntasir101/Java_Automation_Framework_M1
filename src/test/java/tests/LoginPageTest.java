package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPageTest extends BaseTest {

    private LoginPage loginPage;

    @Test
    public void testLogin() {
        // Initialize LoginPage
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
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
