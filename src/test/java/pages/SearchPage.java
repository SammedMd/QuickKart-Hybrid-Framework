package pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
    WebDriver driver;

    // Locators
    By searchBox = By.xpath("//input[@id='small-searchterms']");
    By searchButton = By.xpath("//input[@value='Search']");
    By firstProductLink = By.xpath("(//h2[@class='product-title']/a)[1]");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterProductName(String productName) {
        driver.findElement(searchBox).click(); // <== add this line if focus is needed
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(productName);
    }


    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public void clickFirstProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productLink = wait.until(ExpectedConditions.elementToBeClickable(firstProductLink));
        productLink.click();
    }

}

