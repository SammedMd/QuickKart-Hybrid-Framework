package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.SearchPage;

public class AddToCartTest extends BaseClass {

    @Test(priority = 1)
    public void checkAddToCart_EliteDesktopPC() {
        logger.info("🔍 Checking 'Add to Cart' for: Elite Desktop PC");

        // Step 1: Open home page
        getDriver().get("https://demowebshop.tricentis.com/");

        // Step 2: Search and open product
        SearchPage sp = new SearchPage(getDriver());
        sp.enterProductName("Elite Desktop PC");
        sp.clickSearchButton();
        sp.clickFirstProduct();

        // Step 3: Validate Add to Cart
        validateAddToCart("EliteDesktopPC");
    }

    public void validateAddToCart(String productName) {
        List<WebElement> addToCartButtons = getDriver().findElements(By.xpath("//input[@value='Add to cart']"));

        if (addToCartButtons.size() > 0 && addToCartButtons.get(0).isDisplayed()) {
            logger.info("'Add to Cart' is visible for: " + productName);
        } else {
            logger.warn("'Add to Cart' is NOT visible for: " + productName);
            throw new RuntimeException("CAPTURE_SCREENSHOT: 'Add to Cart' button not found for: " + productName);
        }
    }
}
