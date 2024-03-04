package base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected static WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Specify timeout in seconds
    }

    // Method to find a WebElement by a given locator
    protected static WebElement findElement(By locator) {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            throw new NoSuchElementException("Element not found with locator: " + locator.toString());
        }
    }


    // Method to enter text into a text field
    protected void findElementAndTypeText(By locator, String text) {
        WebElement element = findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected void findElementAndClick(By locator) {
        WebElement element = findElement(locator);
        element.click();
    }


    // Method to retrieve text from a WebElement
    protected String getText(By locator) {
        return findElement(locator).getText();
    }

    // Method to check if a WebElement is displayed
    protected boolean isDisplayed(By locator) {
        return findElement(locator).isDisplayed();
    }

    // Method to check if a WebElement is enabled
    protected boolean isEnabled(By locator) {
        return findElement(locator).isEnabled();
    }

    // Method to check if a WebElement is selected
    protected boolean isSelected(By locator) {
        return findElement(locator).isSelected();
    }

    // Method to get attribute value of a WebElement
    protected String getAttributeValue(By locator, String attribute) {
        return findElement(locator).getAttribute(attribute);
    }
    // Method to wait for a WebElement to be clickable
    protected void waitForElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Method to wait for a WebElement to be visible
    protected void waitForElementToBeVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Method to get the title of the current page
    protected String getPageTitle() {
        return driver.getTitle();
    }

    // Method to get the current URL
    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // Method to navigate to a specific URL
    protected void navigateTo(String url) {
        driver.navigate().to(url);
    }

    // Method to refresh the current page
    protected void refreshPage() {
        driver.navigate().refresh();
    }

    // Method to get the source code of the current page
    protected String getPageSource() {
        return driver.getPageSource();
    }

    // Method to close the current window
    protected void closeCurrentWindow() {
        driver.close();
    }

    // Method to quit the driver and close all associated windows
    protected void quitDriver() {
        driver.quit();
    }

}