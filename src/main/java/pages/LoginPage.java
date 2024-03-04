package pages;

import base.BasePage;
import locators.LoginPageLocators;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import static org.apache.logging.log4j.LogManager.*;

public class LoginPage extends BasePage {
    private static final Logger logger = getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmailAddress(String email) {
        findElementAndTypeText(LoginPageLocators.EMAIL_INPUT, email);
        logger.info("Email: "+email + " Type successfully");
    }

    public void enterPassword(String password) {
        findElementAndTypeText(LoginPageLocators.PASSWORD_INPUT, password);
        logger.info("Password: "+password + " Type successfully");
    }

    public void clickLoginButton() {
        findElementAndClick(LoginPageLocators.LOGIN_BUTTON);
        logger.info("Click Login Button successfully");
    }
}
