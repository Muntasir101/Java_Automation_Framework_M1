package locators;

import org.openqa.selenium.By;

public class LoginPageLocators {
    public static final By EMAIL_INPUT = By.cssSelector("input#input-email");
    public static final By PASSWORD_INPUT = By.cssSelector("input#input-password");
    public static final By LOGIN_BUTTON = By.cssSelector("[action] .btn-primary");
}
