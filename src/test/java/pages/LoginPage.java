package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // === Locators ===
    By loginLink = By.linkText("Log in");
    By emailField = By.id("Email");
    By passwordField = By.id("Password");
    By loginButton = By.cssSelector("input[value='Log in']");
    By rememberMeCheckbox = By.id("RememberMe");
   By logoutLink = By.xpath("//a[@class='ico-logout']");

    // === Error Messages ===
    // Common login error
    By errorMessage = By.xpath("//li[contains(text(),'Login was unsuccessful')] | //li[normalize-space()='No customer account found']");
   
    // Specific: Invalid Email Format (only when email is syntactically wrong)
    By errorInvalidEmailFormat = By.xpath("//span[@for='Email']");

    // === Actions ===
    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void clickRememberMe() {
        driver.findElement(rememberMeCheckbox).click();
    }

    public boolean isLoginSuccessful() {
    	
    	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink));
    	        return true;
    	    
    }
    public String getErrorMessage() {
        try {
            return driver.findElement(errorMessage).getText();
        } catch (Exception e) {
            return "";
        }
    }

    public String getInvalidEmailErrorMessage() {
        try {
            return driver.findElement(errorInvalidEmailFormat).getText();
        } catch (Exception e) {
            return "";
        }
    }

    
}
