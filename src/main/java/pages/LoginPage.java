package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By emailInput = By.cssSelector("input#input-email");
    private final By passwordInput = By.cssSelector("input#input-password");
    private final By loginButton = By.cssSelector("[action] .btn-primary");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmailAddress(String email) {
        waitForElementToBeClickable(emailInput);
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        waitForElementToBeClickable(passwordInput);
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        waitForElementToBeClickable(loginButton);
        driver.findElement(loginButton).click();
    }
}
