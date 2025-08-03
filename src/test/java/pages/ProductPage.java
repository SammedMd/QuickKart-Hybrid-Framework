package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
WebDriver driver; 

By addtoCartButton = By.xpath("//input[@value='Add to cart']");
By cartSuccessMsg = By.xpath("//p[@class='content']");

public ProductPage(WebDriver driver) {
	this.driver = driver;
}

public void clickAddToCart() {
	driver.findElement(addtoCartButton).click();
}

public String getCartSuccessMessage() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfElementLocated(cartSuccessMsg)); // 👈 wait until it's visible
    return driver.findElement(cartSuccessMsg).getText();
}
}
