package pages;

import base.BasePage;
import locators.LoginPageLocators;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmailAddress(String email) {
        findElementAndTypeText(LoginPageLocators.EMAIL_INPUT, email);
    }

    public void enterPassword(String password) {
        findElementAndTypeText(LoginPageLocators.PASSWORD_INPUT, password);
    }

    public void clickLoginButton() {
        findElementAndClick(LoginPageLocators.LOGIN_BUTTON);
    }
}
