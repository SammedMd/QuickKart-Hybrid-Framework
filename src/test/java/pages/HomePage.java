package pages;

import java.time.Duration;

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
    By loginLink = By.xpath("//a[@class='ico-login']");
    By registerLink = By.xpath("//a[@class='ico-register']");
    By bannerLink = By.xpath("//div[@class='nivoSlider']/a");

    public void clickLogoutLink() {
        logger.info("Clicking Logout link...");
        WebElement logoutBtn = driver.findElement(logoutLink);
        if (logoutBtn.isDisplayed()) {
            logoutBtn.click();
            logger.info("Logout clicked successfully.");
        } else {
            logger.warn("Logout link not visible.");
        }
    }

    public void clickLoginLink() {
        logger.info("Clicking Login link...");
        driver.findElement(loginLink).click();
    }

    public void clickRegisterLink() {
        logger.info("Clicking Register link...");
        driver.findElement(registerLink).click();
    }

    public void clickOnTopMenu(String menuName) {
        logger.info("Clicking on menu: " + menuName);
        driver.findElement(By.xpath("//ul[@class='top-menu']//a[normalize-space()='" + menuName + "']")).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void clickSliderBanner() {
        logger.info("Clicking the slider banner...");
        driver.findElement(bannerLink).click();
    }
    public void HomePageVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.titleContains("Demo Web Shop")); // ✅ Title check is stable
        logger.info("Returned to Demo Web Shop homepage.");
    }

}
