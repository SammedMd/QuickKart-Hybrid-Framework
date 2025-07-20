package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By LoginLink = By.className("ico-login");
    By emailInput = By.id("Email");
    By passwordInput = By.id("Password");
    By rememberClick = By.id("RememberMe");
    By loginButton = By.xpath("//input[@value='Log in']");
    By errorMessage = By.xpath("//div[@class='validation-summary-errors']");
    By accountLink = By.className("account");

    // Actions
    public void clickLoginLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(LoginLink));
        loginLink.click();
    }

    public boolean isLoginPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void enterEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(String pass) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(pass);
    }

    public void clickRememberMe() {
        driver.findElement(rememberClick).click();
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        try {
            return driver.findElement(errorMessage).getText();
        } catch (Exception e) {
            return "";
        }
    }

    public boolean isLoginSuccessful() {
        try {
            return driver.findElement(accountLink).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
