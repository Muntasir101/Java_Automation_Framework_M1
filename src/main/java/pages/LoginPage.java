package pages;

import base.BasePage;
import locators.LoginPageLocators;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmailAddress(String email) {
        waitForElementToBeClickable(LoginPageLocators.EMAIL_INPUT);
        driver.findElement(LoginPageLocators.EMAIL_INPUT).clear();
        driver.findElement(LoginPageLocators.EMAIL_INPUT).sendKeys(email);
    }

    public void enterPassword(String password) {
        waitForElementToBeClickable(LoginPageLocators.PASSWORD_INPUT);
        driver.findElement(LoginPageLocators.PASSWORD_INPUT).clear();
        driver.findElement(LoginPageLocators.PASSWORD_INPUT).sendKeys(password);
    }

    public void clickLoginButton() {
        waitForElementToBeClickable(LoginPageLocators.LOGIN_BUTTON);
        driver.findElement(LoginPageLocators.LOGIN_BUTTON).click();
    }
}
