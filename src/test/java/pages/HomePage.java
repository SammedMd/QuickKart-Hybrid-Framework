package pages;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;
    Logger logger = LogManager.getLogger(this.getClass());

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By logoutLink = By.xpath("//a[@class='ico-logout']");

    public void clickLogoutLink() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            logger.info("Waiting for header section to load...");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='header-links']")));

            List<WebElement> logoutLinks = driver.findElements(logoutLink);
            if (logoutLinks.isEmpty()) {
                logger.warn("⚠️ Logout link not present in the DOM.");
            } else {
                logger.info("Logout link found. Attempting to click...");
                WebElement logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(logoutLinks.get(0)));
                logoutBtn.click();
                logger.info("✅ Logout clicked successfully.");
            }

        } catch (Exception e) {
            logger.error("❌ Failed to click Logout: " + e.getMessage(), e);
            throw e;
        }
    }
}
