package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // ✅ Locator for Logout link (CSS Selector is more stable than full XPath)
    By logoutLink = By.cssSelector("a.ico-logout");

    // ✅ Click Logout button
    public void clickLogout() {
        driver.findElement(logoutLink).click();
    }

    // ✅ Optional: Check if logout is visible (helpful for validations/debugging)
    public boolean isLogoutVisible() {
        return driver.findElements(logoutLink).size() > 0;
    }
}
