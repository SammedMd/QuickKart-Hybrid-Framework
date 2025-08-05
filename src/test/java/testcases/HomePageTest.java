package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;

public class HomePageTest extends BaseClass {

    HomePage homePage;

    @Test(priority = 1)
    public void validateSliderBannerNavigation() {
        logger.info("Starting slider banner click test...");

        homePage = new HomePage(getDriver());
        homePage.clickSliderBanner();

        // ✅ Validate full redirection
        String expectedUrl = "https://www.tricentis.com/solutions/speed";
        String actualUrl = getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Redirection URL is incorrect.");

        logger.info("Banner click redirected to: " + actualUrl);

        // 🔙 Go back to home page
        getDriver().navigate().back();
        logger.info("Used browser back to return to DemoWebShop.");

        // ✅ Wait for home page confirmation
        homePage.HomePageVisible();
    }

    @Test(priority = 2)
    public void validateTopMenuNavigation() {
        logger.info("Starting Home Page Top Menu Navigation Test...");

        homePage = new HomePage(getDriver());

        homePage.clickOnTopMenu("Books");
        Assert.assertTrue(homePage.getPageTitle().contains("Books"));
        getDriver().navigate().back();

        homePage.clickOnTopMenu("Computers");
        Assert.assertTrue(homePage.getPageTitle().contains("Computers"));
        getDriver().navigate().back();

        homePage.clickOnTopMenu("Electronics");
        Assert.assertTrue(homePage.getPageTitle().contains("Electronics"));
        getDriver().navigate().back();

        homePage.clickOnTopMenu("Apparel & Shoes");
        Assert.assertTrue(homePage.getPageTitle().contains("Apparel"));
        getDriver().navigate().back();

        homePage.clickOnTopMenu("Digital downloads");
        Assert.assertTrue(homePage.getPageTitle().contains("Digital"));
        getDriver().navigate().back();

        homePage.clickOnTopMenu("Jewelry");
        Assert.assertTrue(homePage.getPageTitle().contains("Jewelry"));
        getDriver().navigate().back();

        homePage.clickOnTopMenu("Gift Cards");
        Assert.assertTrue(homePage.getPageTitle().contains("Gift Cards"));
        getDriver().navigate().back();

        logger.info("Home Page navigation verified successfully.");
    }
}
