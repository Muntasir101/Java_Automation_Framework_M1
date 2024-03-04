package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final WebDriver driver;
    private WebElement EmailAddress;
    private WebElement Password_field;
    private WebElement LoginButton;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        initializeElements();
    }

    private void initializeElements(){
        EmailAddress = driver.findElement(By.cssSelector("input#input-email"));
        Password_field = driver.findElement(By.cssSelector("input#input-password"));
        LoginButton = driver.findElement(By.cssSelector("[action] .btn-primary"));
    }

    public void enterEmailAddress(String email){
        EmailAddress.clear();
        EmailAddress.sendKeys(email);
    }
    public void enterPassword(String password){
        Password_field.clear();
        Password_field.sendKeys(password);
    }
    public void clickLoginButton(){
        LoginButton.click();
    }

}
